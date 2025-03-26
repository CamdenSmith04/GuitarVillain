package com.model;

/**
 * @author Camden Smith
 * This enumeration represents the different visibility levels a song may have.
 */
public enum Visibility {
    /**
     * Private label
     */
    PRIVATE("Private"),

    /**
     * Friends only label
     */
    FRIENDS_ONLY("Friends-Only"),

    /**
     * Public label
     */
    PUBLIC("Public");
    
    
    /**
     * label String
     */
    private final String label;
    
    /**
     * Constructor
     * @param label visibility label
     */
    private Visibility(String label) {
        this.label = label;
    }

    /**
     * label accessor
     * @return visibility label
     */
    public String getLabel() {
        return label;
    }

    /**
     * returns an object for each visibility
     * @param label label to be returned.
     * @return the visibility associated with label parameters.
     */
    public static Visibility getVisibility(String label) {
        if (label.equals(PRIVATE.label))
            return PRIVATE;
        if (label.equals(FRIENDS_ONLY.label))
            return FRIENDS_ONLY;
        if (label.equals(PUBLIC.label))
            return PUBLIC;
        return null;

    }
}
