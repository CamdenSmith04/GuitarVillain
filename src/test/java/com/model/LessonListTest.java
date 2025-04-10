package com.model;
import java.util.ArrayList;
import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * @author Camden Smith
 */
public class LessonListTest {
    
    LessonList lessonList = LessonList.getInstance();
    ArrayList<Lesson> lessons = lessonList.getLessons();
    

    @Before
    public void setup() {
        lessons.clear();
        lessons.add(new Lesson("Lesson 1", "Educational Material 1", "Path 1"));
        lessons.add(new Lesson("Lesson 2", "Educational Material 2", "Path 2"));
        lessons.add(new Lesson("Lesson 3", "Educational Material 3", "Path 3"));
        DataWriter.saveLessons();
    }

    @After
    public void teardown() {
        LessonList.getInstance().getLessons().clear();
        DataWriter.saveLessons();
    }

    @Test
    public void testAddLessonNull() {
        boolean success = lessonList.addLesson(null);
        assertFalse(success);
    }

    @Test
    public void testAddLessonExistingLesson() {
        Lesson lesson = lessonList.getLessonByTitle("Lesson 1");
        boolean success = lessonList.addLesson(lesson);
        assertFalse(success);
    }

    @Test
    public void testAddLessonValid() {
        Lesson lesson = new Lesson("Title", "Material", "Aid");
        boolean success = lessonList.addLesson(lesson);
        assertTrue(success);
    }

    @Test
    public void testGetLessonByTitleNull() {
        Lesson lesson = lessonList.getLessonByTitle(null);
        assertEquals(lesson, null);
    }

    @Test
    public void testGetLessonByTitleNotFound() {
        Lesson lesson = lessonList.getLessonByTitle("Invalid title");
        assertEquals(lesson, null);
    }

    @Test
    public void testGetLessonByTitleValid() {
        Lesson lesson = lessonList.getLessonByTitle("Lesson 1");
        assertEquals(lesson, lessons.get(0));
    }

    @Test
    public void testGetLessonByUUIDNotFound() {
        UUID id = UUID.randomUUID();
        Lesson lesson = lessonList.getLessonById(id);
        assertEquals(lesson, null);

    }

    @Test
    public void testGetLessonByUUIDValid() {
        UUID id = lessons.get(0).getId();
        Lesson lesson = lessonList.getLessonById(id);
        assertEquals(lesson, lessons.get(0));
    }

    @Test
    public void testDeleteLessonNull() {
        boolean success = lessonList.deleteLesson(null);
        assertFalse(success);
    }

    @Test
    public void testDeleteLessonExistingLesson() {
        Lesson lesson = lessonList.getLessonByTitle("Lesson 1");
        boolean success = lessonList.deleteLesson(lesson);
        assertTrue(success);
    }

    @Test
    public void testDeleteLessonNotFound() {
        Lesson lesson = new Lesson("Title", "Material", "Aid");
        boolean success = lessonList.deleteLesson(lesson);
        assertFalse(success);
    }


    

}
