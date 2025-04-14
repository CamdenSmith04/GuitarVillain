package com.music;

import java.io.IOException;

import com.model.Experience;
import com.model.Facade;
import com.model.SecurityQuestion;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
/**
 * @author Abby Holdcraft
 */
public class SignUpController {

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private TextField experience;

    @FXML
    private TextField securityQuestion;

    @FXML
    private TextField securityAnswer;

    @FXML
    private void signUp() throws IOException {
        Facade facade = Facade.getInstance();
        if (facade.signUp(username.getText(),
                            password.getText(),
                            Experience.getExperience(experience.getText()),
                            SecurityQuestion.getSecurityQuestion(securityQuestion.getText()),
                            securityAnswer.getText())) {
            App.setRoot("home");
        }
    }
}
