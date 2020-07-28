package com.sevaslk.crudexampleapp;

import java.util.List;

class Developer {
    private String name;
    private List<Skill> skill;
    private Account account;

    public Developer(String name, Account account) {
        this.name = name;
        this.account = account;
    }

    public void setSkill(Skill skill) {
        this.skill = (List<Skill>) skill;
    }

    public String getName() {
        return name;
    }

    public Skill getSkill() {
        return (Skill) skill;
    }

    public Account getAccount() {
        return account;
    }
}
