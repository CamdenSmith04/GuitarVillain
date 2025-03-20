package com.model;

import java.util.ArrayList;
import java.util.UUID;

public class Course {
    
    private String name;
    private ArrayList<UUID> students;
    private ArrayList<UUID> assignedLessons;
    private ArrayList<UUID> assignedSongs;
    private UUID id;

    public Course(String name) {
        this.name = name;
        this.id = UUID.randomUUID();
    }

    public Course(String name, UUID id) {
        this.name = name;
        this.id = id;
    }

    public Course(String name, ArrayList<UUID> students, ArrayList<UUID> assignedLessons, ArrayList<UUID> assignedSongs, UUID id){
        this.name = name;
        this.students = students;
        this.assignedLessons = assignedLessons;
        this.assignedSongs = assignedSongs;
        this.id = id;
    }

    public void addStudent(UUID student) {
        this.students.add(student);
    }

    public void removeStudent(UUID student) {
        this.students.remove(student);
    }

    public UUID getStudent(UUID student) {
        for (UUID match: this.students) {
            if (match == student){
                return match;
            }
        }
        return null;
    }

    public void addLesson(UUID lesson) {
        this.assignedLessons.add(lesson);
    }

    public void removeLesson(UUID lesson) {
        this.assignedLessons.remove(lesson);
    }

    public UUID getLesson(UUID lesson) {
        for (UUID match : this.assignedLessons) {
            if (match == lesson){
                return match;
            }
        }
        return null;
    }

    public void addSong(UUID song) {
        this.assignedSongs.add(song);
    }

    public void removeSong(UUID song) {
        this.assignedSongs.remove(song);
    }

    public UUID getSong(UUID song) {
        for (UUID match: this.assignedSongs) {
            if (match == song){
                return match;
            }
        }
        return null;
    }

    public boolean isMatch(Course course) {
        return this.id.equals(course.getId());
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<UUID> getStudents() {
        return  this.students;
    }

    public ArrayList<UUID> getAssignedLessons() {
        return  this.assignedLessons;
    }

    public ArrayList<UUID> getAssignedSongs() {
        return this.assignedSongs;
    }

    public UUID getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudents(ArrayList<UUID> students) {
        this.students = students;
    }

    public void setAssignedLessons(ArrayList<UUID> lessons) {
        this.assignedLessons = lessons;
    }

    public void setAssignedSongs(ArrayList<UUID> songs) {
        this.assignedSongs = songs;
    }
}

