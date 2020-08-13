package com.sevaslk.crudexampleapp.view;

import com.sevaslk.crudexampleapp.controller.SkillController;

import java.io.IOException;
import java.util.Scanner;

public class SkillView implements CurrentView {
    private final SkillController controller = new SkillController();
    private final Scanner scanner = new Scanner(System.in);

    public void create() throws IOException {
        System.out.println("Enter new skill:");
        String newName = this.scanner.nextLine();
        System.out.println(controller.createSkill(newName));
    }

    public void update() throws IOException {
        System.out.println("Enter new skill:");
        String newName = this.scanner.nextLine();
        System.out.println("Enter skill ID:");
        Long id = this.scanner.nextLong();
        System.out.println(controller.updateSkill(id, newName));
    }

    public void findByID() throws IOException {
        System.out.println("Enter skill ID:");
        Long id = this.scanner.nextLong();
        System.out.println(controller.findSkillByID(id));
    }

    public void getAll() throws IOException {
        System.out.println(controller.getAllSkills());
    }

    public void deleteByID() throws IOException {
        System.out.println("Enter skill ID:");
        Long id = this.scanner.nextLong();
        controller.deleteSkillById(id);
    }

}
