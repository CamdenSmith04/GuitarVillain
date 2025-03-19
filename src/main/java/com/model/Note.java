package com.model;

public class Note {
    
    private int time;
    private char string;
    private int fret;
    private String note;

    
    private static final String[] NOTES = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};

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

    private static int findNoteIndex(String note) {
        for (int i = 0; i < NOTES.length; i++) {
            if (NOTES[i].equals(note)) {
                return i;
            }
        }
        return -1;
    }

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
    

    public Note() {

    }

    public Note(int time, char string, int fret) {
        this.time = time;
        this.string = string;
        this.fret = fret;
        
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setString(char string) {
        this.string = string;
    }

    public void setFret(int fret) {
        this.fret = fret;
    }

    public int getTime() {
        return this.time;
    }

    public char getString() {
        return this.string;
    }

    public int getFret() {
        return this.fret;
    }
}
