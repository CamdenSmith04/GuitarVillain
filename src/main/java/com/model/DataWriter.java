package com.model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.lang.reflect.Field;

/**
 * Writes data to json files
 * @author Holdcraft
 */
public class DataWriter extends DataConstants {
    public static void saveSongs() {

    }
    public static void saveUsers() {
        UserList users = UserList.getInstance();
        ArrayList<User> userList = users.getUsers();
        JSONArray jsonUsers = new JSONArray();

        // Create all json objects
        for (int i = 0; i < userList.size(); i++) {
            jsonUsers.add(getJSON(userList.get(i)));
        }

        // Write JSON File
        try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
            file.write(jsonUsers.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void saveModules() {

    }

    /*
    private boolean saveObjects() {
        return false;
    }
    */

    public static JSONObject getJSON(Object object) {
        JSONObject objectDetails = new JSONObject();
        try {
            Class<?> objectClass = object.getClass();
            Field[] instanceVariables = objectClass.getDeclaredFields();

            for (Field instanceVariable : instanceVariables) {
                // TODO can you ignore setAccessible?????
                instanceVariable.setAccessible(true); // Allow access to private fields
                objectDetails.put(instanceVariable.getName(), instanceVariable.get(object)); // Put field name & value in JSON
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            objectDetails = null;
        }
        return objectDetails;
    }

    public static void main(String[] args) {
        ArrayList<User> users = DataLoader.getUsers();

        for (User user : users) {
            System.out.println(user);
        }
        
        
    }
}