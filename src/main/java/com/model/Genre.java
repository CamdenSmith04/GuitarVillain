package com.model;

public enum Genre {
    ROCK("Rock"),
    JAZZ("Jazz"),
    HIP_HOP("Hip-Hop"),
    POP("Pop"),
    FUNK("Funk"),
    RAP("Rap"),
    CLASSICAL("Classical");
    
    private final String label;
    
    private Genre(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
