package com.model;

/**
 * @author Camden Smith
 * This enum represents the different genres that can be associated with a song
 */

public enum Genre {
    ROCK("Rock"),
    JAZZ("Jazz"),
    HIP_HOP("Hip-Hop"),
    POP("Pop"),
    FUNK("Funk"),
    RAP("Rap"),
    CLASSICAL("Classical");
    /**
     * the label representing the genre
     */
    private final String label;
    /**
     * Constructor for the enum
     * @param label The label representing the genre
     */
    
    private Genre(String label) {
        this.label = label;
    }

    /**
     * accessor for the label
     * @return label representing the genre
     */
    public String getLabel() {
        return label;
    }
      /**
     * returns an object for each genre
     * @param label label to be returned
     * @return returns the genre associated with label parameter, if label does not match, returns null
     */
    public static Genre getGenre(String label) {
        if (label.equals(ROCK.label))
            return ROCK;
        if (label.equals(JAZZ.label))
            return JAZZ;
        if (label.equals(HIP_HOP.label))
            return HIP_HOP;
        if (label.equals(POP.label))
            return POP;
        if (label.equals(FUNK.label))
            return FUNK;
        if (label.equals(RAP.label))
            return RAP;
        if (label.equals(CLASSICAL.label))
            return CLASSICAL;
        return null;

    }
}
