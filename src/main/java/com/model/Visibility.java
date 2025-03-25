package com.model;

public enum Visibility {
    PRIVATE("Private"),
    FRIENDS_ONLY("Friends-Only"),
    PUBLIC("Public");
    
    private final String label;
    
    private Visibility(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
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
