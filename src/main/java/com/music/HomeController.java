package com.music;

import java.io.IOException;

import javafx.fxml.FXML;

public class HomeController {

    @FXML
    private void logOut() throws IOException {
        //TODO actually log out
        App.setRoot("login");
    }

}
