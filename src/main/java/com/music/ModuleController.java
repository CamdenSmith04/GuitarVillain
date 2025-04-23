package com.music;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.UUID;

import com.model.Facade;
import com.model.ImageHelper;
import com.model.Lesson;
import com.model.Module;
import com.model.Song;
import com.model.User;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ModuleController implements Initializable{
    
    @FXML
    private Text moduleHeader;
    private Facade facade;
    private Module module;
    private User user;

    @FXML private GridPane grid_lessons;
    @FXML private GridPane grid_songs;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        facade = Facade.getInstance();
        module = facade.getCurrentModule();
        user = facade.getCurrentUser();
        setUpModule(module);
        displayLessons();
        displaySongs();
    } 

    public void setUpModule(Module module) {
        moduleHeader.setText(module.getTitle());
    }

    private void displayLessons() {
        ArrayList<UUID> lessons = module.getLessons();
        for (int i = 0; i < lessons.size(); i++) {
            Lesson lesson = facade.getLessonById(lessons.get(i));

            VBox vbox = new VBox();
            Label lessonTitle = new Label(lesson.getTitle());
            lessonTitle.setFont(new Font(14));

            vbox.getChildren().add(lessonTitle);
            if (lesson.getImage() != null) {
                vbox.getStyleClass().add("friend-grid-item");
                ImageView image = ImageHelper.getImage(lesson.getImage(), getClass());
                vbox.setOnMouseEntered(e -> image.setOpacity(0.8));
                vbox.setOnMouseExited(e -> image.setOpacity(1));
                grid_lessons.add(image, i, 0);
            }
            else 
                vbox.getStyleClass().add("module-grid-item");

            vbox.setOnMouseClicked(event -> {
            try {
                facade.setCurrentLesson(lesson);
                App.setRoot("lesson");
            } catch (IOException e) {
                e.printStackTrace();;
            }
            });
            grid_lessons.add(vbox,i,0);
        }
    }

    private void displaySongs() {
        ArrayList<UUID> songs = module.getSongs();
        for (int i = 0; i < songs.size(); i++) {
            Song song = facade.getSong(songs.get(i));

            VBox vbox = new VBox();
            Label songTitle = new Label(song.getTitle());
            songTitle.setFont(new Font(14));

            vbox.getChildren().add(songTitle);
            if (song.getImage() != null) {
                vbox.getStyleClass().add("friend-grid-item");
                ImageView image = ImageHelper.getImage(song.getImage(), getClass());
                vbox.setOnMouseEntered(e -> image.setOpacity(0.8));
                vbox.setOnMouseExited(e -> image.setOpacity(1));
                grid_songs.add(image, i, 0);
            }
            else 
                vbox.getStyleClass().add("module-grid-item");

            vbox.setOnMouseClicked(event -> {
            try {
                facade.setCurrentSong(song);
                App.setRoot("song");
            } catch (IOException e) {
                e.printStackTrace();
            }
            });
            grid_songs.add(vbox,i,0);
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
