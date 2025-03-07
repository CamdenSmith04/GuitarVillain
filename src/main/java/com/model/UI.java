package com.model;

public class UI {
    public static void main(String[] args) {
        /*
         * Code to test DataLoader and DataWriter.
         * Will load userlist, add a new user, print users, then write new userlist to users.json
         * 
         * NOTE: DataLoader only reads instance variables id, username, passowrd, and experience 
         * and therefore this code does not properly save user data. 
         * However, DataWriter should work as intended once DataLoader is fixed. 
         * - Abby :3
         */
        UserList userList = UserList.getInstance();
        userList.setUsers(DataLoader.getUsers());
        userList.addUser(new User("newUser", "Password12345!", Experience.BEGINNER, SecurityQuestion.PET_NAME, "Moxy&Doxy"));

        for (User user : userList.getUsers())
            System.out.println(user);

        DataWriter.saveUsers();
    }
}
