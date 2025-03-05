package com.model;

import java.util.ArrayList;
import java.util.UUID;

public class Course {
    
    private String name;
    private ArrayList<Student> students;
    private ArrayList<Lesson> assignedLessons;
    private ArrayList<Song> assignedSongs;
    private UUID id;

    public Course(String name) {
        this.name = name;
        this.id = UUID.randomUUID();
    }

    public Course(String name, UUID id) {
        this.name = name;
        this.id = id;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void removeStudent(Student student) {
        this.students.remove(student);
    }

    public Student getStudent(Student student) {
        for (Student match: this.students) {
            if (match.getId() == student.getId()){
                return match;
            }
        }
        return null;
    }

    public void addLesson(Lesson lesson) {
        this.assignedLessons.add(lesson);
    }

    public void removeLesson(Lesson lesson) {
        this.assignedLessons.remove(lesson);
    }

    public Lesson getLesson(Lesson lesson) {
        for (Lesson match : this.assignedLessons) {
            if (match.getId() == lesson.getId()){
                return match;
            }
        }
        return null;
    }

    public void addSong(Song song) {
        this.assignedSongs.add(song);
    }

    public void removeSong(Song song) {
        this.assignedSongs.remove(song);
    }

    public Song getSong(Song song) {
        for (Song match: this.assignedSongs) {
            if (match.getId() == song.getId()){
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

    public ArrayList<Student> getStudents() {
        return  this.students;
    }

    public ArrayList<Lesson> getAssignedLessons() {
        return  this.assignedLessons;
    }

    public ArrayList<Song> getAssignedSongs() {
        return this.assignedSongs;
    }

    public UUID getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudents( ArrayList<Student> students) {
        this.students = students;
    }

    public void getAssignedLessons(ArrayList<Lesson> lessons) {
        this.assignedLessons = lessons;
    }

    public void getAssignedSongs(ArrayList<Song> songs) {
        this.assignedSongs = songs;
    }
}

