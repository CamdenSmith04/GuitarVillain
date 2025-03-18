package com.model;

import java.util.ArrayList;

public class Teacher extends User {
    
    private ArrayList<Course> courses;

    public Teacher(User user, ArrayList<Course> courses){
        super(user.getId(), user.getUsername(), user.getPassword(), user.getExperience(), user.getPoints(), user.getStreak(), user.getSecurityQuestion(), user.getSecurityAnswer(), user.getFriends(), user.getSongs());
        this.courses = courses;
    }

    public void makeCourse(String name) {

    }

    public void deleteCourse(Course course) {
        this.courses.remove(course);
    }

    public boolean isMatch(Course course) {
        return this.id.equals(course.getId());
    }
}
