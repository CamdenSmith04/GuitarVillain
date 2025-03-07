package com.model;

import java.util.ArrayList;

public class Teacher extends User {
    
    private ArrayList<Course> courses;

    public Teacher(){
        super();
    }

    public Teacher(ArrayList<Course> courses){
        super();
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
