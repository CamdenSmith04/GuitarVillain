package com.model;

public class Instrument {
    
    private Name name;
    // private ArrayList<Note> seclectedNotes;
    // private int volume;
    // // private final static String SOUND_LIBRARY_NAME;

    public Instrument(String name) {
        this.name = (Name.valueOf((String) name));
    }

    public void playSelectedChord(String soundLibrary) {
        
    }

}
