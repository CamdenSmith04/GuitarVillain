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
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;



public class FriendController implements Initializable{

    private Facade facade;
    private User user;
    private Course course;
    private ArrayList<UUID> students;


    @FXML private Text usernameText;
    @FXML private Text experienceText;
    @FXML private Text songsText;
    @FXML private Text pointsText;
    @FXML private Text streakText;

    @FXML private GridPane grid_friends;
    @FXML private Button addStudentButton;
    @FXML private ImageView profilePic;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        facade = Facade.getInstance();
        course = facade.getCurrentCourse();
        if (course != null) {
            students = course.getStudents();
        }
    } 

    public void setFriendUser(User user) {
        this.user = user;
        profileSetUp(user);
        // displayFriends(user);
        updateAddStudentButton();
    }

    private void updateAddStudentButton() {
        if (course != null) {
            if (students.contains(user.getId())) {
                addStudentButton.setText("Remove Student");
            }
            addStudentButton.setVisible(true);
            addStudentButton.setDisable(false);
        }

        if (facade.getCurrentUser().getRole().equals("Student")) {
            addStudentButton.setVisible(false);
            addStudentButton.setDisable(true);
        }
    }

    @FXML
    private void handleAddStudent() throws IOException{
        if (students.contains(user.getId())) {
            course.removeStudent(user.getId());
        }
        else {
            course.addStudent(user.getId());
        }
        App.setRoot("course");
    }

    private void profileSetUp(User user) {
        usernameText.setText(user.getUsername());
        experienceText.setText(user.getExperience().getLabel());
        songsText.setText(Integer.toString(user.getSongs().size()));
        pointsText.setText(Integer.toString(user.getPoints()));
        streakText.setText(Integer.toString(user.getStreak()));
        profilePic.setImage(new Image(getClass().getResource("/com/images/" + user.getProfilePic()).toExternalForm()));
        profilePic.setPreserveRatio(false);
    }

    // private void displayFriends(User user) {
    //     ArrayList<UUID> friends = user.getFriends();

    //     // System.out.println(friends);

    //     for (int i = 0; i < friends.size(); i++) {
            
    //         User friend = facade.getUser(friends.get(i));
    //         VBox vbox = new VBox();
    //         Label friendUsername = new Label(friend.getUsername());
    //         friendUsername.setFont(new Font(14));
            
    //         vbox.getChildren().add(friendUsername);
    //         vbox.getStyleClass().add("friend-grid-item");

    //         grid_friends.add(ImageHelper.getImage(friend.getProfilePic(), getClass()), i, 0);
    //         grid_friends.add(vbox, i, 0);
    //     }
    // }

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
