package com.model;

import java.util.ArrayList;

public class Measure {
    
    private int length;
    private ArrayList<Chord> chords;

    public Measure(int length, ArrayList<Chord> chords) {
        this.length = length;
        this.chords = chords;
    }

    public void addChord(Chord chord) {
        this.chords.add(chord);
    }

    public void removeChord(Chord chord) {
        this.chords.remove(chord);
    }

    public int getLength() {
        return this.length;
    }

    public ArrayList<Chord> getChords() {
        return this.chords;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setChords(ArrayList<Chord> chords) {
        this.chords = chords;
    }

}
