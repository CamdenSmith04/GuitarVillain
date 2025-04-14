package com.music;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.model.Experience;
import com.model.Facade;
import com.model.User;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class MoreController implements Initializable{
    
    @FXML
    private User user;
    private Facade facade;
    
    @FXML private Text securityQuestionField;
    @FXML private TextField securityAnswerField;
    @FXML private TextField newPassword;
    @FXML private TextField confirmPassword;
    @FXML private ComboBox<Experience> experienceOptions;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        facade = Facade.getInstance();
        user = facade.getCurrentUser();

        experienceOptions.getItems().addAll(Experience.BEGINNER, Experience.INTERMEDIATE, Experience.ADVANCED);

        securityQuestionField.setText(user.getSecurityQuestion().getLabel());
    } 

    @FXML
    private void resetPassword() throws IOException {

        if (securityAnswerField.getText().equals(user.getSecurityAnswer())) {
            if (newPassword.getText().equals(confirmPassword.getText())){
                user.setPassword(newPassword.getText());
                System.out.println("Password changed successfully!");
            } 
            else {
                System.out.println("Passwords don't match.");
            }
        } 
        else {
            System.out.println("Incorrect security question answer.");
        }
    }

    @FXML
    private void changeExperience() throws IOException {
        if (experienceOptions.getValue() != null) {
            user.setExperience(experienceOptions.getValue());
        }
    }

    @FXML
    private void goToHome() throws IOException {
        App.setRoot("home");
    }

    @FXML
    private void goToMySongs() throws IOException {
        App.setRoot("mysongs");
    }

    @FXML
    private void goToCourses() throws IOException {
        App.setRoot("teachercourse");
    }

    @FXML
    private void goToSongLibrary() throws IOException {
        App.setRoot("songlibrary");
    }

    @FXML
    private void goToModuleLibrary() throws IOException {
        App.setRoot("modulelibrary");
    }

    @FXML
    private void goToMore() throws IOException {
        App.setRoot("more");
    }

    @FXML
    private void goToProfile() throws IOException {
        App.setRoot("profile");
    }

    @FXML
    private void goToAbout() throws IOException {
        App.setRoot("about");
    }
    
}
