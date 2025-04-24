package com.music;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.UUID;

import com.model.Course;
import com.model.Facade;
import com.model.Genre;
import com.model.Song;
import com.model.User;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;


public class SongController implements Initializable{

    @FXML
    private Text songHeader;
    private Facade facade;
    private Song song;
    private User user;
    private Course course;
    private ArrayList<UUID> songs;

    @FXML private Text artist;
    @FXML private Text instrument;
    @FXML private Text genres;

    @FXML private Text rating;
    @FXML private Button addSongButton;
    @FXML private ImageView image;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        facade = Facade.getInstance();
        song = facade.getCurrentSong();
        user = facade.getCurrentUser();
        course = facade.getCurrentCourse();
        if (course != null) {
            songs = course.getAssignedSongs();
        }
        setUpSong(song);
        updateAddSongButton();
    } 

    private void updateAddSongButton() {
        if (course != null) {
            if (songs.contains(song.getId())) {
                addSongButton.setText("Remove Song");
            }
            addSongButton.setVisible(true);
            addSongButton.setDisable(false);
        }

        if (user.getRole().equals("Student")) {
            addSongButton.setVisible(false);
            addSongButton.setDisable(true);
        }
    }

    @FXML
    private void handleAddSong() throws IOException{
        if (songs.contains(song.getId())) {
            course.removeSong(song.getId());
        }
        else {
            course.addSong(song.getId());
        }
        App.setRoot("course");
    }

    public void setUpSong(Song song) {
        if (getClass().getResource("/com/images/" + song.getImage()) != null) {
            Image songImage = new Image(getClass().getResource("/com/images/" + song.getImage()).toExternalForm());
            image.setImage(songImage);
            image.setPreserveRatio(false);
        }
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
    private void goToTabView() throws IOException {
        if (facade.getCurrentSong() != null)
            App.setRoot("songtabview");
    }

    @FXML
    private void goToLyricsView() throws IOException {
        if (facade.getCurrentSong() != null)
            App.setRoot("songtabview");
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
