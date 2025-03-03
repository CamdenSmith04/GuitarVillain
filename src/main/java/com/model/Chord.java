package com.model;

import java.util.ArrayList;

public class Chord {
    private ArrayList<Note> notes;
    // TODO: Fix
    // private image chordShape;
    private String name;

    public Chord() {

    }

    public void addNote(Note note) {
        this.notes.add(note);
    }

    public void removeNote(Note note) {
        this.notes.remove(note);
    }

    // TODO: Not sure what this is supposed to be
    public void play(Instrument instrument, int octave) {

    }
}
