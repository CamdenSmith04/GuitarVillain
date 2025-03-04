package com.model;

import java.util.ArrayList;
import java.util.UUID;

public class Module {

    private String title;
    private ArrayList<Lesson> lessons;
    private ArrayList<Song> songs;
    private double progress;
    private UUID id;

    public Module(String title, ArrayList<Lesson> lessons, ArrayList<Song> songs) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.lessons = lessons;
        this.songs = songs;
        this.progress = 0.0;
    }
    
    public Module(UUID id, String title, ArrayList<Lesson> lessons, ArrayList<Song> songs) {
        this.id = id;
        this.title = title;
        this.lessons = lessons;
        this.songs = songs;
        this.progress = 0.0;
    }

    //TODO: Fix
    public boolean isMatch(UUID id) {
        return this.id.equals(id);
    }

    public Lesson getLesson(Lesson lesson) {
        //TODO: Fix
        return null;
    }

    public void addLesson(Lesson lesson) {
        this.lessons.add(lesson);
    }

    public void removeLesson(Lesson lesson) {
        this.lessons.remove(lesson);
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }

    public void removeSong(Song song) {
        this.songs.add(song);
    }
}
