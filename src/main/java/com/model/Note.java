package com.model;
import org.jfugue.player.Player;

/**
 * This class represents a single note
 * @author Andrew Goad
 */

public class Note {
    /**
     * The time in the measure that the note should be played
     */
    private int time;
    /**
     * String on the guitar associated with the note
     * NOTE: e is for high e, E is for low e.
     */
    private char string;
    /**
     * Guitar fret number associated with the note
     */
    private int fret;
    /**
     * Musical name of the note
     */
    private String note;
    /**
     * Player object to play a ntoe
     */
    private Player player;

    /**
     * Array of all possible note names
     */
    private static final String[] NOTES = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
    /**
     * Gets name of note, generated from fret and string
     * @return musical name of the note
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
     * gets note from notes array
     * @param note Name of the note
     * @return array index of the note
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
     * converts flat notes to equivalent sharp notes
     * @param note note name to be covnerted to flat
     * @return converted note name
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
     * plays note from name, using JFugue
     */
    public void play(){
        player.play(this.getNoteName());
    }
    /**
     * Note constructor
     * @param time time in mesure to be played at
     * @param string guitar string name note is played on
     * @param fret fret number note is played at
     */

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
     * mutator for time
     * @param time new time for note to be played at
     */

    public void setTime(int time) {
        this.time = time;
    }

    /**
     * mutator for string
     * @param string new string for ntoe to be played on
     */

    public void setString(char string) {
        this.string = string;
    }
    /**
     * mutator for fret
     * @param fret new fret for note to be played at 
     */
    public void setFret(int fret) {
        this.fret = fret;
    }
    /**
     * accessor for time
     * @return time in measure the note will be played at
     */
    public int getTime() {
        return this.time;
    }

    /**
     * accessor for string
     * @return Guitar string the note will be played on
     */

    public char getString() {
        return this.string;
    }

    /**
     * Accessor for fret
     * @return Guitar fret that the note will be playe at
     */
    public int getFret() {
        return this.fret;
    }
}
