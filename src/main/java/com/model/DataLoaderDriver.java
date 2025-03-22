package com.model;


/**
 * This driver is used to show that the dataLoader is correctly working to pull
 * all fields from all json files. All outputs should have some type of value. No 
 * null values or errors are expected.
 */

public class DataLoaderDriver {
    public static void main(String[] args) {
        Facade facade = new Facade();
        
        System.out.println("---------------------------");
        System.out.println("*******");
        System.out.println("COURSES");
        System.out.println("*******");
        System.out.println("---------------------------");
        for (Course course : facade.getCourses()) {
            System.out.println("ID: " + course.getId());
            System.out.println("Teachers: " + course.getTeachers());
            System.out.println("Name: " + course.getName());
            System.out.println("Students: " + course.getStudents());
            System.out.println("Lessons: " + course.getAssignedLessons());
            System.out.println("Songs: " + course.getAssignedSongs());
            System.out.println("---------------------------");

        }

        System.out.println("---------------------------");
        System.out.println("*******");
        System.out.println("MODULES");
        System.out.println("*******");
        System.out.println("---------------------------");
        for (Module module : facade.getModules()) {
            System.out.println("ID: " + module.getId());
            System.out.println("Title: " + module.getTitle());
            System.out.println("Lessons: " + module.getLessons());
            System.out.println("Songs: " + module.getSongs());
            System.err.println("Progress: " + module.getProgress());
            System.out.println("---------------------------");
        }

        System.out.println("---------------------------");
        System.out.println("*******");
        System.out.println("USERS");
        System.out.println("*******");
        System.out.println("---------------------------");
        for (User user: facade.getUsers()) {
            System.out.println("ID: " + user.getId());
            System.out.println("Username: " + user.getUsername());
            System.out.println("Password: " + user.getPassword());
            System.out.println("Experience: " + user.getExperience());
            System.out.println("Points: " + user.getPoints());
            System.out.println("Streak: " + user.getStreak());
            System.out.println("Security Question: " + user.getSecurityQuestion());
            System.out.println("Security Answer: " + user.getSecurityAnswer());
            System.out.println("Friends: " + user.getFriends());
            System.out.println("Songs: " + user.getSongs());
            System.out.println("---------------------------");
        }

        System.out.println("---------------------------");
        System.out.println("*******");
        System.out.println("SONGS");
        System.out.println("*******");
        System.out.println("---------------------------");
        for (Song song : facade.getSongs()) {
            System.out.println("ID: " + song.getId());
            System.out.println("Author: " + song.getAuthor());
            System.out.println("Author Id: " + song.getAuthorId());
            System.out.println("Title: " + song.getTitle());
            System.out.println("Rating: " + song.getRating());
            System.out.println("Genres: " + song.getGenres());
            System.out.println("Instrument: " + song.getInstrument());
            System.out.println("Visibility: " + song.getVisibility());
            System.out.println("BPM: " + song.getBeatsPerMinute());
            System.out.println("TS: " + song.getTimeSignature());
            System.out.println("Measures: " + song.getMeasures());
            System.out.println("Lyrics: " + song.getLyrics());
            System.out.println("Speed: " + song.getSpeed());
            System.out.println("Completed: " + song.getCompleted());
            System.out.println("---------------------------");
        }


        System.out.println("---------------------------");
        System.out.println("*******");
        System.out.println("LESSONS");
        System.out.println("*******");
        System.out.println("---------------------------");
        for (Lesson lesson: facade.getLessons()) {
            System.out.println("ID: " + lesson.getId());
            System.out.println("Title: " + lesson.getTitle());
            System.out.println("Material: " + lesson.getEducationalMaterial());
            System.out.println("Visual Path: " + lesson.getVisualAid());
            System.out.println("Completed: " +lesson.getCompleted());
            System.out.println("---------------------------");
        }
    }
}
