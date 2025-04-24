package com.model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.UUID;


public class LessonBasedInterfaceDriver {

    public static void main(String[] args) {
        
        Facade facade = Facade.getInstance();

        if(facade.logIn("camdensmith", "password123")){
            writeToFile("\nSuccessfully logged in!\n");
        }

        writeToFile("Number of courses found: " + facade.getCourses().size());

        writeToFile("-------");
        writeToFile("Courses");
        writeToFile("-------");

        for (Course course : facade.getCourses()){
            writeToFile(course.toString());
            writeToFile("\n");
        }



        if(facade.becomeTeacher()){
            writeToFile("\nSuccessfully became teacher!\n");
        }

        facade.makeCourse("Music for the Non-major");
        Course newCourse = facade.getCurrentCourse();

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

        // facade.addCourse(newCourse);

        writeToFile("Number of courses found: " + facade.getCourses().size());

        writeToFile("-------");
        writeToFile("Courses");
        writeToFile("-------");

        for (Course course : facade.getCourses()){
            writeToFile(course.toString());
            writeToFile("\n");
        }

        if(facade.logout()){
            writeToFile("\nSuccessfully logged out!\n");
        }

        if (facade.logIn("abbyholdcraft", "thegrasstoucher")) {
            writeToFile("\nSuccessfully logged in!\n");
        }

        if(facade.becomeStudent()){
            writeToFile("\nSuccessfully became student!\n");
        }

        for (UUID match : ((Student) facade.getCurrentUser()).getCourses()) {
            if (facade.getCourseById(match).getName().equals("Music for the Non-major")) {
                for (UUID lesson : facade.getCourseById(match).getAssignedLessons()) {
                    if (facade.getLessonById(lesson).getCompleted()){
                        writeToFile(facade.getLessonById(lesson).getTitle() + " is completed.");
                    }
                    else{
                        writeToFile(facade.getLessonById(lesson).getTitle() + " is not completed.");
                    }
                }
            }
        }
        writeToFile("\n");

        for (UUID match : ((Student) facade.getCurrentUser()).getCourses()) {
            if (facade.getCourseById(match).getName().equals("Music for the Non-major")) {
                for (UUID lesson : facade.getCourseById(match).getAssignedLessons()) {
                    Lesson currLesson = facade.getLessonById(lesson);
                    ((Student) facade.getCurrentUser()).beginLesson(currLesson);
                    writeToFile(facade.getLessonById(lesson).getEducationalMaterial());
                    writeToFile(facade.getLessonById(lesson).getVisualAid());
                    writeToFile("\n");
                }
            }
        }

        for (UUID match : ((Student) facade.getCurrentUser()).getCourses()) {
            if (facade.getCourseById(match).getName().equals("Music for the Non-major")) {
                for (UUID lesson : facade.getCourseById(match).getAssignedLessons()) {
                    if (facade.getLessonById(lesson).getCompleted()){
                        writeToFile(facade.getLessonById(lesson).getTitle() + " is completed.");
                    }
                    else{
                        writeToFile(facade.getLessonById(lesson).getTitle() + " is not completed.");
                    }
                }
            }
        }

        if(facade.logout()) {
            writeToFile("\nSuccessfully logged out!\n");
        }

    }
    


    public static void writeToFile(String text){
        try (PrintWriter writer = new PrintWriter((new FileWriter("src/main/java/com/model/LessonBasedInterface.txt", true)))) {
            writer.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}