package com.model;
import java.util.ArrayList;

public class DriverScenario2 {
    
    // Log-in as teacher
    // Create a course
    // Add students to the course
    // Assign a song to students
    // Log-out

    // Log-in as student
    // Access the song through the course
    // Play the song
    // Mark song as completed in course

    public static void main(String[] args) {
        
        Facade facade = new Facade();

        facade.logIn("camdensmith", "password123");

        facade.becomeTeacher();

        Course newCourse = facade.makeCourse("Music for the Non-major");

        ArrayList<User> users = facade.getUsers();

        String studentToBeAdded = "abbyholdcraft";

        for (User match : users) {
            if (match.getUsername().equals(studentToBeAdded)) {
                newCourse.addStudent(match.getId());
            }
        }

        ArrayList<Lesson> lessons = facade.getLessons();

        ArrayList<String> lessonsToBeAdded = new ArrayList<>();
        lessonsToBeAdded.add("Lesson 1");
        lessonsToBeAdded.add("Lesson 3");

        for (Lesson lesson : lessons) {
            for (String match : lessonsToBeAdded) {
                if (lesson.getTitle().equals(match)) {
                    newCourse.addLesson(lesson.getId());
                }
            }
        }

        ArrayList<Song> songs = facade.getSongs();

        String songToBeAdded = "Fur Elise";

        for (Song match : songs) {
            if (match.getTitle().equals(songToBeAdded)) {
                newCourse.addSong(match.getId());
            }
        }

        System.out.println(newCourse.toString());

        facade.logout();

        facade.logIn("abbyholdcraft", "thegrasstoucher");

        facade.becomeStudent();
        facade.viewCourse(newCourse);


        for (Song match : songs) {
            if (match.getTitle().equals("Fur Elise")) {
                // How do you get a song with an ID?
                // facade.setCurrentSong(facade.getCurrentCourse().getSong(songs.get(0).getId()));
            }
        }
        facade.beginSong(facade.getCurrentSong().getTitle());
        facade.getCurrentSong().setCompleted(true);

        facade.logout();

    }

}