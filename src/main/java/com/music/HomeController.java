package com.music;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.model.Facade;
import com.model.ImageHelper;
import com.model.Song;
import com.model.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class HomeController implements  Initializable{

    private Facade facade;
    private User user;
    @FXML private GridPane grid_latest_songs;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        facade = Facade.getInstance();
        user = facade.getCurrentUser();
        displayUserItems();
    } 

    @FXML
    void logOut(ActionEvent event) throws IOException {
        facade.logout();
        App.setRoot("login");
    }

    private void displayUserItems() {
        ArrayList<Song> songs = facade.getSongs();
        for (int i = 0; i < songs.size(); i++) {
            Song song = songs.get(i);
            
            VBox vbox = new VBox();
            Label songTitle = new Label(song.getTitle());
            songTitle.setFont(new Font(14));
            
            vbox.getChildren().add(songTitle);
            if (song.getImage() != null) {
                vbox.getStyleClass().add("friend-grid-item");
                ImageView image = ImageHelper.getImage(song.getImage(), getClass());
                vbox.setOnMouseEntered(e -> image.setOpacity(0.8));
                vbox.setOnMouseExited(e -> image.setOpacity(1));
                grid_latest_songs.add(image, i, 0);
            }
            else 
                vbox.getStyleClass().add("book-grid-item");
    
            vbox.setOnMouseClicked(event -> {
            try {
                facade.setCurrentSong(song);
                App.setRoot("song");

            } catch (IOException e) {
                e.printStackTrace();
            }
            });

            // grid_latest_songs.add(ImageHelper.getImage(song.getImage(), getClass()), i, 0);
            grid_latest_songs.add(vbox, i, 0); // You can change row/col layout logic if needed
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
        if (user.getRole().equals("Student")) {
            App.setRoot("studentcourse");
        }
        else if (user.getRole().equals("Teacher")) {
            App.setRoot("teachercourse");
        }
        else
            App.setRoot("becomerole");
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