package com.sevaslk.crudexampleapp;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

class SkillRepository {
    Set<Skill> skillSet = new HashSet<>();


    public static void create(String skill) throws FileNotFoundException {
        try (FileOutputStream fileOutputStream = new FileOutputStream("/123/skills.txt");
             ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
             FileWriter fileWriter = new FileWriter("/123/skills.txt")) {
            Skill skillItem = new Skill(skill);
            out.writeObject(skillItem);
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException" + e);
        } catch (IOException e) {
            System.out.println("IOException" + e);
        }
    }

    public static String getByID(long ID) {
        return null;
    }

    public static void update(Long ID, String skill) {
//        skillMap.replace(ID, skill);
    }

    public static void deleteByID(Long id) {
//        skillMap.remove(id);

    }

}

