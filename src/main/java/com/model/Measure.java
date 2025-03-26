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
     * Measure constructor with length and chords
     * @param length length of the measure in eighth notes
     * @param chords arraylist of chords to be played in the measure
     */
    public Measure(int length, ArrayList<Chord> chords) {
        this.length = length;
        this.chords = chords;
    }

    /**
     * Adds a chord to chords arraylist
     * @param chord chord to be added
     */
    public void addChord(Chord chord) {
        this.chords.add(chord);
    }

    /**
     * removes a chord from chords array
     * @param chord chord to be removed
     */
    public void removeChord(Chord chord) {
        this.chords.remove(chord);
    }

    /**
     * accessor for length
     * @return lenght of measure in eighth notes
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
     * mutator for length variable
     * @param length new length
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
