package com.sevaslk.crudexampleapp.controller;

import com.sevaslk.crudexampleapp.model.Account;
import com.sevaslk.crudexampleapp.model.AccountStatus;
import com.sevaslk.crudexampleapp.repository.AccountRepository;
import com.sevaslk.crudexampleapp.repository.io.JavaIOAccountRepositoryImpl;

import java.io.IOException;
import java.util.List;

public class AccountController {
    private AccountRepository repository = new JavaIOAccountRepositoryImpl();

    public Account createAccount() throws IOException {
        return repository.save(new Account(null, null));
    }

    public Account updateAccount(Long id, String status) throws IOException {
        return repository.update(new Account(id, AccountStatus.valueOf(status)));
    }

    public Account findAccountByID(Long id) throws IOException {
        return repository.getById(id);
    }

    public List<Account> getAllAccounts() throws IOException {
        return repository.getAll();
    }

    public void deleteAccountById(Long id) throws IOException {
        repository.deleteById(id);
    }

}
