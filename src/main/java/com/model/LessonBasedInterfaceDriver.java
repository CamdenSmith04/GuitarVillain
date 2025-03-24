package com.model;

import java.util.ArrayList;
import java.util.UUID;

public class LessonBasedInterfaceDriver {

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
        lessonsToBeAdded.add("Lesson 2");
        lessonsToBeAdded.add("Lesson 3");

        for (Lesson lesson : lessons) {
            for (String match : lessonsToBeAdded) {
                if (lesson.getTitle().equals(match)) {
                    newCourse.addLesson(lesson.getId());
                }
            }
        }

        ArrayList<Song> songs = facade.getSongs();

        String songToBeAdded = "The Distance";

        for (Song match : songs) {
            if (match.getTitle().equals(songToBeAdded)) {
                newCourse.addSong(match.getId());
            }
        }

        facade.addCourse(newCourse);

        facade.logout();

        facade.logIn("abbyholdcraft", "thegrasstoucher");

        facade.becomeStudent();

        for (Course match : ((Student) facade.getCurrentUser()).getCourses()) {
            if (match.getName().equals("Music for the Non-major")) {
                for (UUID lesson : match.getAssignedLessons()) {
                    Lesson currLesson = facade.getLessonById(lesson);
                    ((Student) facade.getCurrentUser()).beginLesson(currLesson);
                    System.out.println();
                }
            }
        }


        
        // ArrayList<Course> courses = facade.getCourses();

        // for (Course match : courses) {
        //     if (match.getName().equals("Music for the Non-major")){
        //         facade.setCurrentCourse(match);
        //     }
        // }

        // ArrayList<Lesson> assignedLessons = facade.getLessons();

        // for (Lesson match : assignedLessons) {
        //     facade.getCurrentUser().beginLesson(match);
        // }

        // ArrayList<UUID> assignedSongs = facade.getCurrentCourse().getAssignedSongs();
        // for (UUID match : assignedSongs) {
        //     if (facade.getSongById(match).getTitle().equals("The Distance")){
        //         facade.setCurrentSong(facade.getSongById(match));
        //     }
        // }

        // System.out.println("Playing: " + facade.getCurrentSong().getTitle());
        // facade.beginSong(facade.getCurrentSong().getTitle());
        
        // System.out.println(newCourse.toString());


        // facade.logout();
    }
    
}
