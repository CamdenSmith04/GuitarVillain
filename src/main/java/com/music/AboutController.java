package com.music;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.model.Facade;
import com.model.User;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

public class AboutController implements Initializable{

    @FXML
    private User user;

    private Facade facade;

    @FXML
    private ImageView profilePic;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        facade = Facade.getInstance();
        user = facade.getCurrentUser();
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
        if (user.getRole().equals("Student")) {
            App.setRoot("studentcourse");
        }
        else {
            App.setRoot("teachercourse");
        }
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
