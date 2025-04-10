package com.model;

import java.util.ArrayList;
import java.util.UUID;

/**
 * This class keeps track of all the courses in the program and represents the list of courses.
 * @author Camden Smith
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
    public boolean addCourse(Course course) {
        if (course == null) {
            return false;
        }
        for (Course match : courses) {
            if (match.equals(course)){
                return false;
            }
        }
        this.courses.add(course);
        return true;
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
     * This method gets a Course from the list of courses by Id.
     * @param course the UUID of the course being searched for.
     * @return the course if it is found in the list of courses.
     */
    public Course getCourseById(UUID course) {
        for (Course current : courses) {
            if (current.idIsMatch(course)) {
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
     * This method deletes/removes a course from the course list if it is found.
     * @param course the course object to be deleted/removed.
     */
    public boolean deleteCourse(Course course) {
        if (course == null) {
            return false;
        }
        for (Course match : courses) {
            if (match.equals(course)) {
                this.courses.remove(course);
                return true;
            }
        }
        return false;
    }
    
}
