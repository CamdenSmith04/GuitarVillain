package com.model;

import java.util.ArrayList;

public class CourseList {
    
    private static CourseList courseList;

    private ArrayList<Course> courses;

    private CourseList(){

    }

    public static CourseList getInstance() {
        if (courseList == null) {
            courseList = new CourseList();
        }
        return courseList;
    }

    public void createCourse(Course course) {

    }

    public Course getCourse(String title) {
        //TODO: Fix
        return null;
    }

    public void updateCourse(Course course) {

    }

    public void deleteCourse(Course course) {
        
    }

    public void save() {

    }
    
}
