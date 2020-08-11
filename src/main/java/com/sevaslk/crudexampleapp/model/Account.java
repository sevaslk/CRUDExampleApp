package com.sevaslk.crudexampleapp.model;

import java.util.Objects;

public class Account {
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

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return id + "," + status + '/';
    }

}
