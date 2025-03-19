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

    public static Module parseModule(JSONObject moduleJSON){
        UUID id = UUID.fromString((String)moduleJSON.get(SONG_ID));
        String title = (String)moduleJSON.get(SONG_TITLE);
        JSONArray lessonsJSON = (JSONArray) moduleJSON.get(MODULE_LESSONS);
        ArrayList<Lesson> lessons = new ArrayList<>();
        ArrayList<Song> songs = new ArrayList<>();
        JSONArray songsJSON = (JSONArray) moduleJSON.get(MODULE_SONGS);

        for (Object lessonObj : lessonsJSON) {
            lessons.add(parseLesson((JSONObject) lessonObj));
            
        }
        for (Object songObj : songsJSON) {
            songs.add(parseSong((JSONObject) songObj));
        }

        return new Module(id, title, lessons, songsJSON);
    }

    public static Lesson parseLesson(JSONObject lessonJSON){
        UUID id = UUID.fromString((String) lessonJSON.get(LESSON_ID));
        String title = (String) lessonJSON.get(LESSON_TITLE);
        String educationalMaterial = (String) lessonJSON.get(LESSON_EDUCATIONAL_MATERIAL);
        String visualAidPath = (String) lessonJSON.get(LESSON_VISUAL_AID);
        return new Lesson(title, educationalMaterial, visualAidPath, id);
    }

    public static Measure parseMeasure(JSONObject measureJSON){
        int measureLength = (int)measureJSON.get(MEASURE_LENGTH);

        ArrayList<Chord> chords = new ArrayList<Chord>();
        JSONArray chordsArray = (JSONArray) measureJSON.get(MEASURE_CHORDS);

        for(Object chordObj : chordsArray){
            chords.add(parseChord((JSONObject)chordObj));
        }
        return new Measure(measureLength, chords);
    }

    public static Song parseSong(JSONObject songJSON){
        UUID songId = UUID.fromString((String) songJSON.get(SONG_ID));
        String songTitle = (String) songJSON.get(SONG_TITLE);
        String songAuthor = (String) songJSON.get(SONG_AUTHOR);
        double songRating = ((Number) songJSON.get(SONG_RATING)).doubleValue();
        ArrayList<Genre> genres = new ArrayList<>();
        JSONArray genresArray = (JSONArray) songJSON.get(SONG_GENRES);

        for (Object genreObj : genresArray) {
            String genre = (String)genreObj;
            genre = genre.toUpperCase();
            genres.add(Genre.valueOf(genre));
        }

        Instrument instrument = (Instrument)songJSON.get(SONG_INSTRUMENT);
        Visibility visibility = (Visibility)songJSON.get(SONG_VISIBILITY);
        int beatsPerMinute = (int)songJSON.get(SONG_BEATS_PER_MINUTE);
        TimeSignature timeSignature = (TimeSignature)songJSON.get(SONG_TIME_SIGNATURE);
        ArrayList<Measure> measures = new ArrayList<>();
        JSONArray measuresArray = (JSONArray) songJSON.get(SONG_MEASURES);
        for (Object measureObj : measuresArray) {
            JSONObject measureJSON = (JSONObject) measureObj;    
            measures.add(parseMeasure(measureJSON));
        }
        ArrayList<String> lyrics = new ArrayList<>();
        JSONArray lyricsArray = (JSONArray) songJSON.get(SONG_LYRICS);
        for (Object lyricObj : lyricsArray) {
            lyrics.add((String) lyricObj);
        }
        
        double speed = ((Number) songJSON.get(SONG_SPEED)).doubleValue();
        boolean completed = (boolean) songJSON.get(SONG_COMPLETED);
        
        return(new Song(songId, songTitle, songAuthor, songRating, genres, instrument, visibility, 
                    beatsPerMinute, timeSignature, measures, lyrics, speed, completed));
    }

    public static User parseUser(JSONObject userJSON){
        UUID id = UUID.fromString((String)userJSON.get(SONG_ID));
        String username = (String)userJSON.get(USER_USERNAME);
        String password = (String)userJSON.get(USER_PASSWORD);
        Experience experience = Experience.getExperience((String)userJSON.get(USER_EXPERIENCE));
        SecurityQuestion securityQuestion = (SecurityQuestion)userJSON.get(USER_SECURITY_QUESTION);
        String securityAnswer = (String)userJSON.get(USER_SECURITY_ANSWER);

        //TODO fix
        int points = 10;
        int streak = 10;

        ArrayList<Song> songs = new ArrayList<>();
        JSONArray songsJSON = (JSONArray)userJSON.get(USER_SONGS);
        for (Object songObj : songsJSON) {
            songs.add(parseSong((JSONObject) songObj));
        }

        ArrayList<UUID> friends = new ArrayList<>();
        JSONArray friendsJSON = (JSONArray)userJSON.get(USER_FRIENDS);
        for (Object friendObj : friendsJSON) {
            friends.add((UUID)friendObj);
        }


        return new User(id, username, password, experience, points, streak, securityQuestion, securityAnswer, friends, songs);
    }

    public static Chord parseChord(JSONObject chordJSON){
        ArrayList<Note> notes = new ArrayList<Note>();
        JSONArray notesArray = (JSONArray) chordJSON.get(CHORD_NOTES);
        for(Object noteObj:notesArray){
            JSONObject noteJSON = (JSONObject) noteObj;
            notes.add(parseNote(noteJSON));
        }
        String name = (String)chordJSON.get(CHORD_NAME);
        String chordShape = (String)chordJSON.get(CHORD_SHAPE);
        return(new Chord(notes, chordShape, name));
    }

    public static Note parseNote(JSONObject noteJSON){
        int time = (int)noteJSON.get(NOTE_TIME);
        char string = (char)noteJSON.get(NOTE_STRING);
        int fret = (int)noteJSON.get(NOTE_FRET);
        return new Note(time, string, fret);

    }

    public static ArrayList<Song> getSongs(){
        ArrayList<Song> songs = new ArrayList<Song>();
        try {
            FileReader reader = new FileReader(SONG_FILE_NAME);
            JSONArray songsJSON = (JSONArray)new JSONParser().parse(reader);
            for(int i = 0; i<songsJSON.size(); i++){
                songs.add(parseSong((JSONObject)songsJSON.get(i)));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.print("Songs: ");
        System.out.print(songs);
        return songs;
    }

    //all of these nested for loops are bad and I (andrew) need to get rid of them
    public static ArrayList<User> getUsers(){
        ArrayList<User> users = new ArrayList<User>();
        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONArray usersJSON = (JSONArray)new JSONParser().parse(reader);
            for(int i = 0; i<usersJSON.size(); i++){
                JSONObject userJSON = (JSONObject)usersJSON.get(i);
                users.add(parseUser(userJSON));
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
                modules.add(parseModule((JSONObject)modulesJSON.get(i)));
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
                lessons.add(parseLesson(lessonJSON));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lessons;
    }

}
