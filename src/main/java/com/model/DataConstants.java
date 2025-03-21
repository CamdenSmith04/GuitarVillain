package com.model;
/**
 * This class represents the Data Constants for json files.
 * @author Abby Holdcraft
 */
public class DataConstants {
    
    /**
     * These are the song constants.
     */
    protected static final String SONG_FILE_NAME = "src/main/java/com/data/songs.json";
    protected static final String SONG_AUTHOR = "author";
    protected static final String SONG_TITLE = "title";
    protected static final String SONG_AUTHOR_ID = "authorId";
    protected static final String SONG_RATING = "rating";
    protected static final String SONG_GENRES = "genres";
    protected static final String SONG_INSTRUMENT = "instrument";
    protected static final String SONG_VISIBILITY = "visibility";
    protected static final String SONG_BEATS_PER_MINUTE = "beatsPerMinute";
    protected static final String SONG_TIME_SIGNATURE = "timeSignature";
    protected static final String SONG_MEASURES = "measures";
    protected static final String SONG_LYRICS = "lyrics";
    protected static final String SONG_SPEED = "speed";
    protected static final String SONG_COMPLETED = "completed";
    protected static final String SONG_ID = "id";
    
    /**
     * These are the user constants.
     */
    protected static final String USER_FILE_NAME = "src/main/java/com/data/users.json";
    protected static final String USER_ID = "id";
    protected static final String USER_USERNAME = "username";
    protected static final String USER_PASSWORD = "password";
    protected static final String USER_EXPERIENCE = "experience";
    protected static final String USER_POINTS = "points";
    protected static final String USER_STREAK = "streak";
    protected static final String USER_SECURITY_QUESTION = "securityQuestion";
    protected static final String USER_SECURITY_ANSWER = "securityAnswer";
    protected static final String USER_FRIENDS = "friends";
    protected static final String USER_SONGS = "songs";
    
    /**
     * These are the module constants.
     */
    protected static final String MODULE_FILE_NAME = "src/main/java/com/data/modules.json";
    protected static final String MODULE_ID = "id";
    protected static final String MODULE_TITLE = "title"; 
    protected static final String MODULE_LESSONS = "lessons";
    protected static final String MODULE_SONGS = "songs";
    protected static final String MODULE_PROGRESS = "progress";
    
    /**
     * These are the course constants.
     */
    protected static final String COURSE_FILE_NAME = "src/main/java/com/data/courses.json";
    protected static final String COURSE_ID = "id";
    protected static final String COURSE_NAME = "name";
    protected static final String COURSE_STUDENTS = "students";
    protected static final String COURSE_ASSIGNED_LESSONS = "assignedLessons";
    protected static final String COURSE_ASSIGNED_SONGS = "assignedSongs"; 
    
    /**
     * These are the lesson constants.
     */
    protected static final String LESSON_FILE_NAME = "src/main/java/com/data/lessons.json";
    protected static final String LESSON_ID = "id";
    protected static final String LESSON_TITLE = "title";
    protected static final String LESSON_EDUCATIONAL_MATERIAL = "educationalMaterial";
    protected static final String LESSON_VISUAL_AID = "visualAid";
    protected static final String LESSON_COMPLETED = "completed"; 

    /**
     * These are the measure constants.
     */
    protected static final String MEASURE_LENGTH = "length";
    protected static final String MEASURE_CHORDS = "chords";
    protected static final String MEASURE_CHORD_SHAPE = "chordShape";
    protected static final String MEASURE_NOTES = "notes";

    /**
     * These are the note constants.
     */
    protected static final String NOTE_TIME = "time";
    protected static final String NOTE_STRING = "string";
    protected static final String NOTE_FRET = "fret";

    /**
     * These are the chord constants.
     */
    protected static final String CHORD_NOTES = "notes";
    protected static final String CHORD_SHAPE = "chordShape";
    protected static final String CHORD_NAME = "name";

}
