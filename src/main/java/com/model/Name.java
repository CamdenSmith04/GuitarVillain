package com.model;

public enum Name {
    GUITAR("Guitar"),
    BASS("Bass");
    
    private final String label;
    
    private Name(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
