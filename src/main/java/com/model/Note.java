package com.model;
import org.jfugue.player.Player;

/**
 * This class represents a note in a chord.
 * @author Andrew Goad
 */
public class Note {
    
    /**
     * This represents the time of a note.
     */
    private int time;

    /**
     * This represents the string of a note.
     */
    private char string;

    /**
     * This represents a note's fret.
     */
    private int fret;

    /**
     * This represents the actual note.
     */
    private String note;

    /**
     * This represents the note player object.
     */
    private Player player;

    
    /**
     * This represents the list of possible notes.
     */
    private static final String[] NOTES = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};

    /**
     * This method gets the name of a note.
     * @return the note's note.
     */
    public String getNoteName() {
        note = String.valueOf(string).toUpperCase();
        int baseIndex = findNoteIndex(note);
        if (baseIndex == -1) {
            note = convertFlatToSharp(note);
            baseIndex = findNoteIndex(note);
        }
        int newIndex = (baseIndex + fret) % NOTES.length;
        return NOTES[newIndex];
    }

    /**
     * This method returns the notes position in the string array of notes.
     * @param note the note being searched for.
     * @return the index of the note.
     */
    private static int findNoteIndex(String note) {
        for (int i = 0; i < NOTES.length; i++) {
            if (NOTES[i].equals(note)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * This method converts a note from a flat to a sharp.
     * @param note the note to be converted.
     * @return the converted note.
     */
    private static String convertFlatToSharp(String note) {
        switch (note) {
            case "Db":
                return "C#";
            case "Eb":
                return "D#";
            case "Gb":
                return "F#";
            case "Ab":
                return "G#";
            case "Bb":
                return "A#";
            default:
                return note;
        }
    }
    

    /**
     * This method will play the notes.
     */
    public void play(){
        player.play(this.getNoteName());
    }

    /**
     * This method constructs the note object.
     * @param time the time of the note.
     * @param string the string the note is on.
     * @param fret the fret the note is on.
     */
    public Note(int time, char string, int fret) {
        this.time = time;
        this.string = string;
        this.fret = fret;
        player = new Player();
    }

    /**
     * This is a setter for the time.
     * @param time the time that will be set.
     */
    public void setTime(int time) {
        this.time = time;
    }

    /**
     * This is a setter for the string.
     * @param string the string that will be set.
     */
    public void setString(char string) {
        this.string = string;
    }

    /**
     * This is a setter for the fret.
     * @param fret the fret that will be set.
     */
    public void setFret(int fret) {
        this.fret = fret;
    }

    /**
     * This is a getter for the time.
     * @return the time of the Note.
     */
    public int getTime() {
        return this.time;
    }

    /**
     * This is a getter for the string.
     * @return the string of the Note.
     */
    public char getString() {
        return this.string;
    }

    /**
     * This is a getter for the fret.
     * @return the fret of the Note.
     */
    public int getFret() {
        return this.fret;
    }
}
