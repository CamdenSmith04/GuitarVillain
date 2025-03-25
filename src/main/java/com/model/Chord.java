package com.model;

import java.util.ArrayList;

import org.jfugue.player.Player;

/**
 * This class represents a chord
 * @author Andrew Goad
 * 
 */

public class Chord {

    /**
     * List of notes to be played at the same time as this chord
     */
    private ArrayList<Note> notes;
    /**
     * File path for the chord shape image
     */
    private String chordShape;
    /**
     * Musical name of this chord
     */
    private String name;
    /**
     * player object to play this chord
     */
    private Player player;

    /**
     * Parameterized constructor
     * @param notes List of notes to be played at the same time as this chord
     * @param chordShape Filepath of the image for this chord shape
     * @param name Musical name of this chord
     */
    public Chord(ArrayList<Note> notes, String chordShape, String name) {
        this.notes = notes;
        this.chordShape = chordShape;
        this.name = name;
        this.player = new Player();
    }

    /**
     * Adds note to the note array
     * @param note note to be added to the notes array
     */

    public void addNote(Note note) {
        this.notes.add(note);
    }

    /**
     * remove a note from note array
     * @param note note to be removed
     */

    public void removeNote(Note note) {
        this.notes.remove(note);
    }

    /**
     * Plays the chord with JFugue
     */
    public void play() {
        player.play(name);
    }

    /**
     * Notes mutator
     * @param notes new notes array
     */

    public void setNotes(ArrayList<Note> notes) {
        this.notes = notes;
    }

    /**
     * Chord shape mutator
     * @param chordShape filepath of chordShape image
     */
    public void setChordShape(String chordShape) {
        this.chordShape = chordShape;
    }

    /**
     * Name mutator
     * @param name new name
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * notes accessor
     * @return notes array
     */
    public ArrayList<Note> getNotes() {
        return this.notes;
    }

    /**
     * chordShape accessor
     * @return chordShape image filepath
     */
    public String getChordShape() {
        return this.chordShape;
    }

    /**
     * name accessor
     * @return musical name of the chord
     */

    public String getName() {
        return this.name;
    }
}
