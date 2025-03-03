package com.model;

import java.util.ArrayList;

public class UserList {
    
    private static UserList userList;

    private ArrayList<Lesson> users;

    private UserList(){
    
    }

    public static UserList getInstance(){
        if (userList == null) {
            userList = new UserList();
        }
        return userList;
    }

    public void createUser(User user){
        
    }

    public User getUser(String username, String password){
        // TODO: FIX
        return null;
    }

    public ArrayList<User> getUsers(){
        // TODO: FIX
        return null;
    }
    public void UpdateUser(User user){

    }

    public void deleteUser(User user){

    }

    public void save(){
        
    }

}
