package com.sevaslk.crudexampleapp;

import java.io.Serializable;
import java.util.Objects;

class Skill implements Serializable {
    private static long countID = 0;
    private long id;
    private String skill;

    Skill(long id, String skill) {
        this.id = id;
        this.skill = skill;
    }

    Skill(String skill) {
        countID++;
        this.id = countID;
        this.skill = skill;
    }

    public static long getCountID() {
        return countID;
    }

    public long getId() {
        return id;
    }

    public String getSkill() {
        return skill;
    }

    @Override
    public String toString() {
        return id + "," + skill  + '/';
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill1 = (Skill) o;
        return id == skill1.id &&
                Objects.equals(skill, skill1.skill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, skill);
    }
}
