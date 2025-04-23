package com.music;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.model.Facade;
import com.model.Note;
import com.model.Song;
import com.model.User;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


public class SongTabViewController implements Initializable{

    @FXML private Text songHeader;
    private Facade facade;
    private Song song;
    private User user;
    @FXML private GridPane grid_notes;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        facade = Facade.getInstance();
        song = facade.getCurrentSong();
        user = facade.getCurrentUser();
        setUpSong();
    }

    private void setUpSong() {
        songHeader.setText(song.getTitle());
        displayNotes();
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

    private void displayNotes() {
        int index = 0;
        for (Note note : song.getNotes()) {
            index++;
            TextField textField = getNoteTextField(note);
            GridPane.setRowIndex(textField, getRowFromFret(note));
            GridPane.setColumnIndex(textField, index);
            grid_notes.getChildren().add(textField);
            grid_notes.addColumn(index, new VBox());
        }
    }

    private TextField getNoteTextField(Note note) {
        TextField noteRep = new TextField(String.valueOf(note.getFret()));
        noteRep.setPrefSize(22, 22);
        noteRep.setMaxSize(22, 22);
        noteRep.setMinSize(22, 22);
        noteRep.setAlignment(Pos.CENTER);
        noteRep.setEditable(false);
        noteRep.setPadding(new Insets(4));
        return noteRep;
    }

    private int getRowFromFret(Note note) {
        int row = 0;
        switch (note.getString()) {
            case 'e': {
                row = 5;
                break;
            }
            case 'A': {
                row = 4;
                break;
            }
            case 'D': {
                row = 3;
                break;
            }
            case 'G': {
                row = 2;
                break;
            }
            case 'B': {
                row = 1;
                break;
            }
            case 'E': {
                row = 0;
                break;
            }
            default:
                break;
        }
        return row;
    }

}
