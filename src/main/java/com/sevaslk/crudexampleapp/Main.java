package com.sevaslk.crudexampleapp;

import com.sevaslk.crudexampleapp.view.AccountView;
import com.sevaslk.crudexampleapp.view.DeveloperlView;
import com.sun.prism.shader.DrawEllipse_LinearGradient_REFLECT_AlphaTest_Loader;
import com.sevaslk.crudexampleapp.model.Account;
import com.sevaslk.crudexampleapp.model.AccountStatus;
import com.sevaslk.crudexampleapp.model.Developer;
import com.sevaslk.crudexampleapp.model.Skill;
import com.sevaslk.crudexampleapp.repository.SkillRepository;
import com.sevaslk.crudexampleapp.repository.io.JavaIOAccountRepositoryImpl;
import com.sevaslk.crudexampleapp.repository.io.JavaIODeveloperRepositoryImpl;
import com.sevaslk.crudexampleapp.repository.io.JavaIOSkillRepositoryImpl;
import com.sevaslk.crudexampleapp.view.SkillView;

import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {

        SkillView skillView = new SkillView();
//        skillView.getAllSkills();
//        skillView.createSkill();
//        skillView.updateSkill();
//        skillView.findSkillByID();
//        skillView.deleteSkillById();
//        skillView.getAllSkills();

        DeveloperlView developerlView = new DeveloperlView();
//        developerlView.getAllDevelopers();
//        developerlView.createDeveloper();
//        developerlView.updateDeveloper();
//        developerlView.findDeveloperByID();
//        developerlView.deleteDeveloperById();
//        developerlView.getAllDevelopers();

        AccountView accountView = new AccountView();
//        accountView.getAllAccounts();
//        accountView.createAccount();
//        accountView.updateAccount();
//        accountView.findAccountByID();
//        accountView.deleteAccountById();
//        accountView.getAllAccounts();
    }
}
