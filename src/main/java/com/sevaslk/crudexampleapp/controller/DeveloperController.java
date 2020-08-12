package com.sevaslk.crudexampleapp.controller;

import com.sevaslk.crudexampleapp.model.Developer;
import com.sevaslk.crudexampleapp.repository.DeveloperRepository;
import com.sevaslk.crudexampleapp.repository.io.JavaIODeveloperRepositoryImpl;

import java.io.IOException;
import java.util.List;

public class DeveloperController {
    private DeveloperRepository repository = new JavaIODeveloperRepositoryImpl();

    public Developer createDeveloper(String name) throws IOException {
        return repository.save(new Developer(null, name));
    }

    public Developer updateDeveloper(Long id, String newName) throws IOException {
        return repository.update(new Developer(id, newName));
    }

    public Developer findDeveloperByID(Long id) throws IOException {
        return repository.getById(id);
    }

    public List<Developer> getAllDevelopers() throws IOException {
        return repository.getAll();
    }

    public void deleteDeveloperById(Long id) throws IOException {
        repository.deleteById(id);
    }

}
