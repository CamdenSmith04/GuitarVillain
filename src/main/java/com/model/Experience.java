package com.model;

/**
 * @author Bradley Alford
 * This enumeration represents different musical experience levels
 */

public enum Experience {
    /**
     * Beginner label
     */
    BEGINNER("Beginner"),
    /**
     * intermediate label
     */
    INTERMEDIATE("Intermediate"),
    /**
     * advanced label
     */
    ADVANCED("Advanced");
    
    /**
     * label String
     */
    private final String label;
    /**
     * Constructor
     * @param label experience level label
     */
    private Experience(String label) {
        this.label = label;
    }
    /**
     * label accessor
     * @return experience level label
     */
    public String getLabel() {
        return this.label;
    }

    /**
     * returns an object for each experience
     * @param label label to be returned
     * @return returns the experience associated with label parameter, if label does not match, returns null
     */
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
