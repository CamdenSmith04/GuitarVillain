package com.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class LessonTest {

    private Lesson sample = new Lesson("Basics", "String of educational material 1", "path to visual aid");
    private Lesson comparison = new Lesson("Advanced", "education", "image path");
    
    @Test
    public void testIsMatchNull() {
        boolean success = sample.isMatch(null);
        assertFalse(success);
    }

    @Test
    public void testIsMatchSame() {
        boolean success = sample.isMatch(sample);
        assertTrue(success);
    }

    @Test
    public void testIsMatchDifferent() {
        boolean success = sample.isMatch(comparison);
        assertFalse(success);
    }

    @Test
    public void testIdIsMatchNull() {
        boolean success = sample.idIsMatch(null);
        assertFalse(success);
    }

    @Test
    public void testIdIsMatchSame() {
        boolean success = sample.idIsMatch(sample.getId());
        assertTrue(success);
    }

    @Test
    public void testIdIsMatchDifferent() {
        boolean success = sample.idIsMatch(comparison.getId());
        assertFalse(success);
    }

    @Test
    public void toStringNull() {
        Lesson nullLesson = new Lesson(null, null, null);
        String result = nullLesson.toString();
        assertEquals(result, "Title: null\nId: " + nullLesson.getId() + "\nEducational Material: null\nVisual Aid: null\nCompleted: false"); 
    }

    @Test
    public void testToStringValid() {
        String result = sample.toString();
        assertEquals(result, "Title: Basics\nId: " + sample.getId() + "\nEducational Material: String of educational material 1\nVisual Aid: path to visual aid\nCompleted: false"); 
    }

}
