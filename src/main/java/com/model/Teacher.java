package com.model;

import java.util.ArrayList;
import java.util.UUID;

/**
 * This class represents a teacher.
 * @author Bradley Alford
 */
public class Teacher extends User {
    /**
     * The list of courses the teacher is a member of.
     */
    private ArrayList<Course> courses;

    /**
     * A constructor for a teacher.
     * @param user The user the teacher is based on.
     * @param courses The courses of which the teacher is a member.
     */
    public Teacher(User user, ArrayList<Course> courses){
        super(user.getId(), user.getUsername(), user.getPassword(), user.getExperience(), 
        user.getPoints(), user.getStreak(), user.getSecurityQuestion(), user.getSecurityAnswer(), 
        user.getFriends(), user.getSongs());
        this.courses = courses;
    }

    /**
     * This creates a cnew course.
     * @param teachers The teachers for the course.
     * @param name The name of the course.
     */
    public void makeCourse(ArrayList<UUID> teachers, String name) {
        this.courses.add(new Course(teachers, name));
    }

    /**
     * The teacher deletes a course.
     * @param course The course to be deleted.
     */
    public void deleteCourse(Course course) {
        this.courses.remove(course);
    }

    // Remove? Do we need one seperate from User's?
    public boolean isMatch(Course course) {
        return this.id.equals(course.getId());
    }
}
