package com.model;

public enum Genre {
    ROCK("ROCK"),
    JAZZ("JAZZ"),
    HIP_HOP("HIP-HOP");
    
    private final String label;
    
    private Genre(String label) {
        this.label = label;
    }
}
