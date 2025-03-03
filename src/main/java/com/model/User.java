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
    private UUID id;

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

    public void setPassword(SecurityQuestion securityQuestion, String securityAnswer, String password) {
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;
        this.password = password;
    }

    public User isMatch(String username, String password) {
        return null;
    }
}
