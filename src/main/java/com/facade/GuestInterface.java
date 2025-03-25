package com.facade;

import com.model.Experience;
import com.model.Lesson;
import com.model.SecurityQuestion;

public interface GuestInterface {
    public boolean logIn(String username, String password);
    public boolean signUp(String username, String password, Experience experience, SecurityQuestion securityQuestion, String securityAnswer);
    public boolean resetPassword(String username, String securityAnswer, String newPassword);
    public void browseSongs();
    public void browseLessons();
    public void enterLesson(Lesson lesson);
    //TODO add methods

}
