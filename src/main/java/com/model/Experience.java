package com.model;

public enum Experience {
    BEGINNER("Beginner"),
    INTERMEDIATE("Intermediate"),
    ADVANCED("Advanced");
    
    private final String label;
    
    private Experience(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    public static Experience getExperience(String label) {
        if (label.equals(BEGINNER.label))
            return BEGINNER;
        if (label.equals(INTERMEDIATE.label))
            return INTERMEDIATE;
        if (label.equals(ADVANCED.label))
            return ADVANCED;
        return null;

    }
}
