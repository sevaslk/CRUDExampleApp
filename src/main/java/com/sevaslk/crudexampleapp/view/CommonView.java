package com.sevaslk.crudexampleapp.view;

import java.io.IOException;
import java.util.Scanner;

public class CommonView {

    public void start() throws IOException {
        selectOperation(selectEntity());
        getContinue();
    }

    private void getContinue() throws IOException {
        System.out.println("Do you want to proceed?\n" +
                "'1' - yes\n" +
                "'0' - no\n" +
                "make your choice:\n");
        int userChoice = getUserChoice();
        if (userChoice == 1) {
            start();
        } else if (userChoice == 0) {
            System.exit(0);
        } else {
            getContinue();
        }
    }

    private void selectOperation(CurrentView currentView) throws IOException {
        System.out.println("To create press '1'\n" +
                "to change press '2'\n" +
                "to search press '3'\n" +
                "to delete press '4'\n" +
                "to view press '5'\n" +
                "to exit press '0'\n" +
                "make your choice:\n");
        int userChoice = getUserChoice();

        if (userChoice == 1) {
            currentView.create();
        } else if (userChoice == 2) {
            currentView.update();
        } else if (userChoice == 3) {
            currentView.findByID();
        } else if (userChoice == 4) {
            currentView.deleteByID();
        } else if (userChoice == 5) {
            currentView.getAll();
        } else if (userChoice == 0) {
            System.exit(0);
        } else {
            selectOperation(currentView);
        }
    }

    private CurrentView selectEntity() {
        System.out.println("Select a section for processing.\n" +
                "\n" +
                "for 'account' operations press '1'\n" +
                "for 'developer' operations press '2'\n" +
                "for 'skill' operations press '3'\n" +
                "to exit press '0'\n" +
                "make your choice: \n");
        int userChoice = getUserChoice();

        CurrentView currentView;
        if (userChoice == 1) {
            currentView = new AccountView();
            return currentView;
        }
        if (userChoice == 2) {
            currentView = new DeveloperlView();
            return currentView;
        }
        if (userChoice == 3) {
            currentView = new SkillView();
            return currentView;
        }
        if (userChoice == 0) {
            System.exit(0);
        }
        selectEntity();
        return null;
    }

    private int getUserChoice() {
        return new Scanner(System.in).nextInt();
    }
}
