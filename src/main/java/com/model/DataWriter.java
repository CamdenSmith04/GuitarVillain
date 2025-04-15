package com.model;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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

    public static void save() {
        saveCourses();
        saveLessons();
        saveModules();
        saveSongs();
        saveUsers();
    }

    /**
     * Manages JSONArray of objectList and writes to JSON for any object type.
     */
    @SuppressWarnings("unchecked")
    private static void saveObjects(ArrayList<?> objectList, String OBJECT_FILE_NAME) {
        JSONArray jsonObjects = new JSONArray();
        visited = Collections.newSetFromMap(new IdentityHashMap<>());
        // Create all json objects
        for (Object object : objectList) {
            if (object instanceof Teacher)
                jsonObjects.add(objectToJson(new User((Teacher)object)));
            else if (object instanceof Student)
            jsonObjects.add(objectToJson(new User((Student)object)));
            else
                jsonObjects.add(objectToJson(object));
        }

        // Write JSON File
        try (FileWriter file = new FileWriter(OBJECT_FILE_NAME)) {
            file.write(jsonObjects.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Set<Object> visited;

    /**
     * Converts inputted object into JSONObject
     * @param object Object to be converted
     * @return Object as type JSONObject
     */
    @SuppressWarnings("unchecked")
    private static JSONObject objectToJson(Object object) {
        if (object == null)
            return null;
        
        JSONObject jsonObject = new JSONObject();

        if (visited.contains(object)) {
            jsonObject.put("circularReference", true);
            return jsonObject;
        }
        visited.add(object);

        Class<?> objectClass = object.getClass();
        Field[] fields = objectClass.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object name = field.getName();
                if (isIgnore(name)) continue;
                Object value = field.get(object);
                jsonObject.put(name, handleValue(value));

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return jsonObject;
    }
    
    /**
     * Directs object to different json converter classes depending on its type
     * @param value Value to be converted
     * @return Object as its correct type (string, int, JSONObject, etc)
     */
    private static Object handleValue(Object value) {
        if (value == null || (isPrimitive(value) && value.getClass() != char.class)) {
            return value;
        } else if (value.getClass().isArray()) {
            return arrayToJsonArray(value);
        } else if (value instanceof Collection<?>) {
            return collectionToJsonArray((Collection<?>) value);
        } else if (isNestedObject(value)) {
            return objectToJson(value);
        } else if (value instanceof Instrument) {
            Instrument instrument = (Instrument)value;
            return instrument.toString();
        } else {
            return value.toString();
        }
    }

    /**
     * Checks list of items to ignore writing to json
     * @param name Object checked
     * @return True if object is in list
     */
    private static boolean isIgnore(Object name) {
        return name.equals("NOTES") ||
                name.equals("player");
    }

    /**
     * Checks if parameter object is primitive or wrapper primitive
     * @param object Object checked
     * @return True if object is primitive or wrapper
     */
    private static boolean isPrimitive(Object object) {
        return object instanceof Integer ||
                object instanceof Double ||
                object instanceof Boolean ||
                object instanceof Byte ||
                object instanceof Short ||
                object instanceof Long ||
                object instanceof Float ||
                object.getClass().isPrimitive();
    }

    /**
     * Checks if a field is a nested object with its own fields.
     * @param object Object checked
     * @return True if field is a nested object.
     */
    private static boolean isNestedObject(Object object) {
        return object instanceof Measure ||
                object instanceof Chord ||
                object instanceof Note;
    }

    /**
     * Converts an array to a JSONArray
     * @param array Array being converted
     * @return Array as JSONArray
     */
    @SuppressWarnings("unchecked")
    private static JSONArray arrayToJsonArray(Object array) {
        JSONArray jsonArray = new JSONArray();
        int length = Array.getLength(array);
        for (int i = 0; i < length; i++) {
            Object element = Array.get(array, i);
            jsonArray.add(handleValue(element));
        }
        return jsonArray;
    }

    /**
     * Converts a collection to a JSONArray
     * @param array Collection being converted
     * @return Collection as JSONArray
     */
    @SuppressWarnings("unchecked")
    private static JSONArray collectionToJsonArray(Collection<?> collection) {
        JSONArray jsonArray = new JSONArray();
        for (Object item : collection) {
            jsonArray.add(handleValue(item));
        }
        return jsonArray;
    }

}