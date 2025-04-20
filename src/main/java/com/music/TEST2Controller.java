package com.music;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.model.Note;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * TEST
 * @author Abby Holdcraft
 */
public class TEST2Controller implements Initializable {

    @FXML private GridPane grid_notes;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        displayNotes();
    } 

    private void displayNotes() {
        ArrayList<Note> notes = new ArrayList<>();
        notes.add(new Note(1, 'e', 1));
        notes.add(new Note(2, 'E', 0));
        notes.add(new Note(3, 'A', 2));
        notes.add(new Note(3, 'D', 3));
        notes.add(new Note(3, 'G', 3));
        notes.add(new Note(3, 'B', 3));
        notes.add(new Note(2, 'E', 0));
        notes.add(new Note(3, 'e', 3));
        notes.add(new Note(3, 'A', 3));
        notes.add(new Note(3, 'D', 3));
        notes.add(new Note(1, 'e', 1));
        notes.add(new Note(2, 'E', 0));
        notes.add(new Note(3, 'A', 2));
        notes.add(new Note(3, 'D', 3));
        notes.add(new Note(3, 'G', 3));
        notes.add(new Note(3, 'B', 3));
        notes.add(new Note(2, 'E', 0));
        notes.add(new Note(3, 'e', 3));
        notes.add(new Note(3, 'A', 3));
        notes.add(new Note(3, 'D', 3));
        notes.add(new Note(1, 'e', 1));
        notes.add(new Note(2, 'E', 0));
        notes.add(new Note(3, 'A', 2));
        notes.add(new Note(3, 'D', 3));
        notes.add(new Note(3, 'G', 3));
        notes.add(new Note(3, 'B', 3));
        notes.add(new Note(2, 'E', 0));
        notes.add(new Note(3, 'e', 3));
        notes.add(new Note(3, 'A', 3));
        notes.add(new Note(3, 'D', 3));
        notes.add(new Note(1, 'e', 1));
        notes.add(new Note(2, 'E', 0));
        notes.add(new Note(3, 'A', 2));
        notes.add(new Note(3, 'D', 3));
        notes.add(new Note(3, 'G', 3));
        notes.add(new Note(3, 'B', 3));
        notes.add(new Note(2, 'E', 0));
        notes.add(new Note(3, 'e', 3));
        notes.add(new Note(3, 'A', 3));
        notes.add(new Note(3, 'D', 3));
        notes.add(new Note(1, 'e', 1));
        notes.add(new Note(2, 'E', 0));
        notes.add(new Note(3, 'A', 2));
        notes.add(new Note(3, 'D', 3));
        notes.add(new Note(3, 'G', 3));
        notes.add(new Note(3, 'B', 3));
        notes.add(new Note(2, 'E', 0));
        notes.add(new Note(3, 'e', 3));
        notes.add(new Note(3, 'A', 3));
        notes.add(new Note(3, 'D', 3));
        notes.add(new Note(1, 'e', 1));
        notes.add(new Note(2, 'E', 0));
        notes.add(new Note(3, 'A', 2));
        notes.add(new Note(3, 'D', 3));
        notes.add(new Note(3, 'G', 3));
        notes.add(new Note(3, 'B', 3));
        notes.add(new Note(2, 'E', 0));
        notes.add(new Note(3, 'e', 3));
        notes.add(new Note(3, 'A', 3));
        notes.add(new Note(3, 'D', 3));
        notes.add(new Note(1, 'e', 1));
        notes.add(new Note(2, 'E', 0));
        notes.add(new Note(3, 'A', 2));
        notes.add(new Note(3, 'D', 3));
        notes.add(new Note(3, 'G', 3));
        notes.add(new Note(3, 'B', 3));
        notes.add(new Note(2, 'E', 0));
        notes.add(new Note(3, 'e', 3));
        notes.add(new Note(3, 'A', 3));
        notes.add(new Note(3, 'D', 3));

        int index = 0;
        for (Note note : notes) {
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
        noteRep.setPrefSize(18, 18);
        noteRep.setMaxSize(18, 18);
        noteRep.setMinSize(18, 18);
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