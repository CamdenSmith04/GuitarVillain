package com.model;

import java.util.ArrayList;

/**
 * This class represents a measure in a song.
 * @author Andrew Goad
 */
public class Measure {
    
    /**
     * This represents the length of a measure.
     */
    private int length;

    /**
     * This represents the list of chords in a measure.
     */
    private ArrayList<Chord> chords;

    /**
     * This class constructs a measure.
     * @param length the length of the measure.
     * @param chords the chords in a measure.
     */
    public Measure(int length, ArrayList<Chord> chords) {
        this.length = length;
        this.chords = chords;
    }

    /**
     * This method adds a chord to a measure.
     * @param chord the chord to be added.
     */
    public void addChord(Chord chord) {
        this.chords.add(chord);
    }

    /**
     * This method removes a chord to a measure.
     * @param chord the chord to be removed.
     */
    public void removeChord(Chord chord) {
        this.chords.remove(chord);
    }

    /**
     * This method gets the length of a measure.
     * @return the length of the measure.
     */
    public int getLength() {
        return this.length;
    }

    /**
     * This method gets the array list of chords of a measure.
     * @return the chords in a measure.
     */
    public ArrayList<Chord> getChords() {
        return this.chords;
    }

    /**
     * This method sets the length of a measure.
     * @param length the length that will be set.
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * This method sets the list of chords of a measure.
     * @param chords the list of chords that will be set.
     */
    public void setChords(ArrayList<Chord> chords) {
        this.chords = chords;
    }

}
