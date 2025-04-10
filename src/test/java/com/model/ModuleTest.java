package com.model;


import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * @author Camden Smith
 */
public class ModuleTest {
    
    private Lesson lesson1 = new Lesson("Basics", "String of educational material 1", "path to visual aid");
    private Lesson lesson2 = new Lesson("Advanced", "education", "image path");
    private Lesson lesson3 = new Lesson("Moderate", "String of educational material 3", "path to visual aid 3");

    private Song song1 = new Song(new User("testuser1", "password1", Experience.BEGINNER, SecurityQuestion.ELEMENTARY_SCHOOL, "school1").getId());
    private Song song2 = new Song(new User("testuser2", "password2", Experience.ADVANCED, SecurityQuestion.ELEMENTARY_SCHOOL, "school2").getId());
    private Song song3 = new Song(new User("testuser3", "password3", Experience.BEGINNER, SecurityQuestion.ELEMENTARY_SCHOOL, "school3").getId());

    private Module module1 = new Module("Module 1");
    private Module module2 = new Module("Module 2");
    
    @Before
    public void setup(){
        module1.addLesson(lesson1.getId());
        module1.addLesson(lesson2.getId());
        module1.addSong(song1.getId());
        module1.addSong(song2.getId());
    }

    @After
    public void teardown(){
        module1 = new Module("Module 1");
        module2 = new Module("Module 2");
    }

    @Test
    public void testIsMatchNull() {
        boolean success = module1.isMatch(null);
        assertFalse(success);
    }

    @Test
    public void testIsMatchSame() {
        Module sample = module1;
        boolean success = module1.isMatch(sample);
        assertTrue(success);
    }

    @Test
    public void testIsMatchDifferent() {
        boolean success = module1.isMatch(module2);
        assertFalse(success);
    }

    @Test
    public void testIdIsMatchNull() {
        boolean success = module1.idIsMatch(null);
        assertFalse(success);
    }

    @Test
    public void testIdIsMatchSame() {
        Module sample = module1;
        boolean success = module1.idIsMatch(sample.getId());
        assertTrue(success);
    }

    @Test
    public void testIdIsMatchDifferent() {
        boolean success = module1.idIsMatch(module2.getId());
        assertFalse(success);
    }

    @Test
    public void testAddLessonNull() {
        boolean success = module1.addLesson(null);
        assertFalse(success);
    }

    @Test
    public void testAddLessonExistingLesson() {
        boolean success = module1.addLesson(lesson1.getId());
        assertFalse(success);
    }

    @Test
    public void testAddLessonValid() {
        boolean success = module1.addLesson(lesson3.getId());
        assertTrue(success);
    }

    @Test
    public void testDeleteLessonNull() {
        boolean success = module1.removeLesson(null);
        assertFalse(success);
    }

    @Test
    public void testDeleteLessonExistingLesson() {
        boolean success = module1.removeLesson(lesson1.getId());
        assertTrue(success);
    }

    @Test
    public void testDeleteLessonNotFound() {
        boolean success = module1.removeLesson(lesson3.getId());
        assertFalse(success);
    }

    @Test
    public void testAddSongNull() {
        boolean success = module1.addSong(null);
        assertFalse(success);
    }

    @Test
    public void testAddSongExistingLesson() {
        boolean success = module1.addSong(song1.getId());
        assertFalse(success);
    }

    @Test
    public void testAddSongValid() {
        boolean success = module1.addSong(song3.getId());
    }

    @Test
    public void testDeleteSongNull() {
        boolean success = module1.removeSong(null);
        assertFalse(success);
    }

    @Test
    public void testDeleteSongExistingSong() {
        boolean success = module1.removeSong(song1.getId());
        assertTrue(success);
    }

    @Test
    public void testDeleteSongNotFound() {
        boolean success = module1.removeSong(song3.getId());
        assertFalse(success);
    }

}
