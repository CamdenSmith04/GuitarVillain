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

    public void addLesson(Lesson lesson) {
        this.assignedLessons.add(lesson);
    }

    public void removeLesson(Lesson lesson) {
        this.assignedLessons.remove(lesson);
    }

    public void addSong(Song song) {
        this.assignedSongs.add(song);
    }

    public void removeSong(Song song) {
        this.assignedSongs.remove(song);
    }

    public boolean isMatch(Course course) {
        return this.id.equals(course.getId());
    }

    public UUID getId() {
        return this.id;
    }
}

