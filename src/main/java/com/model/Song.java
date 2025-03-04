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

    public void addMeasure(Measure measure){
        this.measures.add(measure);
    }

    public void addLyric(String lyric){
        this.lyrics.add(lyric);
    }

    public boolean isMatch(UUID id) {
        return this.id.equals(id);
    }
}
