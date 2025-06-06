package com.model;

import java.util.ArrayList;
import java.util.UUID;

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
     * This is the song's notes.
     */
    private ArrayList<Note> notes;

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
     * Name of album cover's image
     */
    private String image;

    /**
     * This is a constructor for a new Song.
     * @param authorId the UUID of the author.
     */
    public Song(UUID authorId) {
        this.id = UUID.randomUUID();
        this.authorId = authorId;
        this.genres = new ArrayList<>();
        this.lyrics = new ArrayList<>();
        this.notes = new ArrayList<>();
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
     * @param notes the notes of the song.
     * @param lyrics the song's lyrics.
     * @param speed the speed of the song.
     * @param completed the song's completion.
     * @param image the song's album image name
     */
    public Song(UUID id, String title, String author, UUID authorId, double rating, ArrayList<Genre> genres, Instrument instrument, Visibility visibility, int beatsPerMinute, TimeSignature timeSignature, ArrayList<Note> notes, ArrayList<String> lyrics, double speed, boolean completed, String image) {
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
        this.notes = notes;
        this.lyrics = lyrics;
        this.speed = speed;
        this.completed = completed;
        this.image = image;
    }

    /**
     * Plays a note
     */
    public void play(){
        for(Note note : notes){
            note.play(this.instrument);
        }
    }

    /**
     * Adds a hyphen to the file
     * @param tabTable Table being added to
     * @return Table with addition
     */
    private ArrayList<ArrayList<String>> addHypenToFile(ArrayList<ArrayList<String>> tabTable){
        for(int i = 1; i<7; i++){
            //set first lines to guitar strings
            tabTable.add(new ArrayList<String>());
            tabTable.get(i).add("-");
        }
        return tabTable;
    }

    /**
     * Adds a bar to the file
     * @param tabTable Table being added to
     * @return Table with addition
     */
    private ArrayList<ArrayList<String>> addBarToFile(ArrayList<ArrayList<String>> tabTable){
        for(int i = 1; i<7; i++){
            //set first lines to guitar strings
            tabTable.add(new ArrayList<String>());
            tabTable.get(i).add("|");
        }
        return tabTable;
    }

    /**
     * Prints song to a file
     * @param fileName Name of file
     * @return True if successful
     */
    // public boolean printToFile(String fileName){
    //     FileWriter writer;
    //     ArrayList<ArrayList<String>> tabTable = new ArrayList<ArrayList<String>>();
    //     final String[] guitarStrings = {"e", "B", "G", "D", "A", "E"}; 
       
    //     //adding a blank line for chord names
    //     tabTable.add(new ArrayList<String>());
    //    tabTable.get(0).add(" ");
    //     for(int i = 1; i<7; i++){
    //         //set first lines to guitar strings
    //         tabTable.add(new ArrayList<String>());
    //         //guitarStrings is 1 element shorter due to blank line for chords
    //         tabTable.get(i).add(guitarStrings[i-1]);
    //     }
        
    //     for(Note note:notes){
    //         tabTable = addBarToFile(tabTable);
    //         for(Chord chord:note.getChords()){
    //             if(chord.getName() != null){
    //                 tabTable.get(0).add(chord.getName());
    //             }
    //             else{
    //                 tabTable.get(0).add("       ");
    //             }
    //             for(Note note:chord.getNotes()){
    //                 for (int i = 1; i<7; i++){
    //                     //this condition resolves to true if the iterator is on the right string to add the note...
    //                     if(i-1 == java.util.Arrays.asList(guitarStrings).indexOf(Character.toString(note.getString()))){
    //                         tabTable.get(i).add(Integer.toString(note.getFret()));
    //                         if(note.getFret() < 10){
    //                             tabTable.get(i).add("-");
    //                         }
    //                     }
    //                     else{
    //                         tabTable.get(i).add("--");
    //                     }
    //                 }
    //             }
    //         }
    //     }

    //     try{
    //         writer = new FileWriter(fileName);
    //         for(ArrayList<String> line:tabTable){
    //             for(String character : line ){
    //                 writer.append(character);
    //             }
    //             writer.append("\n");
    //         }
    //         writer.close();
    //         return true;
    //     }
    //     catch(Exception e){
    //         System.out.println(e);
    //         return false;
    //     }
    // }

    /**
     * This method is used to add a genre to the song's genres.
     * @param genre the genre to be added.
     */
    public void addGenre(Genre genre) {
        this.genres.add(genre);
    }

    /**
     * This method is used to add a note to a song.
     * @param note the note to be added.
     */
    public void addNote(Note note) {
        this.notes.add(note);
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
     * This method is used to remove a note from a song.
     * @param note the note to be removed.
     */
    public void removeNote(Note note) {
        this.notes.remove(note);
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
     * This is a getter for the song's notes.
     * @return the song's notes.
     */
    public ArrayList<Note> getNotes() {
        return this.notes;
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
     * This is a setter for the song's notes.
     * @param notes the notes the song will have.
     */
    public void setNotes(ArrayList<Note> notes) {
        this.notes = notes;
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

    /**
     * This method converts the songs data fields into strings.
     * @return the string of all the data fields.
     */
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
                "Notes: " + this.notes.toString() + "\n" + 
                "Lyrics: " + this.lyrics + "\n" + 
                "Speed: " + this.speed + "\n" + 
                "Completed: " + this.completed + "\n" +
                "Id: " + this.id);

    }

    /**
     * Mutator for image url
     * @param image the url
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Accessor for image url
     * @return the image url name
     */
    public String getImage() {
        return image;
    }
    

}
