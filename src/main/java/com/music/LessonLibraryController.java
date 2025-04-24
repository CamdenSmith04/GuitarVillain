package com.music;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.model.Facade;
import com.model.ImageHelper;
import com.model.Lesson;
import com.model.User;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class LessonLibraryController implements Initializable{

    private Facade facade;
    private User user;

    @FXML private GridPane grid_modules;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        facade = Facade.getInstance();
        user = facade.getCurrentUser();
        displayLessons();
    } 

    private void displayLessons() {
        int columnCount = 4;
        int row = 0;
        int col = 0;

        ArrayList<Lesson> lessons = facade.getLessons();
        for (int i = 0; i < lessons.size(); i++ ) {
            Lesson lesson = facade.getLessonById(lessons.get(i).getId());
            VBox vbox = new VBox();
            Label lessonName = new Label(lesson.getTitle());
            lessonName.setFont(new Font(14));

            vbox.getChildren().add(lessonName);
            if (lesson.getImage() != null) {
                vbox.getStyleClass().add("friend-grid-item-blue");
                ImageView image = ImageHelper.getImage(lesson.getImage(), getClass());
                vbox.setOnMouseEntered(e -> image.setOpacity(0.8));
                vbox.setOnMouseExited(e -> image.setOpacity(1));
                grid_modules.add(image, col, row);
            }
            else 
                vbox.getStyleClass().add("module-grid-item");

            vbox.setOnMouseClicked(event -> {
                try {
                    facade.setCurrentLesson(lesson);
                    App.setRoot("lesson");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            grid_modules.add(vbox, col, row);

            col ++;

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