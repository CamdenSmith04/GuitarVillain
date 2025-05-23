package com.model;

import java.util.ArrayList;
import java.util.UUID;
/**
 * This class represents a student.
 * @author Bradley Alford
 */
public class Student extends User{

    /**
     * This is the list of courses of which the student is a member.
     */
    private ArrayList<UUID> courses;

    /**
     * This is a constructor for a new student.
     * @param user The base user created before assigning as student.
     * @param courses The list of courses for the student.
     */
    public Student(User user, ArrayList<UUID> courses) {
        super(user.getId(), user.getUsername(), user.getPassword(), user.getExperience(), user.getPoints(), user.getStreak(), user.getSecurityQuestion(), user.getSecurityAnswer(), user.getFriends(), user.getSongs(), user.getProfilePic());
        this.courses = courses;
        this.role = "Student";
    }

    /**
     * This begins and completes a lesson for a student.
     * @param lesson The lesson for the student to complete.
     */
    public void beginLesson(Lesson lesson) {
        System.out.println(lesson.getEducationalMaterial());
        System.out.println(lesson.getVisualAid());
        lesson.setCompleted(true);
        // TODO: Add more interactions once lesson is more figured out.
    }

    /**
     * This plays a song for a student.
     * @param song The song to play.
     */
    public void beginSong(Song song) {
        song.play();
    }

    /**
     * This is a getter for the student's courses.
     * @return the courses the student has.
     */
    public ArrayList<UUID> getCourses() {
        return this.courses;
    }

    /**
     * This is a setter for the student's courses.
     * @param courses the courses that will be set.
     */
    public void setCourses(ArrayList<UUID> courses) {
        this.courses = courses;
    }
}
