package com.model;

import java.util.ArrayList;
import java.util.UUID;


public class UserList {
    
    private static UserList userList;
    private ArrayList<User> users;

    private UserList(){
        users = DataLoader.getUsers();
    }

    public User signUp(String username, String password, Experience experience, SecurityQuestion securityQuestion, String securityAnswer) {
        User ret = new User(username, password, experience, securityQuestion, securityAnswer);
        UserList.getInstance().addUser(ret);
        return ret;
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
            if(current.idIsMatch(user.getId())) {
                return current;
            }
        }
        return null;
    }

    public User getUser(String username, String password){
        for(User current : users) {
            if(current.getUsername().equals(username) && current.getPassword().equals(password)) {
                return current;
            }
        }
        return null;
    }

    public User getUser(UUID id){
        for(User current : users) {
            if(current.idIsMatch(id)) {
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
