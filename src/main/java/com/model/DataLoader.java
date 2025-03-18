package com.model;
import java.util.ArrayList;
import java.util.UUID;
import java.io.File;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javafx.scene.image.Image;


public class DataLoader extends DataConstants{

    public static ArrayList<Song> getSongs(){
        ArrayList<Song> songs = new ArrayList<Song>();
    
        try {
            FileReader reader = new FileReader(SONG_FILE_NAME);
            JSONArray songsJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i = 0; i<songsJSON.size(); i++){
                JSONObject songJSON = (JSONObject)songsJSON.get(i);
                UUID id = UUID.fromString((String)songJSON.get(SONG_ID));
                String title = (String)songJSON.get(SONG_TITLE);
                String author = (String)songJSON.get(SONG_AUTHOR);

                songs.add(new Song(id, title, author));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return songs;
    }
    public static ArrayList<User> getUsers(){
        ArrayList<User> users = new ArrayList<User>();
        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONArray usersJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i = 0; i<usersJSON.size(); i++){
                JSONObject userJSON = (JSONObject)usersJSON.get(i);
                UUID id = UUID.fromString((String)userJSON.get(SONG_ID));
                String username = (String)userJSON.get(USER_USERNAME);
                String password = (String)userJSON.get(USER_PASSWORD);
                Experience experience = Experience.getExperience((String)userJSON.get(USER_EXPERIENCE));
                //TODO: Fill out constructor!!!
                users.add(new User(id, username, password, experience,0,0,null,null,null,null));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
    public static ArrayList<Module> getModules(){
        ArrayList<Module> modules = new ArrayList<Module>();
        try{
            FileReader reader = new FileReader(MODULE_FILE_NAME);
            JSONArray modulesJSON = (JSONArray)new JSONParser().parse(reader);
            
            for(int i = 0; i<modulesJSON.size(); i++){
                JSONObject moduleJSON = (JSONObject)modulesJSON.get(i);
                UUID id = UUID.fromString((String)moduleJSON.get(SONG_ID));
                String title = (String)moduleJSON.get(SONG_TITLE);
                JSONArray lessonsJSON = (JSONArray) moduleJSON.get(MODULE_LESSONS);
                ArrayList<Lesson> lessons = new ArrayList<>();
                ArrayList<Song> songs = new ArrayList<>();
                JSONArray songsJSON = (JSONArray) moduleJSON.get(MODULE_SONGS);

                for (Object lessonObj : lessonsJSON) {
                    JSONObject lessonJSON = (JSONObject) lessonObj;
                    UUID lessonId = UUID.fromString((String) lessonJSON.get(LESSON_ID));
                    String lessonTitle = (String) lessonJSON.get(LESSON_TITLE);
                }

                for (Object songObj : songsJSON) {
                    JSONObject songJSON = (JSONObject) songObj;
                    UUID songId = UUID.fromString((String) songJSON.get(SONG_ID));
                    String songTitle = (String) songJSON.get(SONG_TITLE);
                    String songAuthor = (String) songJSON.get(SONG_AUTHOR);

                    songs.add(new Song(songId, songTitle, songAuthor));
                }



                modules.add(new Module(id, title, lessons, songs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modules;
    } 
    public static ArrayList<Course> getCourses() {
        ArrayList<Course> courses = new ArrayList<>();

        try {
            FileReader reader = new FileReader(COURSE_FILE_NAME);
            JSONArray coursesJSON = (JSONArray) new JSONParser().parse(reader);

            for (Object obj : coursesJSON) {
                JSONObject courseJSON = (JSONObject) obj;

                UUID id = UUID.fromString((String) courseJSON.get(COURSE_ID));
                String name = (String) courseJSON.get(COURSE_NAME);

                courses.add(new Course(name, id));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courses;
    }

    public static ArrayList<Lesson> getLessons() {
        ArrayList<Lesson> lessons = new ArrayList<>();

        try {
            FileReader reader = new FileReader(LESSON_FILE_NAME);
            JSONArray lessonsJSON = (JSONArray) new JSONParser().parse(reader);

            for (Object obj : lessonsJSON) {
                JSONObject lessonJSON = (JSONObject) obj;

                UUID id = UUID.fromString((String) lessonJSON.get(LESSON_ID));
                String title = (String) lessonJSON.get(LESSON_TITLE);
                String educationalMaterial = (String) lessonJSON.get(LESSON_EDUCATIONAL_MATERIAL);
                String visualAidPath = (String) lessonJSON.get(LESSON_VISUAL_AID);

                //Todo: fix when lesson image is fixed
                //Image visualAid = null;
                //lessons.add(new Lesson(title, educationalMaterial, visualAid, id));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lessons;
    }

}
