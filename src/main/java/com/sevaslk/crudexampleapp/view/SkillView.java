package com.sevaslk.crudexampleapp.view;

import com.sevaslk.crudexampleapp.controller.SkillController;
import com.sevaslk.crudexampleapp.model.Skill;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SkillView {
    private final SkillController controller = new SkillController();
    private final Scanner scanner = new Scanner(System.in);

    public void createSkill() throws IOException {
        System.out.println("Enter new name:");
        String newName = this.scanner.nextLine();
        System.out.println(controller.createSkill(newName));
    }

    public void updateSkill() throws IOException {
        System.out.println("Enter ID:");
        Long id = this.scanner.nextLong();
        System.out.println("Enter updated name:");
        String newName = this.scanner.nextLine();
        System.out.println(controller.updateSkill(id, newName));
    }

    public void findSkillByID() throws IOException {
        System.out.println("Enter ID:");
        Long id = this.scanner.nextLong();
        System.out.println(controller.findSkillByID(id));
    }

    public void getAll() throws IOException {
        System.out.println(controller.getAll());
    }

    public void deleteById() throws IOException {
        System.out.println("Enter ID:");
        Long id = this.scanner.nextLong();
        controller.deleteById(id);
    }

//    public String getNewSkillName() {
//        String s;
//        try (Scanner scanner = new Scanner(System.in)) {
//            System.out.println("Enter new skill name:");
//            synchronized (SkillView.class) {
//                s = scanner.nextLine();
//            }
//        }
//        return s;
//    }
//
//    private Long getSkillId() throws IOException {
//        try (BufferedReader readerId = new BufferedReader(new InputStreamReader(System.in))) {
//            System.out.println("Enter skill ID:");
//            return Long.parseLong(readerId.readLine());
//        }
//    }

}
