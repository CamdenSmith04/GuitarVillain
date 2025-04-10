package com.model;
import java.util.UUID;

/**
 * This class keeps track of any annotations or notes a user has for a song.
 * @author Camden Smith
 */
public class Annotation {
    
    /**
     * This is the text/note the user will leave on the song.
     */
    private String text;

    /**
     * This is the song the text/note will be left on.
     */
    private UUID song;

    /**
     * This is the constructor for the Annotation class.
     * @param song represents the song which will be annotated.
     * @param text represents the text which will be left on the song.
     */
    public Annotation(UUID song, String text) {
        this.song = song;
        this.text = text;
    }

    /**
     * This is a getter for the song's UUID.
     * @return the song's UUID.
     */
    public UUID getSong() {
        return this.song;
    }

    /**
     * This is a getter for the annotation's text field.
     * @return the string of annotated text.
     */
    public String getText() {
        return this.text;
    }

    /**
     * This is a setter for the annotation's song.
     * @param song the UUID for the song which is annotated.
     */
    public void setSong(UUID song) {
        this.song = song;
    }

    /**
     * This is a setter for the text field of the annotation.
     * @param text the string of text which will be annotated.
     */
    public void setText(String text) {
        this.text = text;
    }


}
