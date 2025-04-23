package com.music;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.UUID;

import com.model.Course;
import com.model.Facade;
import com.model.User;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;



public class StudentCourseController implements Initializable{
    
    private Facade facade;
    private User user;

    @FXML private GridPane grid_courses;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        facade = Facade.getInstance();
        user = facade.getCurrentUser();
        displayCourses();
    } 

    private void displayCourses() {
        int columnCount = 4;
        int row = 0;
        int col = 0;

        User currentUser = facade.getCurrentUser();
        UUID currUserID = currentUser.getId();

        ArrayList<Course> courses = facade.getCourses();

        for (int i = 0; i < courses.size(); i++ ) {
            Course course = facade.getCourseById(courses.get(i).getId());
            ArrayList<UUID> students = course.getStudents();

            if (students.contains(currUserID)) {
                VBox vbox = new VBox();
                Label moduleName = new Label(course.getName());
                moduleName.setFont(new Font(14));

                vbox.getChildren().add(moduleName);
                vbox.getStyleClass().add("module-grid-item");

                vbox.setOnMouseClicked(event -> {
                    try {
                        facade.setCurrentCourse(course);
                        App.setRoot("studentcourseview");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

                grid_courses.add(vbox, col, row);

                col ++;

                if (col == columnCount) {
                    col = 0;
                    row++;
                }
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
