package com.model;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Scanner;

public class Facade {

    private UserList userList;
    private SongList songList;
    private ModuleList moduleList;
    private LessonList lessonList;
    private CourseList courseList;
    
    private User currentUser;
    private Course currentCourse;
    private Lesson currentLesson;
    private Song currentSong;

    // need to figure out how we want to do setters since this is facade

    public Facade() {
        userList = UserList.getInstance();
        songList = SongList.getInstance();
        moduleList = ModuleList.getInstance();
        lessonList = LessonList.getInstance();
        courseList = CourseList.getInstance();
    } 

    /**
     * Gives user options to log in or sign up
     */
    public void signIn() {
        
    }

    /**
     * Logs in existing user
     */
    public User logIn() {
        
    }

    /**
     * Creates new user
     */
    public User signUp() {
        return null;
    }

    public void resetPassword() {

        // Match security question and answer and then use resetPassword method for user

    }

    public void becomeTeacher() {
        // decorator class

    }

    public void becomeStudent() {
        // decorator class
    }

    public void logout() {
        this.currentUser = null;
    }

    public void browseSongs() {
        songList.browseSongs();
    }

    public void browseLessons() {
        for (Lesson lesson : this.lessons) {
            System.out.println(lesson.toString());
        }
    }

    public void browseMyCourses() {
        for (Course course : this.courses) {
            System.out.println(course.toString());
        }
    }

    public void browseFriends() {

        for (User friend : this.currentUser.getFriends()){
            System.out.println(friend.toString());
        }

    }

    public void playSong() {

    }

    // TODO: Should this be a lesson rather than string name
    public void enterLesson(Lesson lesson) { 

    }

    // TODO: Should this be a course rather than a string name
    public void viewCourse(Course course) {

    }

    public void viewFriendProfile(User user) {
        // display public friend user information by UUID?
    }

    public void composeSong(String title) {
        // this should make a new empty song constructor
        // needs to ask the user for song details and what not
    }

    // TODO: String name or course
    public void makeCourse(String name) {
        // this should make a new empty song constructor
        // needs to ask the user for course details and what not

    }
   
    public void deleteCourse(Course course) {
        this.courses.remove(course);
    }
   
    public void addStudent(Student student) {
        this.currentCourse.addStudent(student);

    }
    
    public void removeStudent(Student student) {
        this.currentCourse.removeStudent(student);

    }
    
    public void assignLesson(Lesson lesson) {
        this.currentCourse.addLesson(lesson);

    }
    
    public void removeLesson(Lesson lesson) {
        this.currentCourse.removeLesson(lesson);
    }
    
    public void assignSong(Song song) {
        this.currentCourse.addSong(song);
    }
    
    public void removeSong(Song song) {
        this.currentCourse.removeSong(song);
    }
    // TODO: String name or course
    public void beginLesson(String name) {
        // go to the start of the module? enter a lesson? not sure
    }
    // TODO: String name or course
    public void beginSong(String title) {
        // This will call play method in song/chord? not sure
    }

    public ArrayList<User> getUsers() {
        return this.users;
    }

    public ArrayList<Song> getSongs() {
        return this.songs;
    }

    public ArrayList<Module> getModules() {
        return this.modules;
    }

    public ArrayList<Lesson> getLessons() {
        return this.lessons;
    }

    public ArrayList<Course> getCourses() {
        return this.courses;
    }

    public User getCurrentUser() {
        return this.currentUser;
    }

    public Course getCurrentCourse() {
        return this.currentCourse;
    }

    public Lesson getCurrentLesson() {
        return this.currentLesson;
    }

    public Song getCurrentSong() {
        return this.currentSong;
    }

}
