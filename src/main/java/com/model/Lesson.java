package com.model;

import java.util.UUID;

public class Lesson {
    
    private String title;
    private String educationalMaterial;
    private String visualAid;
    private boolean completed;
    private UUID id;

    public Lesson(String title, String educationalMaterial, String visualAid) {
        this.title = title;
        this.educationalMaterial = educationalMaterial;
        this.visualAid = visualAid;
        this.id = UUID.randomUUID();
    }

    public Lesson(String title, String educationalMaterial, String visualAid, UUID id) {
        this.title = title;
        this.educationalMaterial = educationalMaterial;
        this.visualAid = visualAid;
        this.id = id;
    }

    public boolean isMatch(Lesson lesson) {
        return this.id.equals(lesson.getId());
    }

    public UUID getId() {
        return this.id;
    }
}

