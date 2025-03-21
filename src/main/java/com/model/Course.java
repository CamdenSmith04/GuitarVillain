package com.model;

import java.util.ArrayList;
import java.util.UUID;

/**
 * This class represents a Course.
 * @author Camden Smith
 */
public class Course {
    
    /**
     * This is the name of the course.
     */
    private String name;

    /**
     * This is a list of all the students in a course, referenced by UUID.
     */
    private ArrayList<UUID> students;

    /**
     * This is a list of the lessons in a course, referenced by UUID.
     */
    private ArrayList<UUID> assignedLessons;

    /**
     * This is a list of the songs in a course, referenced by UUID.
     */
    private ArrayList<UUID> assignedSongs;

    /**
     * This is the UUID of a course.
     */
    private final UUID id;

    /**
     * This is a constructor for a new Course. 
     * @param name the name the user wants the course to have.
     */
    public Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
        this.assignedLessons = new ArrayList<>();
        this.assignedSongs = new ArrayList<>();
        this.id = UUID.randomUUID();
    }

    /**
     * This constructor is used to instantiate an existing course from a JSON.
     * @param name the name of the course.
     * @param students the students in the course.
     * @param assignedLessons the lessons in the course.
     * @param assignedSongs the songs in the course.
     * @param id the course's UUID.
     */
    public Course(String name, ArrayList<UUID> students, ArrayList<UUID> assignedLessons, ArrayList<UUID> assignedSongs, UUID id){
        this.name = name;
        this.students = students;
        this.assignedLessons = assignedLessons;
        this.assignedSongs = assignedSongs;
        this.id = id;
    }

    /**
     * This method is used to add students to a course.
     * @param student the UUID of a user to be added to a course.
     */
    public void addStudent(UUID student) {
        this.students.add(student);
    }

    /**
     * This method is used to remove a student from a course.
     * @param student the UUID of a user to be removed from a course.
     */
    public void removeStudent(UUID student) {
        this.students.remove(student);
    }

    /**
     * This method is used to get a student from a course.
     * @param student the UUID of a student being searched for.
     * @return the UUID of the student if they are found in the class, if not the return is a null UUID.
     */
    public UUID getStudent(UUID student) {
        for (UUID match: this.students) {
            if (match == student){
                return match;
            }
        }
        return null;
    }

    /**
     * This method is used to add lessons to a course.
     * @param lesson the UUID of a lesson to be added to a course.
     */
    public void addLesson(UUID lesson) {
        this.assignedLessons.add(lesson);
    }

    /**
     * This method is used to remove a lesson from a course.
     * @param lesson the UUID of a lesson to be removed from a course.
     */
    public void removeLesson(UUID lesson) {
        this.assignedLessons.remove(lesson);
    }

    /**
     * This method is used to get a lesson from a course.
     * @param lesson the UUID of a lesson being searched for.
     * @return the UUID of the lesson if they are found in the class, if not the return is a null UUID.
     */
    public UUID getLesson(UUID lesson) {
        for (UUID match : this.assignedLessons) {
            if (match == lesson){
                return match;
            }
        }
        return null;
    }

    /**
     * This method is used to add songss to a course.
     * @param song the UUID of a song to be added to a course.
     */
    public void addSong(UUID song) {
        this.assignedSongs.add(song);
    }

    /**
     * This method is used to remove a song from a course.
     * @param song the UUID of a song to be removed from a course.
     */
    public void removeSong(UUID song) {
        this.assignedSongs.remove(song);
    }

    /**
     * This method is used to get a song from a course.
     * @param song the UUID of a song being searched for.
     * @return the UUID of the song if they are found in the class, if not the return is a null UUID.
     */
    public UUID getSong(UUID song) {
        for (UUID match: this.assignedSongs) {
            if (match == song){
                return match;
            }
        }
        return null;
    }

    /**
     * This method is used to see if the UUID of this course is a match.
     * @param course the UUID of a course being compared to this course.
     * @return true if the courses have the same UUID, otherwise false.
     */
    public boolean isMatch(UUID course) {
        return this.id.equals(course);
    }

    /**
     * This is a getter for the name of the course.
     * @return the course's name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * This is a getter for the list of students in a course.
     * @return the list of students in a course.
     */
    public ArrayList<UUID> getStudents() {
        return  this.students;
    }

    /**
     * This is a getter for the list of lessons in a course.
     * @return the list of lessons in a course.
     */
    public ArrayList<UUID> getAssignedLessons() {
        return  this.assignedLessons;
    }

    /**
     * This is a getter for the list of songs in a course.
     * @return the list of songs in a course.
     */
    public ArrayList<UUID> getAssignedSongs() {
        return this.assignedSongs;
    }

    /**
     * This is a getter for the course's id.
     * @return the course's id.
     */
    public UUID getId() {
        return this.id;
    }

    /**
     * This is a setter for the course's name.
     * @param name the name which the course will have.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This is a setter for the list of students in a course.
     * @param students the list of students the course will have.
     */
    public void setStudents(ArrayList<UUID> students) {
        this.students = students;
    }

    /**
     * This is a setter for the list of lessons in a course.
     * @param lessons the list of lessons the course will have.
     */
    public void setAssignedLessons(ArrayList<UUID> lessons) {
        this.assignedLessons = lessons;
    }

    /**
     * This is a setter for the list of songs in a course.
     * @param songs the list of songs the course will have.
     */
    public void setAssignedSongs(ArrayList<UUID> songs) {
        this.assignedSongs = songs;
    }
}

