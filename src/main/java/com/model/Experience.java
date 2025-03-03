package com.model;

<<<<<<< HEAD
import java.util.Enumeration;

=======
>>>>>>> 1d256fa (Add enums)
public enum Experience {
    BEGINNER("Beginner"),
    INTERMEDIATE("Intermediate"),
    ADVANCED("Advanced");
    
<<<<<<< HEAD
    private final String label;
    
    private Experience(String label) {
        this.label = label;
    }

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


=======
    private final String experienceLevel;
    
    private Experience(String experienceLevel) {
        this.experienceLevel = experienceLevel;
    }
>>>>>>> 1d256fa (Add enums)
}
