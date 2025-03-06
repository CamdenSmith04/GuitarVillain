package com.model;

public enum Experience {
    BEGINNER("Beginner"),
    INTERMEDIATE("Intermediate"),
    ADVANCED("Advanced");
    
    private final String label;
    
    private Experience(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }

    public static Experience getExperience(String label) {
        if (BEGINNER.label.equalsIgnoreCase(label))
            return BEGINNER;
        if (INTERMEDIATE.label.equalsIgnoreCase(label))
            return INTERMEDIATE;
        if (ADVANCED.label.equalsIgnoreCase(label))
            return ADVANCED;
        return null;
    }


}
