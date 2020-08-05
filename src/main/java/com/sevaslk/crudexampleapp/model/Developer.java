package main.java.com.sevaslk.crudexampleapp.model;

import java.util.List;

class Developer {
    private Long id;
    private String name;
    private List<Skill> skill;
    private Account account;

    public Developer(Long id, String name, Account account) {
        this.id = id;
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
