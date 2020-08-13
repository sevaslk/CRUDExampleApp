package com.sevaslk.crudexampleapp.view;

import java.io.IOException;

public interface CurrentView {
    void create() throws IOException;
    void update() throws IOException;
    void findByID() throws IOException;
    void deleteByID() throws IOException;
    void getAll() throws IOException;
}
