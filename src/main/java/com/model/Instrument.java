package com.model;

public class Instrument {
    
    private Name name;
    // private ArrayList<Note> seclectedNotes;
    // private int volume;
    // // private final static String SOUND_LIBRARY_NAME;

    public Instrument(Name name) {
        this.name = name;
    }

    public void playSelectedChord(String soundLibrary) {
        
    }

    public Name getName() {
        return this.name;
    }

}
