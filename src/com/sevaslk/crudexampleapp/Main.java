package com.sevaslk.crudexampleapp;

import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {

        SkillRepository repo = new SkillRepository();

//        Skill skillToUpdate = new Skill(1L, "OOP");
//        Skill updatedSkill = repo.update(skillToUpdate);
//        System.out.println(updatedSkill);
//        System.out.println(repo.getAll());
//
//        System.out.println(repo.getByID(2));
//
//        repo.deleteByID(2L);
//        System.out.println(repo.getAll());

        Skill skillToSave = new Skill(null, "Mockito");
        repo.save(skillToSave);
        System.out.println(repo.getAll());

    }
}
