package com.model;

import java.util.UUID;

public class Lesson {
    
    private String title;
    private String educationalMaterial;
    // TODO: Fix
    // private Image visualAid
    private boolean completed;
    private UUID id;

    // TODO: Fix image
    public Lesson(String title, String educationalMaterial, Image visualAid) {
        this.title = title;
        this.educationalMaterial = educationalMaterial;
        this.visualAid = visualAid;
        this.id = UUID.randomUUID();
    }

    public Lesson(String title, String educationalMaterial, Image visualAid, UUID id) {
        this.title = title;
        this.educationalMaterial = educationalMaterial;
        this.visualAid = visualAid;
        this.id = id;
    }

    public Lesson isMatch(String title) {
        return null;
    }
}

