package com.sevaslk.crudexampleapp;

import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {

        System.out.println(SkillRepository.getByID(1L));
        System.out.println(SkillRepository.getAll());

        SkillRepository.update("OOP");
        System.out.println(SkillRepository.getAll());

        SkillRepository.deleteByID(2L);
        System.out.println(SkillRepository.getAll());
        SkillRepository.save("Mockito");
        System.out.println(SkillRepository.getAll());
//
//        System.out.println(UUID.randomUUID());
//        System.out.println(SkillRepository.getNewSkillName());

    }
}
