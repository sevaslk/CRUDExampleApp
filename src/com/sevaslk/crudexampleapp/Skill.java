package com.sevaslk.crudexampleapp;

class Skill {
    private static long countID = 0;
    private long ID;
    private String skill;

    Skill(String skill) {
        countID++;
        this.ID = countID;
        this.skill = skill;
    }

    public static long getCountID() {
        return countID;
    }

    public long getID() {
        return ID;
    }

    public String getSkill() {
        return skill;
    }
}
