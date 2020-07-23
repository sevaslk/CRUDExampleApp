package com.sevaslk.crudexampleapp;

import java.io.FileNotFoundException;

class Main {
    public static void main(String[] args) throws FileNotFoundException {
        SkillRepository.create("SQL");

        SkillRepository.create("SQL");
        System.out.println(SkillRepository.getByID(1));
        SkillRepository.update(1L, "PHP");
        System.out.println(SkillRepository.getByID(1));
        SkillRepository.deleteByID(1L);

    }
}
