package com.model;

/**
 * Facade for Teacher - can do basic user, student, and teacher.
 * @author Holdcraft
 */
public interface TeacherInterface extends StudentInterface {
    public void makeCourse(String name);
    public void deleteCourse(String name);
}
