package com.music;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.UUID;

import com.model.Facade;
import com.model.Song;
import com.model.User;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class MySongsController implements Initializable{
    
    private Facade facade;
    private User user;

    @FXML private GridPane grid_mysongs;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        facade = Facade.getInstance();
        user = facade.getCurrentUser();
        displayUserItems(user);
    } 

    private void displayUserItems(User user) {

        int columnCount = 4;
        int row = 0;
        int col = 0;

        Button addButton = new Button("+");
        addButton.setId("newSongButton");
        addButton.setFont(new Font(100));
        addButton.getStyleClass().add("add-button-item");
        addButton.setOnAction(e -> {
            try {
                handleNewSong();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });


        grid_mysongs.add(addButton, col, row);
        col++;

        ArrayList<UUID> songs = user.getSongs();
        for (int i = 0; i < songs.size(); i++) {
            Song song = facade.getSong(songs.get(i));
            
            VBox vbox = new VBox();
            Label songTitle = new Label(song.getTitle());
            songTitle.setFont(new Font(14));
            
            vbox.getChildren().add(songTitle);
            vbox.getStyleClass().add("book-grid-item");

            vbox.setOnMouseClicked(event -> {
                try {
                    facade.setCurrentSong(song);
                    App.setRoot("song");
    
                } catch (IOException e) {
                    e.printStackTrace();
                }
                });
    
            grid_mysongs.add(vbox, col, row);

            col++;

            if (col == columnCount) {
                col = 0;
                row++;
            }
        }
    }

    @FXML
    private void handleNewSong() throws IOException {
        App.setRoot("newsong");
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
