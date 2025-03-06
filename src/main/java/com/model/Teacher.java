package com.model;

import java.util.ArrayList;

public class Teacher {
    
    private ArrayList<Course> courses;

    public Teacher(User user){

    }

    public void makeCourse(String name) {

    }

    public void deleteCourse(Course course) {
        this.courses.remove(course);
    }
}
