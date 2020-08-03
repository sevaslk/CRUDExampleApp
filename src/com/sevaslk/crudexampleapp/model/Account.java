package com.sevaslk.crudexampleapp.model;

import com.sevaslk.crudexampleapp.AccountStatus;

class Account {
    private int id;
    private AccountStatus status;

    public Account(int id, AccountStatus status) {
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public AccountStatus getStatus() {
        return status;
    }
}
