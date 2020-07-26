package com.sevaslk.crudexampleapp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

class SkillRepository {

    public static Skill getByID(long id) throws IOException {
        String files = readFile();
        String[] skillsStringArray = files.split("/");
        for (String skill : skillsStringArray) {
            String[] skillItemStringArray = skill.split(",");// TODO: 25.07.2020  не сплитуется по "." ???
            if (Long.parseLong(skillItemStringArray[0]) == id) {
                return new Skill(id, skillItemStringArray[1]);
            }
        }
        throw new IOException("Skill doesn't exist.");
    }

    public static List<Skill> getAll() throws IOException {
        List<Skill> skillList = new LinkedList<>();
        String files = readFile();
        String[] skillsStringArray = files.split("/");
        for (String s : skillsStringArray) {
            String[] skillItemStringArray = s.split(",");
            skillList.add(new Skill(Long.parseLong(skillItemStringArray[0]), skillItemStringArray[1]));
        }
        return skillList;
    }

    public static void update(Long id, String skill) throws IOException {
        List<Skill> skillList = new LinkedList<>();
        String files = readFile();
        String[] skillsStringArray = files.split("/");
        for (String element : skillsStringArray) {
            String[] skillItemStringArray = element.split(",");
            if (Long.parseLong(skillItemStringArray[0]) == id) {
                skillList.add(new Skill(Long.parseLong(skillItemStringArray[0]), skill));
            } else {
                skillList.add(new Skill(Long.parseLong(skillItemStringArray[0]), skillItemStringArray[1]));
            }
        }
        writeStringToFile(convertListToString(skillList));
    }

    public static void save(Long id, String skill) throws IOException {
        if (Files.exists(Paths.get("C:\\Users\\s\\IdeaProjects\\CRUDExampleApp\\src\\com\\sevaslk\\crudexampleapp\\skills.txt"))) {
            List<Skill> skillList = new LinkedList<>();
            String files = readFile();
            String[] skillsStringArray = files.split("/");
            for (String element : skillsStringArray) {
                String[] skillItemStringArray = element.split(",");
                skillList.add(new Skill(Long.parseLong(skillItemStringArray[0]), skillItemStringArray[1]));
            }
            skillList.add(new Skill(id, skill));
            writeStringToFile(convertListToString(skillList));
        } else {
            Files.createFile(Paths.get("C:\\Users\\s\\IdeaProjects\\CRUDExampleApp\\src\\com\\sevaslk\\crudexampleapp\\skills.txt"));
            save(id, skill);
        }
    }

    public static void deleteByID(Long id) throws IOException {
        List<Skill> skillList = new LinkedList<>();
        String files = readFile();
        String[] skillsStringArray = files.split("/");
        for (String s : skillsStringArray) {
            String[] skillItemStringArray = s.split(",");
            if (Long.parseLong(skillItemStringArray[0]) != id) {
                skillList.add(new Skill(Long.parseLong(skillItemStringArray[0]), skillItemStringArray[1]));
            }
        }
        writeStringToFile(convertListToString(skillList));
    }

    private static void writeStringToFile(String string) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\s\\IdeaProjects\\CRUDExampleApp\\src\\com\\sevaslk\\crudexampleapp\\skills.txt");) {
            byte[] strBytes = string.getBytes();
            fileOutputStream.write(strBytes);
        }
    }

    private static String readFile() throws IOException {
        return new String(Files.readAllBytes(Paths.get("C:\\Users\\s\\IdeaProjects\\CRUDExampleApp\\src\\com\\sevaslk\\crudexampleapp\\skills.txt")));
    }

    private static String convertListToString(List<Skill> skills) {
        return skills.stream().map(String::valueOf).sorted().sorted().collect(Collectors.joining());// TODO: 26.07.2020 map(String::valueOf) ???
    }

}

