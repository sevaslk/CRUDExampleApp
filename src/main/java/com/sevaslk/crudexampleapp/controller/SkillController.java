package main.java.com.sevaslk.crudexampleapp.controller;

import main.java.com.sevaslk.crudexampleapp.model.Skill;
import main.java.com.sevaslk.crudexampleapp.repository.SkillRepository;
import main.java.com.sevaslk.crudexampleapp.repository.io.JavaIOSkillRepositoryImpl;

import java.io.IOException;
import java.util.List;

public class SkillController {
    private SkillRepository repository = new JavaIOSkillRepositoryImpl();

    public Skill createSkill(String name) throws IOException {
        Skill skill = new Skill(null, name);
        return repository.save(skill);
    }

    public Skill updateSkill(Long id, String name) throws IOException {
        return repository.update(new Skill(id, name));
    }

    public Skill findSkillByID(Long id) throws IOException {
        return repository.getById(id);
    }

    public List<Skill> getAll() throws IOException {
        return repository.getAll();
    }

    public void deleteById(Long id) throws IOException {
        repository.deleteById(id);
    }

}
