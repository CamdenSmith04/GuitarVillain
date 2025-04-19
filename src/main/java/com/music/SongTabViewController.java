package com.music;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.model.Chord;
import com.model.Facade;
import com.model.Measure;
import com.model.Song;
import com.model.User;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


public class SongTabViewController implements Initializable{

    @FXML
    private Text songHeader;
    private Facade facade;
    private Song song;
    private User user;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        facade = Facade.getInstance();
        song = facade.getCurrentSong();
        user = facade.getCurrentUser();
        setUpSong(song);
    }

    private void setUpSong(Song song) {
        songHeader.setText(song.getTitle());
        displaySong();
    }

    private void displaySong() {
        ArrayList<Chord> chords = new ArrayList<>();
        for (Measure measure : song.getMeasures()) {
            for (Chord chord : measure.getChords()) {
                chords.add(chord);
                
            }
        }
        
        for (Chord chord : chords) {
            VBox vbox = new VBox();
        }

    }

    @FXML
    private void playSong() throws IOException {
        song.play();
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
