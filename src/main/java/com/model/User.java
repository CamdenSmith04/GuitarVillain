package com.model;

import java.util.ArrayList;
import java.util.UUID;

public class User {
    
    protected String username;
    protected String password;
    protected Experience experience;
    protected int points;
    protected int streak;
    protected SecurityQuestion securityQuestion;
    protected String securityAnswer;
    protected ArrayList<User> friends;
    protected ArrayList<Song> songs;
    protected final UUID id;

    public User() {
        this.id = UUID.randomUUID();
    }

    public User(String username, String password, Experience experience, int points, 
                    int streak, SecurityQuestion securityQuestion, String securityAnswer, 
                    ArrayList<User> friends, ArrayList<Song> songs) {
        this.id = UUID.randomUUID();
        this.username = username;
        this.password = password;
        this.experience = experience;
        this.points = points;
        this.streak = streak;
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;
        this.friends = friends;
        this.songs = songs;
    }

    public User(UUID id, String username, String password, Experience experience, int points, 
                    int streak, SecurityQuestion securityQuestion, String securityAnswer, 
                    ArrayList<User> friends, ArrayList<Song> songs) {
        this.username = username;
        this.password = password;
        this.experience = experience;
        this.points = points;
        this.streak = streak;
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;
        this.friends = friends;
        this.songs = songs;
        this.id = id;
    }

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
    
    public User(String username, String password, Experience experience) {
        this.id = UUID.randomUUID();
        this.username = username;
        this.password = password;
        this.experience = experience;
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
