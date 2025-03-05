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

    public String getTitle() {
        return this.title;
    }

    public String getEducationalMaterial() {
        return this.educationalMaterial;
    }

    public String getVisualAid() {
        return this.visualAid;
    }

    public boolean getCompleted() {
        return this.completed;
    }

    public UUID getId() {
        return this.id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setEducationalMaterial(String educationalMaterial) {
        this.educationalMaterial = educationalMaterial;
    }

    public void setVisualAid(String visualAid) {
        this.visualAid = visualAid;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}

