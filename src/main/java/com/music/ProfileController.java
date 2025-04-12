package com.music;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.UUID;

import com.model.Facade;
import com.model.User;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;



public class ProfileController implements Initializable{
    

    private Facade facade;
    private User user;

    @FXML private Text usernameText;
    @FXML private Text experienceText;
    @FXML private Text songsText;
    @FXML private Text pointsText;
    @FXML private Text streakText;

    @FXML private GridPane grid_friends;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        facade = Facade.getInstance();
        user = facade.getCurrentUser();

        profileSetUp(user);
        displayFriends(user);
    } 


    private void profileSetUp(User user) {
        usernameText.setText(user.getUsername());
        experienceText.setText(user.getExperience().getLabel());
        songsText.setText(Integer.toString(user.getSongs().size()));
        pointsText.setText(Integer.toString(user.getPoints()));
        streakText.setText(Integer.toString(user.getStreak()));
    }

    private void displayFriends(User user) {
        ArrayList<UUID> friends = user.getFriends();

        // System.out.println(friends);

        for (int i = 0; i < friends.size(); i++) {
            User friend = facade.getUser(friends.get(i));
            
            VBox vbox = new VBox();
            Label friendUsername = new Label(friend.getUsername());
            friendUsername.setFont(new Font(14));
            
            vbox.getChildren().add(friendUsername);
            vbox.getStyleClass().add("book-grid-item");
    
            grid_friends.add(vbox, i, 0);
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
