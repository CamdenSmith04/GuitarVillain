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
