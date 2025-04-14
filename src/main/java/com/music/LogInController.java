package com.music;

import java.io.IOException;

import com.model.Facade;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
/**
 * @author Abby Holdcraft
 */
public class LogInController {

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private void logIn() throws IOException {
        Facade facade = Facade.getInstance();
        if (facade.logIn(username.getText(), password.getText())) {
            App.setRoot("home");
        }
    }

    @FXML
    private void signUp() throws IOException {
        App.setRoot("signup");
    }

    

}