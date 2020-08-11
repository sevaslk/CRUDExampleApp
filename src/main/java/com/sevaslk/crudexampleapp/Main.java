package com.sevaslk.crudexampleapp;

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

        JavaIOSkillRepositoryImpl repoSkill = new JavaIOSkillRepositoryImpl();
        JavaIODeveloperRepositoryImpl repoDev = new JavaIODeveloperRepositoryImpl();
        JavaIOAccountRepositoryImpl repoAcc = new JavaIOAccountRepositoryImpl();
        SkillRepository skillRepository = new JavaIOSkillRepositoryImpl();
//
//        System.out.println(repoSkill.update(new Skill(2L, "OOps")));
//        System.out.println(repoSkill.getAll());
//        System.out.println(repoDev.update(new Developer(2L, "Sam")));
//        System.out.println(repoDev.getAll());
//        System.out.println(repoAcc.update(new Account(123, AccountStatus.ACTIVE)));
//        System.out.println(repoAcc.getAll());
//
//        System.out.println(repoSkill.getById(3L));
//
//        repoSkill.deleteById(2L);
//        System.out.println(repoSkill.getAll());
//        repoDev.deleteById(2L);
//        System.out.println(repoDev.getAll());
//        repoAcc.deleteById(123L);
//        System.out.println(repoAcc.getAll());
//
//        System.out.println(repoSkill.save(new Skill(null, "Mockito")));
//        System.out.println(repoSkill.getAll());
//        System.out.println(repoDev.save(new Developer(null, "Anna")));
//        System.out.println(repoDev.getAll());
//        System.out.println(repoAcc.save(new Account(5678, AccountStatus.ACTIVE)));
//        System.out.println(repoAcc.getAll());

        SkillView view = new SkillView();
//        view.getAll();
//        view.createSkill();
//        System.out.println(view.getNewSkillName());
        view.updateSkill();
//        view.findSkillByID();
//        view.deleteById();
//        view.getAll();

    }
}
