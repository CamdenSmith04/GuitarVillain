package com.model;
/**
 * User type that has access to all commands
 */
public class Admin extends User {
    public Admin(User user) {
        super(user.id, user.username, user.password, user.experience, user.points, user.streak, user.securityQuestion, user.securityAnswer, user.friends, user.songs);
        this.role = "Admin";
    }
}
