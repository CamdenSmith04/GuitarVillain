package com.music;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.model.Facade;
import com.model.Song;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class HomeController implements  Initializable{

    private Facade facade;
    @FXML private GridPane grid_latest_songs;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        facade = new Facade();
        displayUserItems();
    } 

    @FXML
    void logOut(ActionEvent event) {

    }

    private void displayUserItems() {
        ArrayList<Song> songs = facade.getSongs();
        for (int i = 0; i < songs.size(); i++) {
            Song song = songs.get(i);
            
            VBox vbox = new VBox();
            Label songTitle = new Label(song.getTitle());
            songTitle.setFont(new Font(14));
            
            vbox.getChildren().add(songTitle);
            vbox.getStyleClass().add("book-grid-item");
    
            grid_latest_songs.add(vbox, i, 0); // You can change row/col layout logic if needed
        }
    }
    
}