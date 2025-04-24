package com.music;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.UUID;

import com.model.Course;
import com.model.Facade;
import com.model.ImageHelper;
import com.model.User;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;



public class TeacherCourseController implements Initializable{
    
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

        Button addButton = new Button("+");
        addButton.setId("newCourseButton");
        addButton.setFont(new Font(100));
        addButton.getStyleClass().add("add-button-item2");
        addButton.setOnAction(e -> {
            try {
                handleNewCourse();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });


        grid_courses.add(addButton,col,row);

        col ++;

        for (int i = 0; i < courses.size(); i++ ) {
            Course course = facade.getCourseById(courses.get(i).getId());
            ArrayList<UUID> teachers = course.getTeachers();

            if (teachers.contains(currUserID)) {
                VBox vbox = new VBox();
                Label moduleName = new Label(course.getName());
                moduleName.setFont(new Font(14));

                vbox.getChildren().add(moduleName);
                if (course.getImage() != null) {
                    vbox.getStyleClass().add("friend-grid-item-blue");
                    ImageView image = ImageHelper.getImage(course.getImage(), getClass());
                    vbox.setOnMouseEntered(e -> image.setOpacity(0.8));
                    vbox.setOnMouseExited(e -> image.setOpacity(1));
                    grid_courses.add(image, col, row);
                }
                else 
                    vbox.getStyleClass().add("module-grid-item");

                vbox.setOnMouseClicked(event -> {
                    try {
                        facade.setCurrentCourse(course);
                        App.setRoot("teachercourseview");
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

    @FXML private void handleNewCourse() throws IOException {
        facade.setCurrentCourse(null);
        App.setRoot("course");
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
