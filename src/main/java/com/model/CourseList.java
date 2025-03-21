package com.model;

import java.util.ArrayList;

/**
 * This class keeps track of all the courses in the program and represents the list of courses.
 */
public class CourseList {
    
    /**
     * This is the singleton of the courseList object.
     */
    private static CourseList courseList;

    /**
     * This is the list of courses in the courseList.
     */
    private ArrayList<Course> courses;

    /**
     * This constructs the CourseList object from the JSON files.
     */
    private CourseList(){
        courses = DataLoader.getCourses();
    }

    /**
     * This uses a static method to create the single version of the courseList.
     * @return the CourseList courseList that is the singleton.
     */
    public static CourseList getInstance() {
        if (courseList == null) {
            courseList = new CourseList();
        }
        return courseList;
    }

    /**
     * This method adds a Course object to the list of courses.
     * @param course a course to be added to the list of courses.
     */
    public void addCourse(Course course) {
        courses.add(course);
    }

    /**
     * This method gets a Course from the list of courses by name.
     * @param name the name of the course being searched for.
     * @return the Course if it is found in the list of courses.
     */
    public Course getCourseByName(String name) {
        for(Course current : this.courses) {
            if(current.getName().equals(name)) {
                return current;
            }
        }
        return null;
    }

    /**
     * This is a getter method to get the list of courses in the courseList object.
     * @return the list of courses.
     */
    public ArrayList<Course> getCourses() {
        return this.courses;
    }

    /**
     * TODO: Determine what this method does
     * @param course
     */
    public void updateCourse(Course course) {
        this.save();
    }

    /**
     * This method deletes/removes a course from the course list if it is found.
     * @param course the course object to be deleted/removed.
     */
    public void deleteCourse(Course course) {
        for(Course current : courses) {
            if(current.isMatch(course.getId())) {
                courses.remove(current);
                return;
            }
        }
    }

    /**
     * TODO: Determine what this class does.
     */
    public void save() {

    }
    
}
