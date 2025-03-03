package com.model;

public class Note {
    
    private int time;
    private char string;
    private int fret;

    public Note() {

    }

    public Note(int time, char string, int fret) {
        this.time = time;
        this.string = string;
        this.fret = fret;
    }
}
