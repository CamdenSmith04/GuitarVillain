package com.model;

public enum Genre {
    ROCK("Rock"),
    JAZZ("Jazz"),
    HIP_HOP("Hip-Hop"),
    POP("Pop"),
    FUNK("Funk"),
    RAP("Rap"),
    CLASSICAL("Classical");
    
    private final String label;
    
    private Genre(String label) {
        this.label = label;
    }

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
