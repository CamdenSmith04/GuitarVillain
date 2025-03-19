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
                SecurityQuestion securityQuestion = (SecurityQuestion)userJSON.get(USER_SECURITY_QUESTION);
                String securityAnswer = (String)userJSON.get(USER_SECURITY_ANSWER);

                int points = (int)userJSON.get(USER_POINTS);
                int streak = (int)userJSON.get(USER_STREAK);

                

                ArrayList<User> friends = new ArrayList<>();

                ArrayList<Song> songs = new ArrayList<>();
                JSONArray songsJSON = (JSONArray) userJSON.get(USER_SONGS);

                for (Object songObj : songsJSON) {
                    JSONObject songJSON = (JSONObject) songObj;
                    UUID songId = UUID.fromString((String) songJSON.get(SONG_ID));
                    String songTitle = (String) songJSON.get(SONG_TITLE);
                    String songAuthor = (String) songJSON.get(SONG_AUTHOR);
                    double songRating = ((Number) songJSON.get(SONG_RATING)).doubleValue();
                    
                    ArrayList<Genre> genres = new ArrayList<>();
                    JSONArray genresArray = (JSONArray) songJSON.get(SONG_GENRES);
                    for (Object genreObj : genresArray) {
                        genres.add(Genre.valueOf((String) genreObj));
                    }
                    
                    Instrument instrument = (Instrument)songJSON.get(SONG_INSTRUMENT);
                    Visibility visibility = (Visibility)songJSON.get(SONG_VISIBILITY);
                    int beatsPerMinute = (int)songJSON.get(SONG_BEATS_PER_MINUTE);
                    TimeSignature timeSignature = (TimeSignature)songJSON.get(SONG_TIME_SIGNATURE);
                    
                    ArrayList<Measure> measures = new ArrayList<>();
                    JSONArray measuresArray = (JSONArray) songJSON.get(SONG_MEASURES);
                    for (Object measureObj : measuresArray) {
                        JSONObject measureJSON = (JSONObject) measureObj;
                        int measureLength = (int)measureJSON.get(MEASURE_LENGTH);

                        ArrayList<Chord> chords = new ArrayList<Chord>();
                        JSONArray chordsArray = (JSONArray) songJSON.get(MEASURE_CHORDS);
                        for(Object chordObj : chordsArray){

                            JSONObject chordJSON = (JSONObject) chordObj;
                            
                            ArrayList<Note> notes = new ArrayList<Note>();
                            JSONArray notesArray = (JSONArray) chordJSON.get(CHORD_NOTES);
                            for(Object noteObj:notesArray){
                                JSONObject noteJSON = (JSONObject) noteObj;

                                int time = (int)noteJSON.get(NOTE_TIME);
                                char string = (char)noteJSON.get(NOTE_STRING);
                                int fret = (int)noteJSON.get(NOTE_FRET);

                                notes.add(new Note(time, string, fret));
                            }

                            /*
                             * ArrayList<Note> notes, String chordShape, String name
                             */
                            String name = (String)chordJSON.get(CHORD_NAME);
                            String chordShape = (String)chordJSON.get(CHORD_SHAPE);

                            chords.add(new Chord(notes, chordShape, name));
                        }
                        measures.add(new Measure(measureLength, chords));
                    }
                    ArrayList<String> lyrics = new ArrayList<>();
                    JSONArray lyricsArray = (JSONArray) songJSON.get(SONG_LYRICS);
                    for (Object lyricObj : lyricsArray) {
                        lyrics.add((String) lyricObj);
                    }
                    
                    double speed = ((Number) songJSON.get(SONG_SPEED)).doubleValue();
                    boolean completed = (boolean) songJSON.get(SONG_COMPLETED);
                    
                    songs.add(new Song(songId, songTitle, songAuthor, songRating, genres, instrument, visibility, 
                                beatsPerMinute, timeSignature, measures, lyrics, speed, completed));
                 }


                users.add(new User(id, username, password, experience,points,streak,securityQuestion,securityAnswer,null,songs));
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
