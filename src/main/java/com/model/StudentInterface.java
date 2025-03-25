package com.model;

/**
 * Facade for Student - can do actions of basic user and Student
 * @author Holdcraft
 */
public interface StudentInterface extends UserInterface {
    public void browseMyCourses();
    public void viewCourse(Course course);
}