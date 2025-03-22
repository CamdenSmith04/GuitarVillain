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
}
