package com.model;

import java.util.ArrayList;
import java.util.UUID;

import org.jfugue.player.Player;

/**
 * TODO: ADD JAVADOC AND AUTHOR
 * @author 
 */

public class Song {
    
    private String author;
    private String title;
    private UUID authorId;
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

    public Song(UUID authorId) {
        this.id = UUID.randomUUID();
        this.authorId = authorId;
        this.genres = new ArrayList<Genre>();
        this.lyrics = new ArrayList<String>();
        this.measures = new ArrayList<Measure>();
    }

    public Song(String title, String author, UUID authorId, double rating, ArrayList<Genre> genres, Instrument instrument, Visibility visibility, int beatsPerMinute, TimeSignature timeSignature, ArrayList<Measure> measures, ArrayList<String> lyrics, double speed, boolean completed) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.author = author;
        this.authorId = authorId;
        this.rating = rating;
        this.genres = genres;
        this.instrument = instrument;
        this.visibility = visibility;
        this.beatsPerMinute = beatsPerMinute;
        this.timeSignature = timeSignature;
        this.measures = measures;
        this.lyrics = lyrics;
        this.speed = speed;
        this.completed = completed;
    }

    public Song(UUID id, String title, String author, UUID authorId, double rating, ArrayList<Genre> genres, Instrument instrument, Visibility visibility, int beatsPerMinute, TimeSignature timeSignature, ArrayList<Measure> measures, ArrayList<String> lyrics, double speed, boolean completed) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.authorId = authorId;
        this.rating = rating;
        this.genres = genres;
        this.instrument = instrument;
        this.visibility = visibility;
        this.beatsPerMinute = beatsPerMinute;
        this.timeSignature = timeSignature;
        this.measures = measures;
        this.lyrics = lyrics;
        this.speed = speed;
        this.completed = completed;
    }

    public boolean isMatch(Song song) {
        return this.id.equals(song.getId());
    }

    Player player = new Player();

    public void play(){
        for(Measure measure : measures){
            for(Chord chord : measure.getChords()){
                for(Note note : chord.getNotes()){
                    player.play(note.getNoteName());
                }
            }
        }
    }

    public void addGenre(Genre genre) {
        this.genres.add(genre);
    }

    public void addMeasure(Measure measure) {
        this.measures.add(measure);
    }

    public void addLyric(String lyric) {
        this.lyrics.add(lyric);
    }

    public void removeGenre(Genre genre) {
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

    public UUID getAuthorId() {
        return this.authorId;
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

    public void setUserCreated(UUID authorId) {
        this.authorId = authorId;
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

    public String toString() {
        return ("Author: " + this.author + "\n" + 
                "Title: " + this.title + "\n" +
                "AuthorId: " + this.authorId + "\n" + 
                "Rating: " + this.rating + "\n" + 
                "Genres: " + this.genres + "\n" + 
                "Instrument: " + this.instrument.getName() + "\n" + 
                "Visibility: " + this.visibility +  "\n" +
                "BPM: " + this.beatsPerMinute + "\n" + 
                "Time Signature: " + this.timeSignature.toString() + "\n" +
                "Measures: " + this.measures + "\n" + 
                "Lyrics: " + this.lyrics + "\n" + 
                "Speed: " + this.speed + "\n" + 
                "Completed: " + this.completed + "\n" +
                "Id: " + this.id);

    }

}
