package com.music;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.model.Facade;
import com.model.Genre;
import com.model.Song;
import com.model.User;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;


public class SongTabViewController implements Initializable{

    @FXML
    private Text songHeader;
    private Facade facade;
    private Song song;
    private User user;

    @FXML private Text artist;
    @FXML private Text instrument;
    @FXML private Text genres;

    @FXML private Text rating;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        facade = Facade.getInstance();
        song = facade.getCurrentSong();
        user = facade.getCurrentUser();
        setUpSong(song);
    }

    public void setUpSong(Song song) {
        songHeader.setText(song.getTitle());
        artist.setText(song.getAuthor());
        instrument.setText(song.getInstrument().getLabel());
        rating.setText(Double.toString(song.getRating()));

        String genreString = "";
        ArrayList<Genre> genresList = song.getGenres();
        for (int i = 0; i < genresList.size(); i++) {
            genreString += genresList.get(i).getLabel();
            if (i < genresList.size() - 1) {
                genreString += ", ";
            }
        }
        genres.setText(genreString);
    }

    @FXML
    public void playSong() throws IOException {
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
