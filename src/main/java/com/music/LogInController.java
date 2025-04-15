package com.music;

import java.io.IOException;

import com.model.Facade;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
/**
 * @author Abby Holdcraft
 */
public class LogInController {

    private Facade facade = Facade.getInstance();

    @FXML
    private Text forgotPassword;

    @FXML
    private TextField password;

    @FXML
    private TextField username;

    @FXML
    private Text invalidUser;

    @FXML
    private void logIn() throws IOException {
        if (facade.logIn(username.getText(), password.getText()))
            App.setRoot("home");
        else
            invalidUser.setVisible(true);
    }

    @FXML
    private void signUp() throws IOException {
        App.setRoot("signup");
    }

    @FXML
    private void forgotPassword() throws IOException {
        App.setRoot("forgotpasswordpopup");
    }

}