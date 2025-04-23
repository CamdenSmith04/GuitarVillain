package com.music;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.UUID;

import com.model.Course;
import com.model.Facade;
import com.model.Lesson;
import com.model.Song;
import com.model.User;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class CourseController implements Initializable{

    @FXML
    private TextField courseHeaderField;
    private Facade facade;
    private Song song;
    private User user;
    private Course course;

    @FXML private GridPane grid_lessons;
    @FXML private GridPane grid_songs;
    @FXML private GridPane grid_students;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        facade = Facade.getInstance();
        song = facade.getCurrentSong();
        user = facade.getCurrentUser();
        course = facade.getCurrentCourse();
        if (course == null) {
            facade.makeCourse("Untitled");
            course = facade.getCurrentCourse();
        }
        setUpCourse(course);
        displayLessons();
        displaySongs();
        displayStudents();
    } 

    @FXML
    private void handleCourseNameUpdate() {
        String updatedName = courseHeaderField.getText();

                if (facade.getCurrentCourse() != null) {
            facade.getCurrentCourse().setName(updatedName);
        }
    }

    private void displayLessons() {

        ArrayList<UUID> lessons = course.getAssignedLessons();

        Button addButton = new Button("+");
        addButton.setId("newLessonButton");
        addButton.setFont(new Font(100));
        addButton.getStyleClass().add("add-button-item2");

        // Once lesson library is established

        addButton.setOnAction(e -> {
            try {
                App.setRoot("lessonlibrary");
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });


        grid_lessons.add(addButton,0,0);

        for (int i = 0; i < lessons.size(); i++) {
            Lesson lesson = facade.getLessonById(lessons.get(i));

            VBox vbox = new VBox();
            Label lessonTitle = new Label(lesson.getTitle());
            lessonTitle.setFont(new Font(14));

            vbox.getChildren().add(lessonTitle);
            vbox.getStyleClass().add("module-grid-item");

            vbox.setOnMouseClicked(event -> {
            try {
                facade.setCurrentLesson(lesson);
                App.setRoot("lesson");
            } catch (IOException e) {
                e.printStackTrace();;
            }
            });
            grid_lessons.add(vbox,i+1,0);
        }

    }

    private void displaySongs() {
        ArrayList<UUID> songs = course.getAssignedSongs();

        Button addButton = new Button("+");
        addButton.setId("newSongButton");
        addButton.setFont(new Font(100));
        addButton.getStyleClass().add("add-button-item2");

        // Once song library is established

        addButton.setOnAction(e -> {
            try {
                App.setRoot("songlibrary");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        grid_songs.add(addButton,0,0);

        for (int i = 0; i < songs.size(); i++) {
            Song song = facade.getSong(songs.get(i));

            VBox vbox = new VBox();
            Label songTitle = new Label(song.getTitle());
            songTitle.setFont(new Font(14));

            vbox.getChildren().add(songTitle);
            vbox.getStyleClass().add("module-grid-item");

            vbox.setOnMouseClicked(event -> {
            try {
                facade.setCurrentSong(song);
                App.setRoot("song");
            } catch (IOException e) {
                e.printStackTrace();
            }
            });
            grid_songs.add(vbox,i+1,0);
        }

    }

    private void displayStudents() {

        ArrayList<UUID> students = course.getStudents();

        Button addButton = new Button("+");
        addButton.setId("newStudentButton");
        addButton.setFont(new Font(100));
        addButton.getStyleClass().add("add-button-item2");
        addButton.setOnAction(e -> {
            try {
                App.setRoot("studentlibrary");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        grid_students.add(addButton,0,0);

        for (int i = 0; i < students.size(); i++) {
            User user = facade.getUser(students.get(i));

            VBox vbox = new VBox();
            Label studentTitle = new Label(user.getUsername());
            studentTitle.setFont(new Font(14));

            vbox.getChildren().add(studentTitle);
            vbox.getStyleClass().add("module-grid-item");

            // This is responsible for letting the user see the
            // profile of an existing student in the course
            // profile

            vbox.setOnMouseClicked(event -> {
                try {
                    App.setRoot("friend", controller -> {
                        if (controller instanceof FriendController) {
                            ((FriendController) controller).setFriendUser(user);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            grid_students.add(vbox,i+1,0);
        }

    }

    private void setUpCourse(Course course) {
        courseHeaderField.setText(course.getName());
    }

    // @FXML
    // public void playSong() throws IOException {
    //     song.play();
    // }

    @FXML
    private void goToHome() throws IOException {
        facade.setCurrentCourse(null);
        App.setRoot("home");
    }

    @FXML
    private void goToMySongs() throws IOException {
        facade.setCurrentCourse(null);
        App.setRoot("mysongs");
    }

    @FXML
    private void goToCourses() throws IOException {
        facade.setCurrentCourse(null);
        if (user.getRole().equals("Student")) {
            App.setRoot("studentcourse");
        }
        else {
            App.setRoot("teachercourse");
        }
    }

    @FXML
    private void goToSongLibrary() throws IOException {
        facade.setCurrentCourse(null);
        App.setRoot("songlibrary");
    }

    @FXML
    private void goToModuleLibrary() throws IOException {
        facade.setCurrentCourse(null);
        App.setRoot("modulelibrary");
    }

    @FXML
    private void goToMore() throws IOException {
        facade.setCurrentCourse(null);
        App.setRoot("more");
    }

    @FXML
    private void goToProfile() throws IOException {
        facade.setCurrentCourse(null);
        App.setRoot("profile");
    }

    @FXML
    private void goToAbout() throws IOException {
        facade.setCurrentCourse(null);
        App.setRoot("about");
    }
    
}
