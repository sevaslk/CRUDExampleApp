package com.sevaslk.crudexampleapp;

import com.sevaslk.crudexampleapp.view.CommonView;

import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        CommonView commonView = new CommonView();
        commonView.start();
    }
}
