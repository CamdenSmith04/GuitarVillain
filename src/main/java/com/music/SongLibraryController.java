package com.music;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.model.Song;
import com.model.Facade;
import com.model.User;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class SongLibraryController implements Initializable{

    private Facade facade;
    private User user;

    @FXML private GridPane grid_songs;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        facade = Facade.getInstance();
        user = facade.getCurrentUser();
        displaySongs();
    } 

    private void displaySongs() {
        int columnCount = 4;
        int row = 0;
        int col = 0;

        ArrayList<Song> songs = facade.getSongs();
        for (int i = 0; i < songs.size(); i++ ) {
            Song song = songs.get(i);
            VBox vbox = new VBox();
            Label songName = new Label(song.getTitle());
            songName.setFont(new Font(14));

            vbox.getChildren().add(songName);
            vbox.getStyleClass().add("friend-grid-item");
            Image image = new Image(getClass().getResource("/com/images/" + song.getImage()).toExternalForm());
            BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, true);
            BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
            vbox.setBackground(new Background(backgroundImage));
            

            vbox.setOnMouseClicked(event -> {
                try {
                    facade.setCurrentSong(song);
                    App.setRoot("song");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            grid_songs.add(vbox, col, row);

            col ++;

            if (col == columnCount) {
                col = 0;
                row++;
            }

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
