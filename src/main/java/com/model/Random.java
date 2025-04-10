package com.model;

import java.util.UUID;

public class Random {

    public static void main(String[] args) {

        Facade facade = new Facade();
        
        facade.logIn("abbyholdcraft", "thegrasstoucher");

        facade.becomeStudent();

        for (UUID match : ((Student) facade.getCurrentUser()).getCourses()) {
            if (facade.getCourseById(match).getName().equals("Music for the Non-major")) {
                for (UUID lesson : facade.getCourseById(match).getAssignedLessons()) {
                    Lesson currLesson = facade.getLessonById(lesson);
                    ((Student) facade.getCurrentUser()).beginLesson(currLesson);
                    System.out.println();
                }
            }
        }

        facade.logout();
    }
    
}
