package com.sevaslk.crudexampleapp;

class Developer {
    private String name;
    private Skill skillSet;
    private Account account;
    private AccountStatus accountStatus;

    public Developer(String name, Account account, AccountStatus accountStatus) {
        this.name = name;
        this.account = account;
        this.accountStatus = accountStatus;
    }

    public void setSkillSet(Skill skillSet) {
        this.skillSet = skillSet;
    }

    public String getName() {
        return name;
    }

    public Skill getSkillSet() {
        return skillSet;
    }

    public Account getAccount() {
        return account;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }
}
