package com.music;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.model.Facade;
import com.model.Lesson;
import com.model.User;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;


public class LessonController implements Initializable{

    @FXML
    private Text lessonHeader;
    private Facade facade;
    private Lesson lesson;
    private User user;

    @FXML private Text educationalMaterialField;
    @FXML private ImageView visualAidField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        facade = Facade.getInstance();
        user = facade.getCurrentUser();
        lesson = facade.getCurrentLesson();
        setUpLesson(lesson);
    } 

    public void setUpLesson(Lesson lesson) {
        lessonHeader.setText(lesson.getTitle());
        educationalMaterialField.setText(lesson.getEducationalMaterial());
        String imagePath = "/com/images/" + lesson.getVisualAid();
        Image image = new Image(getClass().getResourceAsStream(imagePath));
        visualAidField.setImage(image);
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
