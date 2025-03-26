package com.model;
/**
 * Interface for users before signing in
 * @author Abby Holdcraft
 */
public interface GuestInterface {
    public boolean logIn(String username, String password);
    public boolean signUp(String username, String password, Experience experience, SecurityQuestion securityQuestion, String securityAnswer);
    public boolean resetPassword(String username, String securityAnswer, String newPassword);
    public void browseSongs();
    public void browseLessons();
    //TODO add methods

}
