package com.model;

import java.util.ArrayList;
import java.util.UUID;

public class Song {
    
    private String author;
    private String title;
    private double rating;
    private ArrayList<Genre> genres;
    private Instrument instrument;
    private Visibility visibility;
    private int beatsPerMinute;
    private TimeSignature timeSignature;
    private ArrayList<Measure> measures;
    private ArrayList<String> lyrics;
    private double speed;
    private boolean completed;
    private UUID id;

    public Song(String title, String author) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.author = author;
    }

    public Song(UUID id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public void addGenres(Genre genre) {
        this.genres.add(genre);
    }

    public void addMeasure(Measure measure) {
        this.measures.add(measure);
    }

    public void addLyric(String lyric) {
        this.lyrics.add(lyric);
    }

    public void removeGenres(Genre genre) {
        this.genres.remove(genre);
    }

    public void removeMeasure(Measure measure) {
        this.measures.remove(measure);
    }

    public void removeLyric(String lyric) {
        this.lyrics.remove(lyric);
    }

    public boolean isMatch(UUID id) {
        return this.id.equals(id);
    }

    public String getAuthor() {
        return this.author;
    }

    public String getTitle() {
        return this.title;
    }
    
    public double getRating() {
        return this.rating;
    }

    public ArrayList<Genre> getGenres() {
        return this.genres;
    }

    public Instrument getInstrument() {
        return this.instrument;
    }

    public Visibility getVisibility() {
        return this.visibility;
    }

    public int getBeatsPerMinute() {
        return this.beatsPerMinute;
    }

    public TimeSignature getTimeSignature() {
        return this.timeSignature;
    }

    public ArrayList<Measure> getMeasures() {
        return this.measures;
    }

    public ArrayList<String> getLyrics() {
        return this.lyrics;
    }

    public double getSpeed() {
        return this.speed;
    }

    public boolean getCompleted() {
        return this.completed;
    }

    public UUID getId() {
        return this.id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setGenres(ArrayList<Genre> genres) {
        this.genres = genres;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    public void setBeatsPerMinute(int beatsPerMinute) {
        this.beatsPerMinute = beatsPerMinute;
    }

    public void setTimeSignature(TimeSignature timeSignature) {
        this.timeSignature = timeSignature;
    }

    public void setMeasures(ArrayList<Measure> measures) {
        this.measures = measures;
    }

    public void setLyrics(ArrayList<String> lyrics) {
        this.lyrics = lyrics;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

}
