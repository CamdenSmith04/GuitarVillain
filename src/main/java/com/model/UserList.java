package com.model;

import java.util.ArrayList;
import java.util.UUID;

/**
 * This class keeps track of all the users in the program and represents the list of users.
 * @author Abby Holdcraft
 */
public class UserList {
    
    /**
     * This is the singleton of the userList object.
     */
    private static UserList userList;

    /**
     * This is the list of users in the userList.
     */
    private ArrayList<User> users;

    /**
     * This constructs the UserList object from the JSON files.
     */
    private UserList(){
        users = DataLoader.getUsers();
    }

    /**
     * This uses a static method to create the single version of the userList.
     * @return the UserList userList that is the singleton.
     */
    public static UserList getInstance(){
        if (userList == null) {
            userList = new UserList();
        }
        return userList;
    }

    /**
     * This method allows a user to sign up and create a new user.
     * @param username the username the user will have.
     * @param password the password the user will have.
     * @param experience the experience the user will have.
     * @param securityQuestion the security question the user chooses.
     * @param securityAnswer the answer to the user's security question.
     * @return the user that is created.
     */
    public User signUp(String username, String password, Experience experience, SecurityQuestion securityQuestion, String securityAnswer) {
        User ret = new User(username, password, experience, securityQuestion, securityAnswer);
        UserList.getInstance().addUser(ret);
        return ret;
    }

    /**
     * This method adds a User object to the list of users.
     * @param user a user to be added to the list of users.
     */
    public void addUser(User user){
        users.add(user);
    }

    // /**
    //  * This method gets a User from the list of users.
    //  * @param user the user being searched for.
    //  * @return the User if it is found in the list of courses.
    //  */
    // public User getUser(User user){
    //     for(User current : users) {
    //         if(current.idIsMatch(user.getId())) {
    //             return current;
    //         }
    //     }
    //     return null;
    // }

    /**
     * This method gets a User from the list of users by username and password.
     * @param username the username of the user being searched for.
     * @param password the password of the user being searched for.
     * @return the user if it is found in the list of users.
     */
    public User getUser(String username, String password){
        for(User current : users) {
            if(current.getUsername().equals(username) && current.getPassword().equals(password)) {
                return current;
            }
        }
        return null;
    }

   
    /**
     * This method gets a User from the list of users by Id.
     * @param user the UUID of the user being searched for.
     * @return the user if it is found in the list of users.
     */
    public User getUser(UUID id){
        for(User current : users) {
            if(current.idIsMatch(id)) {
                return current;
            }
        }
        return null;
    }

    /**
     * This is a getter method to get the list of users in the userList object.
     * @return the list of users.
     */
    public ArrayList<User> getUsers(){
        return this.users;
    }

    /**
     * This method deletes/removes a user from the user list if it is found.
     * @param user the user object to be deleted/removed.
     */
    public void deleteUser(User user){
        for(User current : users) {
            if(current.isMatch(user)) {
                users.remove(current);
                return;
            }
        }
    }

    public User resetPassword(String username, String securityAnswer, String newPassword) {
        for (User user : users) {
            if (user.isMatch(username)) {
                if (user.resetPassword(securityAnswer, newPassword))
                    return user;
                else 
                    return null;
            }
        }
        return null;
    }

}
