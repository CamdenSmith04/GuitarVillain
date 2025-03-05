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

    public Song getSong(Song song) {
        for (Song match: this.songs) {
            if (match.getId() == song.getId()){
                return match;
            }
        }
        return null;
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }

    public void removeSong(Song song) {
        this.songs.add(song);
    }

    public String getTitle() {
        return this.title;
    }

    public ArrayList<Lesson> getLessons() {
        return this.lessons;
    }

    public ArrayList<Song> getSongs() {
        return this.songs;
    }

    public double getProgress() {
        return this.progress;
    }

    public UUID getId() {
        return this.id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLessons(ArrayList<Lesson> lessons) {
        this.lessons = lessons;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }
}
