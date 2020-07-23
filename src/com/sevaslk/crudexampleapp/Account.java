package com.sevaslk.crudexampleapp;

class Account {
    private int number;
    private AccountStatus status;

    public Account(int number, AccountStatus status) {
        this.number = number;
        this.status = status;
    }

    public int getNumber() {
        return number;
    }

    public AccountStatus getStatus() {
        return status;
    }
}
