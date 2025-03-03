package com.model;

public enum Experience {
    BEGINNER("Beginner"),
    INTERMEDIATE("Intermediate"),
    ADVANCED("Advanced");
    
    private final String experienceLevel;
    
    private Experience(String experienceLevel) {
        this.experienceLevel = experienceLevel;
    }
}
