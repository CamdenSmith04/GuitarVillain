package com.model;

import java.util.UUID;

/**
 * This class represents a Lesson.
 * @author Camden Smith
 */
public class Lesson {
    
    /**
     * This is the name of the lesson.
     */
    private String title;

    /**
     * This is the educational material in a lesson.
     */
    private String educationalMaterial;

    /**
     * This is the path to the lesson's visual aid.
     */
    private String visualAid;

    /**
     * This is a boolean to mark the lesson's completion.
     */
    private boolean completed;

    /**
     * This is the UUID of the lesson.
     */
    private final UUID id;

    /**
     * This is a constructor for a new Lesson.
     * @param title the title of the the lesson.
     * @param educationalMaterial the educational material for the lesson.
     * @param visualAid the path to the visual aid image.
     */
    public Lesson(String title, String educationalMaterial, String visualAid) {
        this.title = title;
        this.educationalMaterial = educationalMaterial;
        this.visualAid = visualAid;
        this.completed = false;
        this.id = UUID.randomUUID();
    }

    /**
     * This constructor is used to instantiate an existing lesson from JSON.
     * @param title the title of the lesson.
     * @param educationalMaterial the educational material in the lesson.
     * @param visualAid the path to the visual aid image.
     * @param id the lesson's UUID.
     * @param completed the completion status of the lesson.
     */
    public Lesson(String title, String educationalMaterial, String visualAid, UUID id, boolean completed) {
        this.title = title;
        this.educationalMaterial = educationalMaterial;
        this.visualAid = visualAid;
        this.id = id;
        this.completed = completed;
    }

    /**
     * This method is used to see if the lesson is a match.
     * @param lesson the lesson being compared to this lesson.
     * @return true if the lessons are a match, otherwise false.
     */
    public boolean isMatch(Lesson lesson) {
        return this.id.equals(lesson.getId());
    }

    /**
     * This method is used to see if the UUID of this lesson is a match.
     * @param lesson the UUID of a lesson being compared to this lesson.
     * @return true if the lessons have the same UUID, otherwise false.
     */
    public boolean idIsMatch(UUID lesson) {
        return this.id.equals(lesson);
    }

    /**
     * This is a getter for the lesson's title.
     * @return the lesson's title.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * This is a getter for the lesson's educational material.
     * @return the lesson's educational material.
     */
    public String getEducationalMaterial() {
        return this.educationalMaterial;
    }

    /**
     * This is a getter for the lesson's visual aid.
     * @return the path to the lesson's visual aid image.
     */
    public String getVisualAid() {
        return this.visualAid;
    }

    /**
     * This is a getter for the lesson's completion.
     * @return whether of not the lesson has been completed.
     */
    public boolean getCompleted() {
        return this.completed;
    }

    /**
     * This is a getter for the lesson's id.
     * @return the lesson's id.
     */
    public UUID getId() {
        return this.id;
    }

    /**
     * This is a setter for the lesson's name.
     * @param title the title which the lesson will have.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This is a setter for the lesson's educational material.
     * @param educationalMaterial the educational material the lesson will have.
     */
    public void setEducationalMaterial(String educationalMaterial) {
        this.educationalMaterial = educationalMaterial;
    }

    /**
     * This is a setter for the lesson's visual aid path.
     * @param visualAid the path to the lesson's visual aid.
     */
    public void setVisualAid(String visualAid) {
        this.visualAid = visualAid;
    }

    /**
     * This is a setter for the lesson's completion.
     * @param completed the completion of the lesson.
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    /**
     * This method converts the lessons data fields into strings.
     * @return the string of all the data fields.
     */
    @Override
    public String toString() {
        return ("Title: " + this.title + "\n" + 
        "Id: " + this.id + "\n" +
        "Educational Material: " + this.educationalMaterial + "\n" + 
        "Visual Aid: " + this.visualAid + "\n" + 
        "Completed: " + this.completed);

    }

}

