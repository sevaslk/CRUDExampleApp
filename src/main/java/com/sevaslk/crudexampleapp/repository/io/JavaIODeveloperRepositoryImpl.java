package main.java.com.sevaslk.crudexampleapp.repository.io;

import main.java.com.sevaslk.crudexampleapp.model.Developer;
import main.java.com.sevaslk.crudexampleapp.repository.DeveloperRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JavaIODeveloperRepositoryImpl implements DeveloperRepository {

    private final String DEVELOPERS_TXT = "C:\\Users\\s\\IdeaProjects\\CRUDExampleApp\\src\\main\\resources\\developers.txt";

    @Override
    public List<Developer> getAll() throws IOException {
        return getDevelopers();
    }

    @Override
    public Developer getById(Long id) throws IOException {
        List<Developer> developerList = getDevelopers();
        return developerList.stream()
                .filter(developer -> developer.getId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public Developer save(Developer newDeveloper) throws IOException {
        if (Files.exists(Paths.get(DEVELOPERS_TXT))) {
            List<Developer> developerList = getDevelopers();
            if (developerList.stream().noneMatch(newDeveloper::equals)) {
                developerList.add(new Developer(developerList.get(developerList.size() - 1).getId() + 1, newDeveloper.getName()));
                writeStringToFile(convertListToString(developerList), DEVELOPERS_TXT);
            } else {
                return null;
            }
        } else {
            Files.createFile(Paths.get(DEVELOPERS_TXT));
            save(newDeveloper);
        }
        return newDeveloper;
    }

    @Override
    public Developer update(Developer newDeveloper) throws IOException {
        List<Developer> developerList = getDevelopers();
        for (int i = 0; i < developerList.size(); i++) {
            Developer element = developerList.get(i);
            if (element.getId().equals(newDeveloper.getId())) {
                developerList.set(i, newDeveloper);
            }
        }
        if (developerList.equals(getDevelopers())) {
            return null;
        }
        writeStringToFile(convertListToString(developerList), DEVELOPERS_TXT);
        return newDeveloper;
    }

    @Override
    public void deleteById(Long id) throws IOException {
        List<Developer> skillList = getDevelopers();
        skillList.removeIf(item -> item.getId().equals(id));
        writeStringToFile(convertListToString(skillList), DEVELOPERS_TXT);
    }

    private List<Developer> getDevelopers() throws IOException {
        List<Developer> developerList = new ArrayList<>();
        String files = readFile(DEVELOPERS_TXT);
        String[] developersStringArray = files.split("/");
        for (String element : developersStringArray) {
            String[] developerItemStringArray = element.split(",");
            developerList.add(new Developer(Long.parseLong(developerItemStringArray[0]), developerItemStringArray[1]));
        }
        return developerList;
    }
}