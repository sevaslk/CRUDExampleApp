package com.sevaslk.crudexampleapp.view;

import com.sevaslk.crudexampleapp.controller.DeveloperController;

import java.io.IOException;
import java.util.Scanner;

public class DeveloperlView {
    private final DeveloperController controller = new DeveloperController();
    private final Scanner scanner = new Scanner(System.in);

    public void createDeveloper() throws IOException {
        System.out.println("Enter new developer name:");
        String newName = this.scanner.nextLine();
        System.out.println(controller.createDeveloper(newName));
    }

    public void updateDeveloper() throws IOException {
        System.out.println("Enter new developer name:");
        String newName = this.scanner.nextLine();
        System.out.println("Enter developer ID:");
        Long id = this.scanner.nextLong();
        System.out.println(controller.updateDeveloper(id,newName));
    }

    public void findDeveloperByID() throws IOException {
        System.out.println("Enter developer ID:");
        Long id = this.scanner.nextLong();
        System.out.println(controller.findDeveloperByID(id));
    }

    public void getAllDevelopers() throws IOException {
        System.out.println(controller.getAllDevelopers());
    }

    public void deleteDeveloperById() throws IOException {
        System.out.println("Enter developer ID:");
        Long id = this.scanner.nextLong();
        controller.deleteDeveloperById(id);
    }

}
