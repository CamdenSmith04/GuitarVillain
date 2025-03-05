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

    public boolean isMatch(Module module) {
        return this.id.equals(module.getId());
    }

    public Lesson getLesson(Lesson lesson) {
        for (Lesson match: this.lessons) {
            if (match.getId() == lesson.getId()){
                return match;
            }
        }
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

    public UUID getId() {
        return this.id;
    }
}
