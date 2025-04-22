package com.music;

import java.io.IOException;
import com.model.Facade;
import com.model.User;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
/**
 * @author Abby Holdcraft
 */
public class ForgotPasswordPopUpController {

    private Facade facade = Facade.getInstance();

    @FXML
    private TextField username;

    @FXML
    private Button enterUsername;

    @FXML
    private Text securityQuestion;

    @FXML
    private TextField securityAnswer;

    @FXML
    private TextField password;

    @FXML
    private Button resetPassword;

    @FXML
    private Text usernameNotFound;

    @FXML
    private Text invalidAnswer;

    @FXML
    private Text answerText;

    @FXML 
    private Text newPasswordText;

    @FXML
    void enterUsername(ActionEvent event) {
        User temp = facade.getUser(username.getText());
        if (temp != null) {
            usernameNotFound.setVisible(false);
            enterUsername.setVisible(false);
            securityQuestion.setText(temp.getSecurityQuestion().getLabel());
            securityQuestion.setVisible(true);
            securityAnswer.setVisible(true);
            password.setVisible(true);
            resetPassword.setVisible(true);
            answerText.setVisible(true);
            newPasswordText.setVisible(true);
        }
        else
            usernameNotFound.setVisible(true);
    }

    @FXML
    void resetPassword(ActionEvent event) throws IOException {
        if (facade.resetPassword(username.getText(), securityAnswer.getText(), password.getText()))
            App.setRoot("login");
        else
            invalidAnswer.setVisible(true);
    }

    @FXML
    void goBack() throws IOException {
        App.setRoot("login");
    }

}