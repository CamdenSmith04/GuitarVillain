package com.model;

import java.util.ArrayList;

public class CourseList {
    
    private static CourseList courseList;
    private ArrayList<Course> courses;

    private CourseList(){
        courses = new ArrayList<>();
    }

    public static CourseList getInstance() {
        if (courseList == null) {
            courseList = new CourseList();
        }
        return courseList;
    }

    // TODO: Make sure lesson can be created :)
    public void addCourse(Course course) {
        courses.add(course);
    }

    public Course getCourse(String title) {
        for(Course current : courses) {
            if(current.getTitle().equals(title)) {
                return current;
            }
        }
        return null;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void updateCourse(Course course) {

    }

    public void deleteCourse(Course course) {
        for(Course current : courses) {
            if(current.isMatch(course)) {
                courses.remove(current);
                return;
            }
        }
    }

    public void save() {

    }
    
}
