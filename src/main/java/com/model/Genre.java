package com.model;

public enum Genre {
    ROCK("Rock"),
    JAZZ("JAZZ"),
    HIP_HOP("Hip-Hop");
    
    private final String label;
    
    private Genre(String label) {
        this.label = label;
    }
}
