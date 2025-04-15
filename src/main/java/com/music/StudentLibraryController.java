package com.music;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.model.Facade;
import com.model.User;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class StudentLibraryController implements Initializable{
    
    @FXML private GridPane grid_students;

    private Facade facade;
    private User user;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        facade = Facade.getInstance();
        user = facade.getCurrentUser();
        ArrayList<User> users = facade.getUsers();
        displayStudents(users);
    } 

    private void displayStudents(ArrayList<User> users) {
        ArrayList<User> students = new ArrayList<>();
        for (User currUser : users) {
            if(currUser.getRole().equals("Student")) {
                students.add(currUser);
            }
        }

        int columnCount = 4;
        int row = 0;
        int col = 0;

        for (int i = 0; i < students.size(); i++) {
            User currUser = students.get(i);
            
            VBox vbox = new VBox();
            Label studentName = new Label(currUser.getUsername());
            studentName.setFont(new Font(14));
            
            vbox.getChildren().add(studentName);
            vbox.getStyleClass().add("module-grid-item");

            // vbox.setOnMouseClicked(event -> {
            //     try {
            //         facade.setCurrentSong(song);
            //         App.setRoot("song");
    
            //     } catch (IOException e) {
            //         e.printStackTrace();
            //     }
            //     });
    
            grid_students.add(vbox, col, row);

            col++;

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
