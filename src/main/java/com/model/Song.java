package com.model;

import java.util.ArrayList;
import java.util.UUID;

import org.jfugue.player.Player;

/**
 * This class represents a Song.
 * @author Andrew Goad
 */
public class Song {
    
    /**
     * This is the author of the song.
     */
    private String author;

    /**
     * This is the title of the song.
     */
    private String title;

    /**
     * This is the UUID of the author of the song.
     */
    private UUID authorId;

    /**
     * This is the song's rating.
     */
    private double rating;

    /**
     * This is the list of genres for the song.
     */
    private ArrayList<Genre> genres;

    /**
     * This is the song's instrument.
     */
    private Instrument instrument;

    /**
     * This is the song's visibility.
     */
    private Visibility visibility;

    /**
     * This is the song's BPM.
     */
    private int beatsPerMinute;

    /**
     * This is the song's timeSignature.
     */
    private TimeSignature timeSignature;

    /**
     * This is the song's measures.
     */
    private ArrayList<Measure> measures;

    /**
     * This is the song's lyrics.
     */
    private ArrayList<String> lyrics;

    /**
     * This is the song's speed.
     */
    private double speed;

    /**
     * This is the completion of the song.
     */
    private boolean completed;

    /**
     * This is the song's UUID.
     */
    private final UUID id;

    /**
     * This is a constructor for a new Song.
     * @param authorId the UUID of the author.
     */
    public Song(UUID authorId) {
        this.id = UUID.randomUUID();
        this.authorId = authorId;
        this.genres = new ArrayList<>();
        this.lyrics = new ArrayList<>();
        this.measures = new ArrayList<>();
    }

    /**
     * This constructor is used to instantiate an existing song from a JSON.
     * @param id the song's UUID.
     * @param title the title of the song.
     * @param author the author of the song.
     * @param authorId the UUID of the song's author.
     * @param rating the song's rating.
     * @param genres the song's genres.
     * @param instrument the song's instrument.
     * @param visibility the song's visibility.
     * @param beatsPerMinute the song's BPM.
     * @param timeSignature the song's time signature.
     * @param measures the measures of the song.
     * @param lyrics the song's lyrics.
     * @param speed the speed of the song.
     * @param completed the song's completion.
     */
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

    Player player = new Player();

    /**
     * This method is used to play the song with JFugue.
     */
    public void play(){
        for(Measure measure : measures){
            for(Chord chord : measure.getChords()){
                for(Note note : chord.getNotes()){
                    player.play(note.getNoteName());
                }
            }
        }
    }

    /**
     * This method is used to add a genre to the song's genres.
     * @param genre the genre to be added.
     */
    public void addGenre(Genre genre) {
        this.genres.add(genre);
    }

    /**
     * This method is used to add a measure to a song.
     * @param measure the measure to be added.
     */
    public void addMeasure(Measure measure) {
        this.measures.add(measure);
    }

    /**
     * This method is used to add lyrics to a song.
     * @param lyric the lyric to be added.
     */
    public void addLyric(String lyric) {
        this.lyrics.add(lyric);
    }

    /**
     * This method is used to remove a genre from a song.
     * @param genre the genre to be removed.
     */
    public void removeGenre(Genre genre) {
        this.genres.remove(genre);
    }

    /**
     * This method is used to remove a measure from a song.
     * @param measure the measure to be removed.
     */
    public void removeMeasure(Measure measure) {
        this.measures.remove(measure);
    }

    /**
     * This method is used to remove a lyric from a song.
     * @param lyric the lyric to be removed.
     */
    public void removeLyric(String lyric) {
        this.lyrics.remove(lyric);
    }

    /**
     * This method is used to see if the song is a match.
     * @param song the song being compared to this song.
     * @return true if the songs are a match, otherwise false.
     */
    public boolean isMatch(Song song) {
        return this.id.equals(song.getId());
    }

    /**
     * This method is used to see if the UUID of this song is a match.
     * @param song the UUID of a song being compared to this course.
     * @return true if the songs have the same UUID, otherwise false.
     */
    public boolean idIsMatch(UUID song) {
        return this.id.equals(song);
    }

    /**
     * This is a getter for the song's author.
     * @return the song's author.
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * This is a getter for the song's title.
     * @return the song's title.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * This is a getter for the song's author's id.
     * @return the UUID of the song's author.
     */
    public UUID getAuthorId() {
        return this.authorId;
    }
    
    /**
     * This is a getter for the song's rating.
     * @return the song's rating.
     */
    public double getRating() {
        return this.rating;
    }

    /**
     * This is a getter for the song's genres.
     * @return the genres of a song.
     */
    public ArrayList<Genre> getGenres() {
        return this.genres;
    }

    /**
     * This is a getter for the song's instrument.
     * @return the song's instrument.
     */
    public Instrument getInstrument() {
        return this.instrument;
    }

    /**
     * This is a getter for the song's visibility.
     * @return the song's visibility.
     */
    public Visibility getVisibility() {
        return this.visibility;
    }

    /**
     * This is a getter for the song's BPM.
     * @return the song's BPM.
     */
    public int getBeatsPerMinute() {
        return this.beatsPerMinute;
    }

    /**
     * This is a getter for the song's time signature.
     * @return the song's time signature.
     */
    public TimeSignature getTimeSignature() {
        return this.timeSignature;
    }

    /**
     * This is a getter for the song's measures.
     * @return the song's measures.
     */
    public ArrayList<Measure> getMeasures() {
        return this.measures;
    }

    /**
     * This is a getter for the lyrics of a song.
     * @return the song's lyrics.
     */
    public ArrayList<String> getLyrics() {
        return this.lyrics;
    }

    /**
     * This is a getter for the song's speed.
     * @return the speed of the song.
     */
    public double getSpeed() {
        return this.speed;
    }

    /**
     * This is a getter for the song's completion.
     * @return the song's completion status.
     */
    public boolean getCompleted() {
        return this.completed;
    }

    /**
     * This is a getter for the song's UUID.
     * @return the song's id.
     */
    public UUID getId() {
        return this.id;
    }

    /**
     * This is a setter for the song's author.
     * @param author the author for the song to have.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * This is a setter for the song's title.
     * @param title the title for the song to have.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This is a setter for the song's author's id.
     * @param authorId the author's id the song will have.
     */
    public void setUserCreated(UUID authorId) {
        this.authorId = authorId;
    }
    
    /**
     * This is a setter for the song's rating.
     * @param rating the rating for the song to have.
     */
    public void setRating(double rating) {
        this.rating = rating;
    }

    /**
     * This is a setter for the song's genres.
     * @param genres the genres for the song to have.
     */
    public void setGenres(ArrayList<Genre> genres) {
        this.genres = genres;
    }

    /**
     * This is a setter for the song's instrument.
     * @param instrument the instrument the song will have.
     */
    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    /**
     * This is a setter for the song's visibility.
     * @param visibility the visibility the song will have.
     */
    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    /**
     * This is a setter for the song's BPM.
     * @param beatsPerMinute the BPM the song will have.
     */
    public void setBeatsPerMinute(int beatsPerMinute) {
        this.beatsPerMinute = beatsPerMinute;
    }

    /**
     * This is a setter for the song's time signature.
     * @param timeSignature the time signature the song will have.
     */
    public void setTimeSignature(TimeSignature timeSignature) {
        this.timeSignature = timeSignature;
    }

    /**
     * This is a setter for the song's measures.
     * @param measures the measures the song will have.
     */
    public void setMeasures(ArrayList<Measure> measures) {
        this.measures = measures;
    }

    /**
     * This is a setter for the song's lyrics.
     * @param lyrics the lyrics the song will have.
     */
    public void setLyrics(ArrayList<String> lyrics) {
        this.lyrics = lyrics;
    }

    /**
     * This is a setter for the song's speed.
     * @param speed the speed the song will have.
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    /**
     * This is a setter for the song's completion.
     * @param completed the completion status the song will have.
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return ("Author: " + this.author + "\n" + 
                "Title: " + this.title + "\n" +
                "AuthorId: " + this.authorId + "\n" + 
                "Rating: " + this.rating + "\n" + 
                "Genres: " + this.genres + "\n" + 
                "Instrument: " + this.instrument + "\n" + 
                "Visibility: " + this.visibility +  "\n" +
                "BPM: " + this.beatsPerMinute + "\n" + 
                "Time Signature: " + this.timeSignature.toString() + "\n" +
                "Measures: " + this.measures.toString() + "\n" + 
                "Lyrics: " + this.lyrics + "\n" + 
                "Speed: " + this.speed + "\n" + 
                "Completed: " + this.completed + "\n" +
                "Id: " + this.id);

    }

}
