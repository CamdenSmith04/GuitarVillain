package com.music;

import java.io.IOException;
import java.lang.classfile.Label;

import com.model.Facade;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LogInController {

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private void logIn() throws IOException {
        Facade facade = new Facade();
        
        // username = userField.getText();
        // password = pwordField.getText();

        if (facade.logIn(username.getText(), password.getText()))
            App.setRoot("home");
    }

}