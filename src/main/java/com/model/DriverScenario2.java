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

        // TODO
        // Convert user to teacher - make sure makeCourse in facade ties to teacher class if user is a teacher (method specific to teacher)

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

        String songToBeAdded = "Cool New Song";

        for (Song match : songs) {
            if (match.getTitle().equals(songToBeAdded)) {
                newCourse.addSong(match.getId());
            }
        }

        System.out.println(newCourse.toString());

        // facade.logout();

        // facade.logIn("abbyholdcraft", "thegrasstoucher");

        // TODO: Have this user be a student so they can access their courses.
        // Access the course they are in

        // TODO: Play the song from their course.
        // Play the song

        // TODO: Mark the song as completed.
        // Mark the song as completed.

        // facade.logout();

    }

}
