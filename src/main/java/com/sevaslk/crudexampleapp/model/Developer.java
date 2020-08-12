package com.sevaslk.crudexampleapp.model;

import java.util.List;

public class Developer {
    private Long id;
    private String name;
    private List<Skill> skill;
    private Account account;

    public Developer(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setSkill(Skill skill) {
        this.skill = (List<Skill>) skill;
    }

    public List<Skill> getSkill() {
        return skill;
    }

    public Account getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return id + "," + name + '/';
    }

    public void setId(Long id) {
        this.id = id;
    }

}
