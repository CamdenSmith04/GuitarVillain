package com.model;

public class MusicAppFacade {
    
    private User currentUser;
    private Course currentCourse;
    private Lesson currentLesson;
    private Song currentSong;

    public MusicAppFacade() {

    }

    // Add getters and setters

    public User login(String username, String password) {

        // This should return the user that gets logged in, if no user is found return null
        return null;
    }

    public User signUp(String username, String password, Experience experience, SecurityQuestion securityQuestion, String securityAnswer) {
        // This should create a User and add them to the User list
        // Signup followed by login should never return null
        return null;
    }

    public void resetPassword() {

    }

    public void becomeTeacher() {
        // decorator class

    }

    public void becomeStudent() {
        // decorator class
    }

    public void logout() {
        // 
        
    }

    public void browseSongs() {
        // print out the song list

    }

    public void browseLessons() {
        // print out the lesson lsit

    }

    public void browseMyCourses() {
        // print out the users courses

    }

    public void browseFriends() {
        // print out the users friends - convert Id to names

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
    // TODO: String name or course
    public void deleteCourse(String name) {
        // call courelist deletecourse
    }
    // TODO: String name or course
    public void addStudent(String username) {
        // call course add student

    }
    // TODO: String name or course
    public void removeStudent(String username) {
        // call course remove student

    }
    // TODO: String name or course
    public void assignLesson(String name) {
        // call course assignlesson

    }
    // TODO: String name or course
    public void removeLesson(String name) {
        // call course removelesson
    }
    // TODO: String name or course
    public void assignSong(String title) {
        // call course assignsong
    }
    // TODO: String name or course
    public void removeSong(String title) {
        // call course removelesson
    }
    // TODO: String name or course
    public void beginLesson(String name) {
        // go to the start of the module? enter a lesson? not sure
    }
    // TODO: String name or course
    public void beginSong(String title) {
        // This will call play method in song/chord? not sure
    }


}
