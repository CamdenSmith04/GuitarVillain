package com.music;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.model.Experience;
import com.model.Facade;
import com.model.SecurityQuestion;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
/**
 * @author Abby Holdcraft
 */
public class SignUpController implements Initializable {

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private ChoiceBox<String> experience;

    private String[] experienceLevels = {"Choose One", "Beginner", "Intermediate", "Advanced"};

    private String experienceData = null;

    // @FXML
    // private ChoiceBox<String> securityQuestion;

    // private String[] securityQuestions = {"Choose One", "What was your first pet's name?",
    //                                     "What is your mother's maiden name?",
    //                                     "What was the name of your elementary school?"};
    
    // private String securityData = null;

    private TextField securityAnswer;

    @FXML
    private void signUp() throws IOException {
        // Facade facade = Facade.getInstance();
        // if (facade.signUp(username.getText(),
        //     password.getText(),
        //     Experience.getExperience(experienceData),
        //     SecurityQuestion.getSecurityQuestion(securityData),
        //     securityAnswer.getText())) {
            App.setRoot("home");
        // }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        experience.getItems().addAll(experienceLevels);
        experience.setOnAction(this::setExperienceData);
        // securityQuestion.getItems().addAll(securityQuestions);
        // securityQuestion.setOnAction(this::setSecurityData);
    }

    @FXML
    private void setExperienceData(ActionEvent event) {
        experienceData = experience.getValue();
        if (experienceData.equals("Choose One"))
            experienceData = null;
    }

    // @FXML
    // private void setSecurityData(ActionEvent event) {
    //     securityData = securityQuestion.getValue();
    //     if (securityData.equals("Choose One"))
    //         securityData = null;
    // }

}
