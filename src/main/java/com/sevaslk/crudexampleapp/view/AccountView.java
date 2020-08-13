package com.sevaslk.crudexampleapp.view;

import com.sevaslk.crudexampleapp.controller.AccountController;

import java.io.IOException;
import java.util.Scanner;

public class AccountView implements CurrentView{
    private final AccountController controller = new AccountController();
    private final Scanner scanner = new Scanner(System.in);

    public void create() throws IOException {
        System.out.println("Created account: " + controller.createAccount());
    }

    public void update() throws IOException {
        System.out.println("Enter account status:");
        String status = this.scanner.nextLine();
        System.out.println("Enter account ID:");
        Long id = this.scanner.nextLong();
        System.out.println("Updated account: " + controller.updateAccount(id, status));
    }

    public void findByID() throws IOException {
        System.out.println("Enter account ID:");
        Long id = this.scanner.nextLong();
        System.out.println(controller.findAccountByID(id));
    }

    public void getAll() throws IOException {
        System.out.println(controller.getAllAccounts());
    }

    public void deleteByID() throws IOException {
        System.out.println("Enter account ID:");
        Long id = this.scanner.nextLong();
        controller.deleteAccountById(id);
    }

}
