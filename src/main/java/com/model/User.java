package com.model;

import java.util.ArrayList;
import java.util.UUID;

public class User {
    
    private String username;
    private String password;
    private Experience experience;
    private int points;
    private int streak;
    private SecurityQuestion securityQuestion;
    private String securityAnswer;
    private ArrayList<User> friends;
    private ArrayList<Song> songs;
    private final UUID id;

    public User(String username, String password, Experience experience, SecurityQuestion securityQuestion, String securityAnswer) {
        this.id = UUID.randomUUID();
        this.username = username;
        this.password = password;
        this.experience = experience;
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;
    }

    public User(UUID id, String username, String password, Experience experience, SecurityQuestion securityQuestion, String securityAnswer) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.experience = experience;
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;
    }
    
    public User(UUID id, String username, String password, Experience experience) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.experience = experience;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        // TODO: Add password requirements.
        this.password = password;
    }

    public UUID getId() {
        return this.id;
    }

    public void setPassword(SecurityQuestion securityQuestion, String securityAnswer, String password) {
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;
        this.password = password;
    }

    public boolean isMatch(User user) {
        return this.id.equals(user.getId());
    }

    @Override
    public String toString() {
        return this.username + " " + this.id;
    }

    public Experience getExperience() {
        return this.experience;
    }

    public int getPoints() {
        return this.points;
    }

    public int getStreak() {
        return this.streak;
    }

    public ArrayList<User> getFriends() {
        return this.friends;
    }

    public ArrayList<Song> getSongs() {
        return this.songs;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setStreak(int streak) {
        this.streak = streak;
    }

    public void setFriends(ArrayList<User> friends) {
        this.friends = friends;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

}
