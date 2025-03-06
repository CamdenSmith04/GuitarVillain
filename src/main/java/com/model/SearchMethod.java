package com.model;

public enum SearchMethod {
    TITLE("Title"),
    GENRE("Genre"),
    AUTHOR("Author");
    
    private final String label;
    
    private SearchMethod(String label) {
        this.label = label;
    }
}
