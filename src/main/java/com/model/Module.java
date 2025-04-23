package com.model;

import java.util.ArrayList;
import java.util.UUID;

/**
 * This class represents a Module.
 * @author Camden Smith
 */
public class Module {

    /**
     * This is the title of the module.
     */
    private String title;

    /**
     * This is the list of lessons in the module.
     */
    private ArrayList<UUID> lessons;

    /**
     * This is the list of songs in the module.
     */
    private ArrayList<UUID> songs;

    /**
     * This is a users progress in the module.
     */
    private double progress;

    /**
     * This is the UUID of the module.
     */
    private final UUID id;

    /**
     * Name of module's cover image
     */
    private String image;

    /**
     * This is a constructor for a new Module.
     * @param title the title of the module.
     */
    public Module(String title) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.lessons = new ArrayList<>();
        this.songs = new ArrayList<>();
        this.progress = 0.0;
    }
    
    /**
     * This constructor is used to instantiate an existing module from the JSON files.
     * @param id the UUID of the module.
     * @param title the title of the module.
     * @param lessons the lessons in the module.
     * @param songs the songs in the module.
     * @param progress the progress of the module.
     * @param image the name of the module's cover image
     */
    public Module(UUID id, String title, ArrayList<UUID> lessons, ArrayList<UUID> songs, double progress, String image) {
        this.id = id;
        this.title = title;
        this.lessons = lessons;
        this.songs = songs;
        this.progress = progress;
        this.image = image;
    }


    /**
     * This method is used to see if the module is a match.
     * @param module the module being compared to this module.
     * @return true if the modules are a match, otherwise false.
     */
    public boolean isMatch(Module module) {
        if (module == null){
            return false;
        }
        return this.id.equals(module.getId());
    }

    /**
     * This method is used to see if the UUID of this module is a match.
     * @param module the UUID of a module being compared to this module.
     * @return true if the modules have the same UUID, otherwise false.
     */
    public boolean idIsMatch(UUID module) {
        return this.id.equals(module);
    }

    /**
     * This method is used to add lessons to a module.
     * @param lesson the UUID of a lesson to be added to a course.
     */
    public boolean addLesson(UUID lesson) {
        if (lesson == null) {
            return false;
        }
        for (UUID match : lessons) {
            if (match.equals(lesson)){
                return false;
            }
        }
        this.lessons.add(lesson);
        return true;

    }

    /**
     * This method is used to remove a lesson from a course.
     * @param lesson the UUID of a lesson to be removed from a course.
     */
    public boolean removeLesson(UUID lesson) {
        if (lesson == null) {
            return false;
        }
        for (UUID match : lessons) {
            if (match.equals(lesson)){
                this.lessons.remove(lesson);
                return true;
            }
        }
        return false;
    }

    /**
     * This method is used to add songs to a module.
     * @param song the UUID of a song to be added to a module.
     */
    public boolean addSong(UUID song) {
        if (song == null) {
            return false;
        }
        for (UUID match : songs) {
            if (match.equals(song)){
                return false;
            }
        }
        this.songs.add(song);
        return true;
    }

    /**
     * This method is used to remove a song from a module.
     * @param song the UUID of a song to be removed from a module.
     */
    public boolean removeSong(UUID song) {
        if (song == null) {
            return false;
        }
        for (UUID match : songs) {
            if (match.equals(song)){
                this.songs.remove(song);
                return true;
            }
        }
        return false;
    }


    /**
     * This is a getter for the title of the module.
     * @return the module's title.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * This is a getter for the list of lessons in a module.
     * @return the list of lessons in a module.
     */
    public ArrayList<UUID> getLessons() {
        return this.lessons;
    }

    /**
     * This method is used to get a lesson from a module.
     * @param lesson the UUID of a lesson being searched for.
     * @return the UUID of the lesson if they are found in the module, if not the return is a null UUID.
     */
    public UUID getLesson(UUID lesson) {
        for (UUID match: this.lessons) {
            if (match == lesson){
                return match;
            }
        }
        return null;
    }

    /**
     * This is a getter for the songs in a module.
     * @return the list of songs in a module.
     */
    public ArrayList<UUID> getSongs() {
        return this.songs;
    }

    /**
     * This method is used to get a song from a module.
     * @param song the UUID of a song being searched for.
     * @return the UUID of the song if they are found in the module, if not the return is a null UUID.
     */
    public UUID getSong(UUID song) {
        for (UUID match: this.songs) {
            if (match == song){
                return match;
            }
        }
        return null;
    }

    /**
     * This is a getter for the module's progress.
     * @return the progress of the module.
     */
    public double getProgress() {
        return this.progress;
    }

    /**
     * This is a getter for the id of a module.
     * @return the module's id.
     */
    public UUID getId() {
        return this.id;
    }

    /**
     * This is a setter for the module's title.
     * @param title the title which the module will have.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This is a setter for the lessons in a module.
     * @param lessons the list of lessons the module will have.
     */
    public void setLessons(ArrayList<UUID> lessons) {
        this.lessons = lessons;
    }

    /**
     * This is a setter for the songs in a module.
     * @param songs the list of songs the module will have.
     */
    public void setSongs(ArrayList<UUID> songs) {
        this.songs = songs;
    }

    /**
     * This is a setter for the progress of a module.
     * @param progress the progress the module will have.
     */
    public void setProgress(double progress) {
        this.progress = progress;
    }

    /**
     * This method converts the modules data fields into strings.
     * @return the string of all the data fields.
     */
    @Override
    public String toString() {
        return ("Title: " + this.title + "\n" + 
        "Id: " + this.id + "\n" +
        "Lessons: " + this.lessons + "\n" + 
        "Songs: " + this.songs + "\n" + 
        "Progress: " + this.progress);
    }

    /**
     * Mutator for image url
     * @param image the url
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Accessor for image url
     * @return the image url name
     */
    public String getImage() {
        return image;
    }

}
