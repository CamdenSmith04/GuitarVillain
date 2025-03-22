package com.model;

import java.util.ArrayList;
import java.util.UUID;

public class Module {

    private String title;
    private ArrayList<UUID> lessons;
    private ArrayList<UUID> songs;
    private double progress;
    private final UUID id;

    public Module(String title, ArrayList<UUID> lessons, ArrayList<UUID> songs) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.lessons = lessons;
        this.songs = songs;
        this.progress = 0.0;
    }
    
    public Module(UUID id, String title, ArrayList<UUID> lessons, ArrayList<UUID> songs, double progress) {
        this.id = id;
        this.title = title;
        this.lessons = lessons;
        this.songs = songs;
        this.progress = progress;
    }

    public boolean isMatch(Module module) {
        return this.id.equals(module.getId());
    }

    public UUID getLessonById(UUID lesson) {
        for (UUID match: this.lessons) {
            if (match == lesson){
                return match;
            }
        }
        return null;
    }

    public void addLesson(UUID lesson) {
        this.lessons.add(lesson);
    }

    public void removeLesson(UUID lesson) {
        this.lessons.remove(lesson);
    }

    public UUID getSongById(UUID song) {
        for (UUID match: this.songs) {
            if (match == song){
                return match;
            }
        }
        return null;
    }

    public void addSong(UUID song) {
        this.songs.add(song);
    }

    public void removeSong(UUID song) {
        this.songs.add(song);
    }

    public String getTitle() {
        return this.title;
    }

    public ArrayList<UUID> getLessons() {
        return this.lessons;
    }

    public ArrayList<UUID> getSongs() {
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

    public void setLessons(ArrayList<UUID> lessons) {
        this.lessons = lessons;
    }

    public void setSongs(ArrayList<UUID> songs) {
        this.songs = songs;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }
}
