package com.model;

import java.util.ArrayList;

public class Student extends User{
    
    private ArrayList<Course> courses;

    public Student() {
        super();
    }

    public Student(ArrayList<Course> courses) {
        super();
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
