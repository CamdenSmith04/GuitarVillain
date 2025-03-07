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
    /**
     * Updates JSON file to reflect current CourseList
     */
    public static void saveCourses() {
        CourseList courses = CourseList.getInstance();
        saveObjects(courses.getCourses(), COURSE_FILE_NAME);
    }
    /**
     * Updates JSON file to reflect current LessonList
     */
    public static void saveLessons() {
        LessonList lessons = LessonList.getInstance();
        saveObjects(lessons.getLessons(), LESSON_FILE_NAME);
    }
    /**
     * Updates JSON file to reflect current ModuleList
     */
    public static void saveModules() {
        ModuleList modules = ModuleList.getInstance();
        saveObjects(modules.getModules(), MODULE_FILE_NAME);
    }
    /**
     * Updates JSON file to reflect current SongList
     */
    public static void saveSongs() {
        SongList songs = SongList.getInstance();
        saveObjects(songs.getSongs(), SONG_FILE_NAME);
    }
    /**
     * Updates JSON file to reflect current UserList
     */
    public static void saveUsers() {
        UserList users = UserList.getInstance();
        saveObjects(users.getUsers(), USER_FILE_NAME);
    }

    /**
     * Manages JSONArray of objectList and writes to JSON for any object type.
     */
    @SuppressWarnings("unchecked")
    private static void saveObjects(ArrayList<?> objectList, String OBJECT_FILE_NAME) {
        JSONArray jsonObjects = new JSONArray();

        // Create all json objects
        for (int i = 0; i < objectList.size(); i++) {
            jsonObjects.add(getJSON(objectList.get(i)));
        }

        // Write JSON File
        try (FileWriter file = new FileWriter(OBJECT_FILE_NAME)) {
            file.write(jsonObjects.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Converts inputted object into JSONObject
     * @param object Object to be converted
     * @return Object as type JSONObject
     */
    @SuppressWarnings("unchecked")
    private static JSONObject getJSON(Object object) {
        JSONObject objectDetails = new JSONObject();
        try {
            Class<?> objectClass = object.getClass();
            Field[] fields = objectClass.getDeclaredFields();

            for (Field field : fields) {
                Object value = (field.get(object));
                if (value instanceof Number)
                    objectDetails.put(field.getName(), value);
                else
                    objectDetails.put(field.getName(), String.valueOf(value)); // Put field name & value in JSON
                
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            objectDetails = null;
        }
        return objectDetails;
    }
}