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
    protected ArrayList<UUID> friends;
    protected ArrayList<UUID> songs;
    protected final UUID id;

    public User(UUID id, String username, String password, Experience experience, int points, 
                    int streak, SecurityQuestion securityQuestion, String securityAnswer, 
                    ArrayList<UUID> friends, ArrayList<UUID> songs) {
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
        points = 0;
        streak = 0;
        friends = new ArrayList<UUID>();
        songs = new ArrayList<UUID>();
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

    public boolean resetPassword(String securityAnswer, String newPassword) {
        if (this.securityAnswer.equalsIgnoreCase(securityAnswer)) {
            this.password = newPassword;
            return true;
        }
            return false;
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
        return this.isMatch(user);
    }

    public boolean idIsMatch(UUID id){
        return this.id.equals(id);
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

    public ArrayList<UUID> getFriends() {
        return friends;
    }

    public ArrayList<UUID> getSongs() {
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

    public void setFriends(ArrayList<UUID> friends) {
        this.friends = friends;
    }

    public void setSongs(ArrayList<UUID> songs) {
        this.songs = songs;
    }

    public void addSong(Song song){
        this.songs.add(song.getId());
    }

    public SecurityQuestion getSecurityQuestion() {
        return this.securityQuestion;
    }

    public void setSecurityQuestion(SecurityQuestion securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getSecurityAnswer() {
        return this.securityAnswer;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }

    
}
