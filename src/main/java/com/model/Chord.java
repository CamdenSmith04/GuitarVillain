package com.model;

import java.util.ArrayList;

public class Chord {

    private ArrayList<Note> notes;
    private String chordShape;
    private String name;
    

    public Chord(ArrayList<Note> notes, String chordShape, String name) {
        this.notes = notes;
        this.chordShape = chordShape;
        this.name = name;
    }

    public void addNote(Note note) {
        this.notes.add(note);
    }

    public void removeNote(Note note) {
        this.notes.remove(note);
    }

    public void play(Instrument instrument, int octave) {

    }

    public void setNotes(ArrayList<Note> notes) {
        this.notes = notes;
    }

    public void setChordShape(String chordShape) {
        this.chordShape = chordShape;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Note> getNotes() {
        return this.notes;
    }

    public String getChordShape() {
        return this.chordShape;
    }

    public String getName() {
        return this.name;
    }
}
