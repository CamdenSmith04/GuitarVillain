package com.model;

import java.util.ArrayList;

public class UI {
    public static void main(String[] args) {
        UserList userList = UserList.getInstance();
        userList.setUsers(DataLoader.getUsers());

        userList.addUser(new User("NewUser", "Password12345!", "Advanced"));


        for (User user : userList.getUsers())
            System.out.println(user);


        DataWriter.saveUsers();
    }
}
