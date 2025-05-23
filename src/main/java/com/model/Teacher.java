package com.model;

import java.util.ArrayList;
import java.util.UUID;

/**
 * This class represents a teacher.
 * @author Bradley Alford
 */
public class Teacher extends User {

    /**
     * A constructor for a teacher.
     * @param user The user the teacher is based on.
     * @param courses The courses of which the teacher is a member.
     */
    public Teacher(User user, ArrayList<UUID> courses){
        super(user.getId(), user.getUsername(), user.getPassword(), user.getExperience(), 
        user.getPoints(), user.getStreak(), user.getSecurityQuestion(), user.getSecurityAnswer(), 
        user.getFriends(), user.getSongs(), user.getProfilePic());
        this.courses = courses;
        this.role = "Teacher";
    }

    /**
     * This creates a cnew course.
     * @param teachers The teachers for the course.
     * @param name The name of the course.
     */
    public void makeCourse(ArrayList<UUID> teachers, String name) {
        Course newCourse = new Course(teachers, name);
        this.courses.add(newCourse.getId());
        this.role = "Teacher";
    }

    /**
     * The teacher deletes a course.
     * @param id The id of the course to be deleted.
     */
    public void deleteCourse(UUID id) {
        this.courses.remove(id);
    }

    /**
     * The teacher deletes a course.
     * @param course The course to be deleted.
     */
    public void deleteCourse(Course course) {
        this.courses.remove(course.getId());
    }
}
