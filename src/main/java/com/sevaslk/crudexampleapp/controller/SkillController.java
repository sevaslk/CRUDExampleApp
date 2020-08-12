package com.sevaslk.crudexampleapp.controller;

import com.sevaslk.crudexampleapp.model.Skill;
import com.sevaslk.crudexampleapp.repository.SkillRepository;
import com.sevaslk.crudexampleapp.repository.io.JavaIOSkillRepositoryImpl;

import java.io.IOException;
import java.util.List;

public class SkillController {
    private SkillRepository repository = new JavaIOSkillRepositoryImpl();

    public Skill createSkill(String name) throws IOException {
        return repository.save(new Skill(null, name));
    }

    public Skill updateSkill(Long id,  String newName) throws IOException {
        return repository.update(new Skill(id, newName));
    }

    public Skill findSkillByID(Long id) throws IOException {
        return repository.getById(id);
    }

    public List<Skill> getAllSkills() throws IOException {
        return repository.getAll();
    }

    public void deleteSkillById(Long id) throws IOException {
        repository.deleteById(id);
    }

}
