package com.sevaslk.crudexampleapp.repository;

import com.sevaslk.crudexampleapp.model.Skill;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SkillRepository {

    private final String SKILLS_TXT = "C:\\Users\\s\\IdeaProjects\\CRUDExampleApp\\src\\com\\sevaslk\\crudexampleapp\\resources\\skills.txt";

    public Skill getByID(long id) throws IOException {
        String files = readFile();
        String[] skillsStringArray = files.split("/");
        for (String skill : skillsStringArray) {
            String[] skillItemStringArray = skill.split(",");
            if (Long.parseLong(skillItemStringArray[0]) == id) {
                return new Skill(id, skillItemStringArray[1]);
            }
        }
        throw new IOException("Skill doesn't exist.");
    }

    public Skill getByID_StreamAPI(Long id) throws IOException {
        List<Skill> skillList = getSkills();
        return skillList.stream()
                .filter(skill -> skill.getId() == id)
                .findFirst().orElse(null);
    }

    public Skill getByName(Skill skill) throws IOException {
        List<Skill> skillList = getSkills();
        for (Skill element : skillList) {
            if (element.getName().equalsIgnoreCase(skill.getName())) {
                return element;
            }
        }
        return null;
    }

    public Skill getByName_StreamAPI(Skill skill) throws IOException {
        List<Skill> skillList = getSkills();
        return skillList.stream()
                .filter(skillItem -> skillItem.getName().equalsIgnoreCase(skill.getName()))
                .findFirst().orElse(null);
    }

    public List<Skill> getAll() throws IOException {
        return getSkills();
    }

    public Skill update(Skill newSkill) throws IOException {
        List<Skill> skillList = getSkills();
        for (int i = 0; i < skillList.size(); i++) {
            Skill element = skillList.get(i);
            if (element.getId() == newSkill.getId()) {
                skillList.set(i, newSkill);
            }
        }
        if (skillList.equals(getSkills())) {
            return null;
        }
        writeStringToFile(convertListToString(skillList));
        return newSkill;
    }

    public Skill save(Skill newSkill) throws IOException {
        if (Files.exists(Paths.get(SKILLS_TXT))) {
            List<Skill> skillList = getSkills();
            if (getByName(newSkill) == null) {
                skillList.add(new Skill(skillList.get(skillList.size() - 1).getId() + 1, newSkill.getName()));
                writeStringToFile(convertListToString(skillList));
            } else {
                return null;
            }
        } else {
            Files.createFile(Paths.get(SKILLS_TXT));
            save(newSkill);
        }
        return newSkill;
    }

    public Skill deleteByID(Long id) throws IOException {
        List<Skill> skillList = getSkills();
        Skill temp = null;
        for (int i = 0; i < skillList.size(); i++) {
            if (skillList.get(i).getId() == id) {
                temp = skillList.get(i);
                skillList.remove(skillList.get(i));
            }
        }
        writeStringToFile(convertListToString(skillList));
        return temp;
    }

    public List<Skill> deleteByID_RemoveIf(Long id) throws IOException {
        List<Skill> skillList = getSkills();
        skillList.removeIf(item -> item.getId() == id);
        writeStringToFile(convertListToString(skillList));
        return skillList;
    }

    private List<Skill> getSkills() throws IOException {
        List<Skill> skillList = new ArrayList<>();
        String files = readFile();
        String[] skillsStringArray = files.split("/");
        for (String element : skillsStringArray) {
            String[] skillItemStringArray = element.split(",");
            skillList.add(new Skill(Long.parseLong(skillItemStringArray[0]), skillItemStringArray[1]));
        }
        return skillList;
    }

    private String getNewSkillName() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Enter new skill name:");
            return reader.readLine();
        }
    }

    private void writeStringToFile(String string) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(SKILLS_TXT)) {
            byte[] strBytes = string.getBytes();
            fileOutputStream.write(strBytes);
        }
    }

    private String readFile() throws IOException {
        return new String(Files.readAllBytes(Paths.get(SKILLS_TXT)));
    }

    private String convertListToString(List<Skill> skills) {
        return skills.stream().map(String::valueOf).sorted().collect(Collectors.joining());
    }

}

