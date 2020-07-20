package com.sevaslk.crudexampleapp;

class Main {
    public static void main(String[] args) {
        SkillRepository.create("SQL");
        System.out.println(SkillRepository.getByID(1));
        SkillRepository.update(1L, "PHP");
        System.out.println(SkillRepository.getByID(1));
        SkillRepository.deleteByID(1L);

    }
}
