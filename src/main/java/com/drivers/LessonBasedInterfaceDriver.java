package com.drivers;

import java.util.ArrayList;
import java.util.UUID;

import com.facade.Facade;
import com.model.Course;
import com.model.Lesson;
import com.model.Song;
import com.model.User;

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

        // facade.logIn("abbyholdcraft", "thegrasstoucher");

        // facade.becomeStudent();

        // for (UUID match : ((Student) facade.getCurrentUser()).getCourses()) {
        //     if (facade.getCourseById(match).getName().equals("Music for the Non-major")) {
        //         for (UUID lesson : facade.getCourseById(match).getAssignedLessons()) {
        //             Lesson currLesson = facade.getLessonById(lesson);
        //             ((Student) facade.getCurrentUser()).beginLesson(currLesson);
        //             System.out.println();
        //         }
        //     }
        // }

        // facade.logout();
    }
    
}
