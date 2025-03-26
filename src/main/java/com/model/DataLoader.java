package com.model;
import java.util.ArrayList;
import java.util.UUID;
// import java.io.File;
import java.io.FileReader;
// import java.lang.module.ModuleDescriptor;
// import java.util.jar.Attributes;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

// import javafx.scene.image.Image;


public class DataLoader extends DataConstants{
    /**
     * Parses module data extracted from modules.json
     * @param moduleJSON JSONObject read from file
     * @return Initialized Module
     */
    public static Module parseModule(JSONObject moduleJSON){
        UUID id = UUID.fromString((String)moduleJSON.get(MODULE_ID));
        String title = (String)moduleJSON.get(MODULE_TITLE);


        ArrayList<UUID> lessons = new ArrayList<>();
        JSONArray lessonsJSON = (JSONArray) moduleJSON.get(MODULE_LESSONS);
        for (Object obj: lessonsJSON) {
            UUID lessonId = UUID.fromString((String) obj);
            lessons.add(lessonId);
        }

        ArrayList<UUID> songs = new ArrayList<>();
        JSONArray songsJSON = (JSONArray) moduleJSON.get(MODULE_SONGS);
        for (Object obj: songsJSON) {
            UUID songId = UUID.fromString((String) obj);
            songs.add(songId);
        }

        double progress = ((Number) moduleJSON.get(MODULE_PROGRESS)).doubleValue();

        return new Module(id, title, lessons, songs, progress);
    }
    /**
     * Parses course data extracted from courses.json
     * @param courseJSON JSONObject read from file
     * @return Initialized Course
     */
    public static Course parseCourse(JSONObject courseJSON){
        UUID id = UUID.fromString((String) courseJSON.get(COURSE_ID));
        String name = (String)courseJSON.get(COURSE_NAME);

        ArrayList<UUID> teachers = new ArrayList<>();
        JSONArray teachersJSON = (JSONArray) courseJSON.get(COURSE_TEACHERS);
        for (Object obj: teachersJSON) {
            UUID teacherId = UUID.fromString((String) obj);
            teachers.add(teacherId);
        }

        ArrayList<UUID> students = new ArrayList<>();
        JSONArray studentsJSON = (JSONArray) courseJSON.get(COURSE_STUDENTS);
        for (Object obj: studentsJSON) {
            UUID studentId = UUID.fromString((String) obj);
            students.add(studentId);
        }

        ArrayList<UUID> lessons = new ArrayList<>();
        JSONArray assignedLessons = (JSONArray) courseJSON.get(COURSE_ASSIGNED_LESSONS);
        for (Object obj: assignedLessons) {
            UUID lessonId = UUID.fromString((String) obj);
            lessons.add(lessonId);
        }

        ArrayList<UUID> songs = new ArrayList<>();
        JSONArray assignedSongs = (JSONArray) courseJSON.get(COURSE_ASSIGNED_SONGS);
        for (Object obj: assignedSongs) {
            UUID songId = UUID.fromString((String) obj);
            songs.add(songId);
        }

        return new Course(teachers, name, students, lessons, songs, id);

    }

    /**
     * Parses lesson data extracted from lessons.json
     * @param lessonJSON JSONObject read from file
     * @return Initialized lesson
     */
    public static Lesson parseLesson(JSONObject lessonJSON){
        UUID id = UUID.fromString((String) lessonJSON.get(LESSON_ID));
        String title = (String) lessonJSON.get(LESSON_TITLE);
        String educationalMaterial = (String) lessonJSON.get(LESSON_EDUCATIONAL_MATERIAL);
        String visualAidPath = (String) lessonJSON.get(LESSON_VISUAL_AID);
        boolean completed = (boolean) lessonJSON.get(LESSON_COMPLETED);
        return new Lesson(title, educationalMaterial, visualAidPath, id, completed);
    }

    public static Measure parseMeasure(JSONObject measureJSON){
        int measureLength = ((Number) measureJSON.get(MEASURE_LENGTH)).intValue();
        ArrayList<Chord> chords = new ArrayList<Chord>();
        JSONArray chordsArray = (JSONArray) measureJSON.get(MEASURE_CHORDS);
        for(Object chordObj : chordsArray){
            chords.add(parseChord((JSONObject)chordObj));
        }
        return new Measure(measureLength, chords);
    }

    /**
     * Parses song data extracted from songs.json
     * @param songJSON JSONObject read from file
     * @return Initialized song
     */
    public static Song parseSong(JSONObject songJSON){
        UUID songId = UUID.fromString((String) songJSON.get(SONG_ID));
        String songTitle = (String) songJSON.get(SONG_TITLE);
        String songAuthor = (String) songJSON.get(SONG_AUTHOR);
        UUID authorId = null;
        if ( songJSON.get(SONG_AUTHOR_ID) != null ){
            authorId = UUID.fromString((String) songJSON.get(SONG_AUTHOR_ID));
        }
        double songRating = ((Number) songJSON.get(SONG_RATING)).doubleValue();
        ArrayList<Genre> genres = new ArrayList<>();
        JSONArray genresArray = (JSONArray) songJSON.get(SONG_GENRES);

        for (Object genreObj : genresArray) {
            String genre = (String)genreObj;
            genres.add(Genre.valueOf(genre));
        }
        Instrument instrument = Instrument.valueOf((String) songJSON.get(SONG_INSTRUMENT));

        Visibility visibility = Visibility.valueOf((String) songJSON.get(SONG_VISIBILITY));
        int beatsPerMinute = ((Number) songJSON.get(SONG_BEATS_PER_MINUTE)).intValue();
        
        // Constructs timeSignature
        String timeSignatureFull = (String) songJSON.get(SONG_TIME_SIGNATURE);
        ArrayList<String> parts = new ArrayList<String>();
        for (String part: timeSignatureFull.split("/")) {
            parts.add(part);
        }
        TimeSignature timeSignature = new TimeSignature(Integer.parseInt(parts.get(0)), Integer.parseInt(parts.get(1)));

        double speed = ((Number) songJSON.get(SONG_SPEED)).doubleValue();
        boolean completed = (boolean) songJSON.get(SONG_COMPLETED);
        
        ArrayList<String> lyrics = new ArrayList<>();
        JSONArray lyricsArray = (JSONArray) songJSON.get(SONG_LYRICS);
        for (Object lyricObj : lyricsArray) {
            lyrics.add((String) lyricObj);
        }

        ArrayList<Measure> measures = new ArrayList<>();
        JSONArray measuresArray = (JSONArray) songJSON.get(SONG_MEASURES);
        for (Object measureObj : measuresArray) {
            JSONObject measureJSON = (JSONObject) measureObj;   
            measures.add(parseMeasure(measureJSON));
        }
    

        return(new Song(songId, songTitle, songAuthor, authorId, songRating, genres, instrument, visibility, 
                    beatsPerMinute, timeSignature, measures, lyrics, speed, completed));
    }

    /**
     * Parses user data extracted from users.json
     * @param userJSON JSONObject read from file
     * @return Initialized user
     */
    public static User parseUser(JSONObject userJSON){
        UUID id = UUID.fromString((String)userJSON.get(SONG_ID));
        String username = (String)userJSON.get(USER_USERNAME);
        String password = (String)userJSON.get(USER_PASSWORD);
        Experience experience = Experience.valueOf((String)userJSON.get(USER_EXPERIENCE));
        SecurityQuestion securityQuestion = SecurityQuestion.valueOf((String)userJSON.get(USER_SECURITY_QUESTION));
        String securityAnswer = (String)userJSON.get(USER_SECURITY_ANSWER);
        
        int points = ((Number)userJSON.get(USER_POINTS)).intValue();
        int streak = ((Number)userJSON.get(USER_STREAK)).intValue();

        ArrayList<UUID> friends = new ArrayList<>();
        JSONArray friendsJSON = (JSONArray)userJSON.get(USER_FRIENDS);
        for (Object obj: friendsJSON) {
            UUID friendId = UUID.fromString((String) obj);
            friends.add(friendId);
        }

        ArrayList<UUID> songs = new ArrayList<>();
        JSONArray songsJSON = (JSONArray)userJSON.get(USER_SONGS);
        for (Object obj: songsJSON) {
            UUID song = UUID.fromString((String) obj);
            songs.add(song);
        }
        User ret = new User(id, username, password, experience, points, streak, securityQuestion, securityAnswer, friends, songs);
        String role = (String)userJSON.get(USER_ROLE);
        if (role != null){
            switch (role) {
                case "User":{
                    // do nothing
                    break;
                }
                case "Student":{
                    ret = new Student(ret, (ArrayList<UUID>)userJSON.get(USER_COURSES));
                    break;
                }
                case "Teacher":{
                    ret = new Teacher(ret, (ArrayList<UUID>)userJSON.get(USER_COURSES));
                    break;
                }
                case "Admin":{
                    ret = new Admin(ret);
                    break;
                }
                default:
                    break;
            }
        }
        return ret;
    }

    /**
     * Parses chord data extracted from songs.json
     * @param chordJSON JSONObject read from file
     * @return Initialized chord
     */
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

    /**
     * Parses note data extracted from songs.json
     * @param noteJSON JSONObject read from file
     * @return Initialized note
     */
    public static Note parseNote(JSONObject noteJSON){
        int time = ((Number) noteJSON.get(NOTE_TIME)).intValue();
        String noteString = (String) noteJSON.get(NOTE_STRING);
        char string = noteString.charAt(0);
        int fret = ((Number) noteJSON.get(NOTE_FRET)).intValue();
        return new Note(time, string, fret);
    }

    /**
     * Returns an arraylist of initialized songs read from songs.json
     * @return The stored arraylist of songs.
     */
    public static ArrayList<Song> getSongs(){
        ArrayList<Song> songs = new ArrayList<Song>();
        try {
            FileReader reader = new FileReader(SONG_FILE_NAME);
            JSONArray songsJSON = (JSONArray)new JSONParser().parse(reader);
            //System.out.println(parseSong((JSONObject)songsJSON.get(0)));
            for(int i = 0; i<songsJSON.size(); i++){
                songs.add(parseSong((JSONObject)songsJSON.get(i)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.print("Songs: ");
        // System.out.print(songs);
        return songs;
    }

    /**
     * Returns an arraylist of initialized users read from users.json
     * @return The stored arraylist of users.
     */
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

    /**
     * Returns an arraylist of initialized modules read from modules.json
     * @return The stored arraylist of modules.
     */
    public static ArrayList<Module> getModules(){
        ArrayList<Module> modules = new ArrayList<Module>();
        try{
            FileReader reader = new FileReader(MODULE_FILE_NAME);
            JSONArray modulesJSON = (JSONArray)new JSONParser().parse(reader);
            
            for(Object obj : modulesJSON){
                JSONObject moduleJSON = (JSONObject) obj;
                modules.add(parseModule(moduleJSON));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modules;
    } 

    /**
     * Returns an arraylist of initialized courses read from courses.json
     * @return The stored arraylist of courses.
     */
    public static ArrayList<Course> getCourses() {
        ArrayList<Course> courses = new ArrayList<>();
        try {
            FileReader reader = new FileReader(COURSE_FILE_NAME);
            JSONArray coursesJSON = (JSONArray) new JSONParser().parse(reader);

            for (Object obj : coursesJSON) {
                JSONObject courseJSON = (JSONObject) obj;
                courses.add(parseCourse(courseJSON));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courses;
    }

    /**
     * Returns an arraylist of initialized lessons read from lessons.json
     * @return The stored arraylist of lessons.
     */
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
