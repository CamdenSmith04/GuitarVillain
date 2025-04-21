package com.music;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.model.Facade;
import com.model.Genre;
import com.model.Instrument;
import com.model.Song;
import com.model.User;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;



public class NewSongController implements Initializable{

    @FXML
    // private Text songHeader;
    private Facade facade;
    private Song song;
    private User user;

    @FXML private TextField artist;
    @FXML private ChoiceBox instrument;
    @FXML private ChoiceBox genres;
    @FXML private TextField songNameBox;
    @FXML private Button saveButton;

    @FXML private Text rating;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        facade = Facade.getInstance();
        song = facade.getCurrentSong();
        user = facade.getCurrentUser();
        instrument.getItems().addAll(Instrument.values());
        genres.getItems().addAll(Genre.values());

    } 

    @FXML
    public void saveButtonPressed(){
        facade.composeSong();
        Song newSong = facade.getCurrentSong();
        newSong.setInstrument(Instrument.getInstrument(instrument.get));
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
