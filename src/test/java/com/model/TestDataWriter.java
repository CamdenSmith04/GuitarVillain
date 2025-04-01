package com.model;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Tesing DataWriter function. 
 * Expected:
 * Add exactly one new object to each list
 * BUGS:
 * if adding an object to the list twice in a row, DataWriter creates an object with only value circularReference = true, which causes loading issues
 * Additionally, objectLists do not check for duplicate items (e.g. User with the same username)
 * @author Abby Holdcraft
 */
public class TestDataWriter {
    public static void main(String[] args) {
        UserList userList = UserList.getInstance();
        CourseList courseList = CourseList.getInstance();
        LessonList lessonList = LessonList.getInstance();
        ModuleList moduleList = ModuleList.getInstance();
        SongList songList = SongList.getInstance();

        /*
         * USER
         */
        User addUser = new User("newUser", "newPassword!", Experience.BEGINNER, SecurityQuestion.MOTHER_MAIDEN_NAME, "Georgia");
        // Should work
        userList.addUser(addUser);
        // Should NOT work
        userList.addUser(addUser);
        // Should work
        User user = userList.getUser("abbyholdcraft");
        user.setPoints(1234);
        userList.updateUser(user);

        /*
         * COURSE
         */
        ArrayList<UUID> teachers = new ArrayList<>();
        teachers.add(userList.getUser("newUser").getId());
        Course newCourse = new Course(teachers, "newCourse");
        // Should work
        courseList.addCourse(newCourse);
        // Should NOT work
        courseList.addCourse(newCourse);

        /*
         * LESSON
         */
        Lesson newLesson = new Lesson("testLesson", "Chords are made of notes", null);
        // Should work
        lessonList.addLesson(newLesson);
        // Should NOT work
        lessonList.addLesson(newLesson);

        /*
         * SONG
         */
        Song song = new Song(userList.getUser("newUser").getId());
        song.setTitle("newSong");
        // Should work
        songList.addSong(song);
        // Should NOT work
        songList.addSong(song);

        /*
         * MODULE
         */
        Module newModule = new Module("newModule");
        ArrayList<UUID> lessons = new ArrayList<>();
        lessons.add(lessonList.getLessonByTitle("testLesson").getId());
        newModule = new Module(newModule.getId(), newModule.getTitle(), lessons, null, 0);
        // Should work
        moduleList.addModule(newModule);
        // Should NOT work
        moduleList.addModule(newModule);

        DataWriter.save();

        /*
         * TESTING LOADER WITH SAVED ITEMS
         */
        userList = UserList.getInstance();
        courseList = CourseList.getInstance();
        lessonList = LessonList.getInstance();
        moduleList = ModuleList.getInstance();
        songList = SongList.getInstance();

        Course testCourse = courseList.getCourseByName("newCourse");
        System.out.println(testCourse);

        User testUser = userList.getUser("newUser");
        System.out.println(testUser);

    }
}
