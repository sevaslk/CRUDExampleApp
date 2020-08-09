package main.java.com.sevaslk.crudexampleapp.repository.io;

import main.java.com.sevaslk.crudexampleapp.model.Skill;
import main.java.com.sevaslk.crudexampleapp.repository.SkillRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JavaIOSkillRepositoryImpl implements SkillRepository {

    private final String SKILLS_TXT = "C:\\Users\\s\\IdeaProjects\\CRUDExampleApp\\src\\main\\resources\\skills.txt";

    public Skill getByName(Skill skill) throws IOException {
        List<Skill> skillList = getSkills();
        return skillList.stream()
                .filter(skillItem -> skillItem.getName().equalsIgnoreCase(skill.getName()))
                .findFirst().orElse(null);
    }

    public List<Skill> getAll() throws IOException {
        return getSkills();
    }

    public Skill getById(Long id) throws IOException {
        List<Skill> skillList = getSkills();
        return skillList.stream()
                .filter(skill -> skill.getId().equals(id))
                .findFirst().orElse(null);
    }

    public Skill update(Skill newSkill) throws IOException {
        List<Skill> skillList = getSkills();
        for (int i = 0; i < skillList.size(); i++) {
            Skill element = skillList.get(i);
            if (element.getId().equals(newSkill.getId())) {
                skillList.set(i, newSkill);
            }
        }
        if (skillList.equals(getSkills())) {
            return null;
        }
        writeStringToFile(convertListToString(skillList), SKILLS_TXT);
        return newSkill;
    }

    public void deleteById(Long id) throws IOException {
        List<Skill> skillList = getSkills();
        skillList.removeIf(item -> item.getId().equals(id));
        writeStringToFile(convertListToString(skillList), SKILLS_TXT);
    }

    public Skill save(Skill newSkill) throws IOException {
        if (Files.exists(Paths.get(SKILLS_TXT))) {
            List<Skill> skillList = getSkills();
            if (getByName(newSkill) == null) {
                skillList.add(new Skill(skillList.get(skillList.size() - 1).getId() + 1, newSkill.getName()));
                writeStringToFile(convertListToString(skillList), SKILLS_TXT);
            } else {
                return null;
            }
        } else {
            Files.createFile(Paths.get(SKILLS_TXT));
            save(newSkill);
        }
        return newSkill;
    }

    private List<Skill> getSkills() throws IOException {
        List<Skill> skillList = new ArrayList<>();
        String files = readFile(SKILLS_TXT);
        String[] skillsStringArray = files.split("/");
        for (String element : skillsStringArray) {
            String[] skillItemStringArray = element.split(",");
            skillList.add(new Skill(Long.parseLong(skillItemStringArray[0]), skillItemStringArray[1]));
        }
        return skillList;
    }

}



