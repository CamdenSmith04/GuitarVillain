package com.model;

public enum Experience {
    BEGINNER("Beginner"),
    INTERMEDIATE("Intermediate"),
    ADVANCED("Advanced");
    
    private final String label;
    
    private Experience(String label) {
        this.label = label;
    }
}
