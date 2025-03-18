package com.model;

import java.util.ArrayList;

public class Student extends User{
    
    private ArrayList<Course> courses;

    public Student(User user, ArrayList<Course> courses) {
        super(user.getId(), user.getUsername(), user.getPassword(), user.getExperience(), user.getPoints(), user.getStreak(), user.getSecurityQuestion(), user.getSecurityAnswer(), user.getFriends(), user.getSongs());
        this.courses = courses;
    }

    public void beginLesson(Lesson lesson) {

    }

    public void beginSong(Song song) {
        
    }

    public boolean isMatch(Course course) {
        return this.id.equals(course.getId());
    }
}
