package com.model;

public enum Genre {
<<<<<<< HEAD
    ROCK("ROCK"),
    JAZZ("JAZZ"),
    HIP_HOP("HIP-HOP");
=======
    ROCK("Rock"),
    JAZZ("Jazz"),
    HIP_HOP("Hip-Hop"),
    POP("Pop"),
    FUNK("Funk"),
    RAP("Rap"),
    CLASSICAL("Classical");
>>>>>>> f7644eff53679632a68251d7055f8775d4a166b6
    
    private final String label;
    
    private Genre(String label) {
        this.label = label;
    }
}
