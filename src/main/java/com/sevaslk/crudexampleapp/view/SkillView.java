package main.java.com.sevaslk.crudexampleapp.view;

import main.java.com.sevaslk.crudexampleapp.controller.SkillController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SkillView {
    private SkillController controller = new SkillController();

    public void createSkill() throws IOException {
        System.out.println(controller.createSkill(getNewSkillName()));
    }

    public void updateSkill() throws IOException {
        System.out.println(controller.updateSkill(getSkillId(), "JJava"));
    }

    public void findSkillByID() throws IOException {
        System.out.println(controller.findSkillByID(getSkillId()));
    }

    public void getAll() throws IOException {
        System.out.println(controller.getAll());
    }

    public void deleteById() throws IOException {
        controller.deleteById(getSkillId());
    }

    private String getNewSkillName() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter new skill name:");
            return scanner.nextLine();
        }
    }

    private Long getSkillId() throws IOException {
        try (BufferedReader readerId = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Enter skill ID:");
            return Long.parseLong(readerId.readLine());
        }
    }
}
