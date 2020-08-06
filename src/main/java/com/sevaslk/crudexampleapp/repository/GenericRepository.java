package main.java.com.sevaslk.crudexampleapp.repository;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public interface GenericRepository<T, ID> {
    List<T> getAll() throws IOException;
    T getById(ID id) throws IOException;
    T save(T t) throws IOException;
    T update(T t) throws IOException;
    void deleteById(ID id) throws IOException;

    default void writeStringToFile(String string, String path) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(path)) {
            byte[] strBytes = string.getBytes();
            fileOutputStream.write(strBytes);
        }
    }

    default String readFile(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

    default String convertListToString(List<T> t) {
        return t.stream().map(String::valueOf).sorted().collect(Collectors.joining());
    }
}
