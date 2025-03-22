package com.model;

import java.util.ArrayList;

/**
 * This class represents a Chord.
 * @author Andrew Goad
 */
public class Chord {

    /**
     * This is the list of notes in a Chord.
     */
    private ArrayList<Note> notes;

    /**
     * This is a path to an image that represents the Chord to be displayed.
     */
    private String chordShape;

    /**
     * This is the name of the Chord.
     */
    private String name;

    /**
     * This is the Chord constructor.
     * @param notes the list of notes that make up this chord.
     * @param chordShape the path to the chord's image.
     * @param name the name of the chord.
     */
    public Chord(ArrayList<Note> notes, String chordShape, String name) {
        this.notes = notes;
        this.chordShape = chordShape;
        this.name = name;
    }

    /**
     * This method allows the user to add a note to the chord's notes.
     * @param note is the Note object to be added.
     */
    public void addNote(Note note) {
        this.notes.add(note);
    }

    /**
     * This method allows the user to remove a note from the chord's notes.
     * @param note is the Note object to be removed.
     */
    public void removeNote(Note note) {
        this.notes.remove(note);
    }

    // TODO: This might need to be used to tie better into JFugue.
    public void play(Instrument instrument, int octave) {

    }

    /**
     * This is a setter for the Chord's notes.
     * @param notes the list of notes to be set.
     */
    public void setNotes(ArrayList<Note> notes) {
        this.notes = notes;
    }

    /**
     * This is a setter for the Chord's image.
     * @param chordShape the path to the chord shape image.
     */
    public void setChordShape(String chordShape) {
        this.chordShape = chordShape;
    }

    /**
     * This is a setter for the Chord's name.
     * @param name the name of the chord.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This is a getter for the Chord's notes.
     * @return the list of notes in a Chord.
     */
    public ArrayList<Note> getNotes() {
        return this.notes;
    }

    /**
     * This is a getter for the Chord's shape image.
     * @return the path to the Chord's shape image.
     */
    public String getChordShape() {
        return this.chordShape;
    }

    /**
     * This is a getter for the Chord's name.
     * @return the name of the Chord.
     */
    public String getName() {
        return this.name;
    }
}
