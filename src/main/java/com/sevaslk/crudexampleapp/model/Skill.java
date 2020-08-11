package com.sevaslk.crudexampleapp.model;

import java.util.Objects;

public class Skill {
    private Long id;
    private String name;

    public Skill(Long id, String skill) {
        this.id = id;
        this.name = skill;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return id + "," + name + '/';
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill1 = (Skill) o;
        return id == skill1.id &&
                Objects.equals(name, skill1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
