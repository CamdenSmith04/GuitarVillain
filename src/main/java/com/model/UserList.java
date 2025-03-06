package com.model;

import java.util.ArrayList;

public class UserList {
    
    private static UserList userList;
    private ArrayList<User> users;

    private UserList(){
        users = new ArrayList<>();
    }

    public static UserList getInstance(){
        if (userList == null) {
            userList = new UserList();
        }
        return userList;
    }

    // TODO: Make sure user can be created :)
    public void addUser(User user){
        users.add(user);
    }

    public User getUser(User user){
        for(User current : users) {
            if(current.isMatch(user)) {
                return current;
            }
        }
        return null;
    }

    public ArrayList<User> getUsers(){
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public void UpdateUser(User user){
        
    }

    public void deleteUser(User user){
        for(User current : users) {
            if(current.isMatch(user)) {
                users.remove(current);
                return;
            }
        }
    }

    public void save(){
        
    }

}
