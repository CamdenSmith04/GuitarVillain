package com.music;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import com.model.Facade;
import com.model.Genre;
import com.model.Instrument;
import com.model.Note;
import com.model.Song;
import com.model.TimeSignature;
import com.model.User;
import com.model.Visibility;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;



public class NewSongController implements Initializable{

    @FXML private AnchorPane notesGrid;

    private List<TextField> noteFields;


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
        facade.composeSong();
        facade = Facade.getInstance();
        song   = facade.getCurrentSong();
        user   = facade.getCurrentUser();
        instrument.getItems().addAll(Instrument.values());
        genres.getItems().addAll(Genre.values());
    
        noteFields = notesGrid.getChildren().stream()
            .filter(n -> n instanceof TextField)
            .map(n -> (TextField)n)
            .collect(Collectors.toList());
      
    
        UnaryOperator<TextFormatter.Change> twoDigitFilter = change -> {
            String newText = change.getControlNewText();
            return (newText.matches("\\d{0,2}")) ? change : null;
        };
    
        for (TextField tf : noteFields) {
            tf.setTextFormatter(new TextFormatter<>(twoDigitFilter));
        }
    }
    

    @FXML
    public void addNotesButtonPressed(){
        for (int i = 0; i < noteFields.size(); i++) {
            if(!noteFields.get(i).getText().equals("")){
                char guitarString = Note.GUITAR_STRINGS[i%6].charAt(0);
                System.out.println(Integer.parseInt(noteFields.get(i).getText()));
                System.out.println(guitarString);
                System.out.println(i);
                song.addNote(new Note(0, guitarString, Integer.parseInt(noteFields.get(i).getText())));
            }
        }
    }


    @FXML
    public void saveButtonPressed(){
        //song.setInstrument(Instrument.getInstrument(instrument.getValue().toString()));
        song.setInstrument(Instrument.ACOUSTIC_BASS);
        //song.addGenre(Genre.getGenre(genres.getValue().toString()));
        song.addGenre(Genre.HIP_HOP);
        song.setAuthor(artist.getText());
        song.setTitle(songNameBox.getText());
        //Song(UUID id, String title, String author, UUID authorId, 
        //double rating, ArrayList<Genre> genres, Instrument instrument, 
        //Visibility visibility, int beatsPerMinute, 
        //TimeSignature timeSignature, ArrayList<Note> notes, 
        //ArrayList<String> lyrics, double speed, boolean completed
        song.setUserCreated(facade.getCurrentUser().getId());
        song.setRating(2.5);
        song.setVisibility(Visibility.PRIVATE);
        song.setBeatsPerMinute(100);
        song.setTimeSignature(new TimeSignature(4, 4));
        song.setLyrics(new ArrayList<String>());
        song.setSpeed(1.0);
        song.setCompleted(false);
        try {
            goToMySongs();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
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
