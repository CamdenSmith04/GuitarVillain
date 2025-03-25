package com.model;

public class Admin extends User {
    public Admin(User user) {
        super(user.id, user.username, user.password, user.experience, user.points, user.streak, user.securityQuestion, user.securityAnswer, user.friends, user.songs);
        this.role = "Admin";
    }
}
