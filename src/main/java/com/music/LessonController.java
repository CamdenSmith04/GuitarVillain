package com.music;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.UUID;

import com.model.Course;
import com.model.Facade;
import com.model.Lesson;
import com.model.User;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;



public class LessonController implements Initializable{

    @FXML
    private Text lessonHeader;
    private Facade facade;
    private Lesson lesson;
    private User user;
    private Course course;
    private ArrayList<UUID> lessons;

    @FXML private Text educationalMaterialField;
    @FXML private ImageView visualAidField;
    @FXML private Button addLessonButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        facade = Facade.getInstance();
        user = facade.getCurrentUser();
        lesson = facade.getCurrentLesson();
        course = facade.getCurrentCourse();
        if (course != null) {
            lessons = course.getAssignedLessons();
        }
        setUpLesson(lesson);
        updateAddLessonButton();
    } 

    private void updateAddLessonButton() {
        if (course != null) {
            if (lessons.contains(lesson.getId())) {
                addLessonButton.setText("Remove Lesson");
            }
            addLessonButton.setVisible(true);
            addLessonButton.setDisable(false);
        }

        if (user.getRole().equals("Student")) {
            addLessonButton.setVisible(false);
            addLessonButton.setDisable(true);
        }
    }

    @FXML
    private void handleAddLesson() throws IOException{
        if (lessons.contains(lesson.getId())) {
            course.removeLesson(lesson.getId());
        }
        else {
            course.addLesson(lesson.getId());
        }
        App.setRoot("course");
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
