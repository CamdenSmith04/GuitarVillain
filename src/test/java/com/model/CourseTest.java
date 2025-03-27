package com.model;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Camden Smith
 */
public class CourseTest {
    
    private Lesson lesson1 = new Lesson("Lesson1", "String of educational material 1", "path to visual aid");
    private Lesson lesson2 = new Lesson("Lesson2", "education", "image path");
    private Lesson lesson3 = new Lesson("Lesson3", "String of educational material 3", "path to visual aid 3");
    private Lesson lesson4 = new Lesson("Lesson4", "String of educational material 3", "path to visual aid 3");

    private Song song1 = new Song(new User("testuser1", "password1", Experience.BEGINNER, SecurityQuestion.ELEMENTARY_SCHOOL, "school1").getId());
    private Song song2 = new Song(new User("testuser2", "password2", Experience.ADVANCED, SecurityQuestion.ELEMENTARY_SCHOOL, "school2").getId());
    private Song song3 = new Song(new User("testuser3", "password3", Experience.BEGINNER, SecurityQuestion.ELEMENTARY_SCHOOL, "school3").getId());
    private Song song4 = new Song(new User("testuser4", "password4", Experience.BEGINNER, SecurityQuestion.ELEMENTARY_SCHOOL, "school4").getId());

    private User student1 = new User("testuser1", "password1", Experience.BEGINNER, SecurityQuestion.ELEMENTARY_SCHOOL, "school1");
    private User student2 = new User("testuser2", "password2", Experience.ADVANCED, SecurityQuestion.ELEMENTARY_SCHOOL, "school2");
    private User student3 = new User("testuser3", "password3", Experience.INTERMEDIATE, SecurityQuestion.ELEMENTARY_SCHOOL, "school3");
    private User student4 = new User("testuser4", "password4", Experience.INTERMEDIATE, SecurityQuestion.ELEMENTARY_SCHOOL, "school4");

    private User teacher1 = new User("testuser5", "password1", Experience.BEGINNER, SecurityQuestion.ELEMENTARY_SCHOOL, "school1");
    private User teacher2 = new User("testuser6", "password2", Experience.ADVANCED, SecurityQuestion.ELEMENTARY_SCHOOL, "school2");
    private User teacher3 = new User("testuser7", "password3", Experience.INTERMEDIATE, SecurityQuestion.ELEMENTARY_SCHOOL, "school3");
    private User teacher4 = new User("testuser8", "password4", Experience.INTERMEDIATE, SecurityQuestion.ELEMENTARY_SCHOOL, "school4");


    private ArrayList<UUID> teachers1 = new ArrayList<>();
    private ArrayList<UUID> teachers2 = new ArrayList<>();

    private Course course1 = new Course(teachers1, "Course 1");
    private Course course2 = new Course(teachers2, "Course 2");

    @Before
    public void setup(){
        course1.addTeacher(teacher1.getId());
        course1.addTeacher(teacher2.getId());
        course1.addStudent(student1.getId());
        course1.addStudent(student2.getId());
        course1.addLesson(lesson1.getId());
        course1.addLesson(lesson2.getId());
        course1.addSong(song1.getId());
        course1.addSong(song2.getId());

        course2.addTeacher(teacher3.getId());
        course2.addTeacher(teacher4.getId());
        course2.addStudent(student3.getId());
        course2.addStudent(student4.getId());
        course2.addLesson(lesson3.getId());
        course2.addLesson(lesson4.getId());
        course2.addSong(song3.getId());
        course2.addSong(song4.getId());

    }

    @After
    public void teardown(){
        course1 = new Course(teachers1, "Course 1");
        course2 = new Course(teachers2, "Course 2");
    }

    @Test
    public void testAddTeacherNull() {
        boolean success = course1.addTeacher(null);
        assertFalse(success);
    }

    @Test
    public void testAddTeacherExisting() {
        boolean success = course1.addTeacher(teacher1.getId());
        assertFalse(success);
    }

    @Test
    public void testAddTeacherValid() {
        boolean success = course1.addTeacher(teacher3.getId());
        assertTrue(success);
    }

    @Test
    public void testRemoveTeacherNull() {
        boolean success = course1.removeTeacher(null);
        assertFalse(success);
    }

    @Test
    public void testRemoveTeacherExisting() {
        boolean success = course1.removeTeacher(teacher1.getId());
        assertTrue(success);
    }

    @Test
    public void testRemoveTeacherNotFound() {
        boolean success = course1.removeTeacher(teacher3.getId());
        assertFalse(success);
    }
    
    @Test
    public void testAddStudentNull() {
        boolean success = course1.addStudent(null);
        assertFalse(success);
    }

    @Test
    public void testAddStudentExisting() {
        boolean success = course1.addStudent(student1.getId());
        assertFalse(success);
    }

    @Test
    public void testAddStudentValid() {
        boolean success = course1.addStudent(student3.getId());
        assertTrue(success);
    }

    @Test
    public void testRemoveStudentNull() {
        boolean success = course1.removeStudent(null);
        assertFalse(success);
    }

    @Test
    public void testRemoveStudentExisting() {
        boolean success = course1.removeStudent(student1.getId());
        assertTrue(success);
    }

    @Test
    public void testRemoveStudentNotFound() {
        boolean success = course1.removeStudent(student3.getId());
        assertFalse(success);
    }

    @Test
    public void testAddLessonNull() {
        boolean success = course1.addLesson(null);
        assertFalse(success);
    }

    @Test
    public void testAddLessonExisting() {
        boolean success = course1.addLesson(lesson1.getId());
        assertFalse(success);
    }

    @Test
    public void testAddLessonValid() {
        boolean success = course1.addLesson(lesson3.getId());
        assertTrue(success);
    }

    @Test
    public void testRemoveLessonNull() {
        boolean success = course1.removeLesson(null);
        assertFalse(success);
    }

    @Test
    public void testRemoveLessonExisting() {
        boolean success = course1.removeLesson(lesson1.getId());
        assertTrue(success);
    }

    @Test
    public void testRemoveLessonNotFound() {
        boolean success = course1.removeLesson(lesson3.getId());
        assertFalse(success);
    }

    @Test
    public void testAddSongNull() {
        boolean success = course1.addSong(null);
        assertFalse(success);
    }

    @Test
    public void testAddSongExisting() {
        boolean success = course1.addSong(song1.getId());
        assertFalse(success);
    }

    @Test
    public void testAddSongValid() {
        boolean success = course1.addSong(song3.getId());
        assertTrue(success);
    }

    @Test
    public void testRemoveSongNull() {
        boolean success = course1.removeSong(null);
        assertFalse(success);
    }

    @Test
    public void testRemoveSongExisting() {
        boolean success = course1.removeSong(song1.getId());
        assertTrue(success);
    }

    @Test
    public void testRemoveSongNotFound() {
        boolean success = course1.removeSong(song3.getId());
        assertFalse(success);
    }

    @Test
    public void testGetTeacherNull() {
        UUID teacher = course1.getTeacher(null);
        assertEquals(teacher, null);
    }

    @Test
    public void testGetTeacherFound() {
        UUID teacher = course1.getTeacher(teacher1.getId());
        assertEquals(teacher, teacher1.getId());
    }

    @Test
    public void testGetTeacherNotFound() {
        UUID teacher = course1.getTeacher(teacher3.getId());
        assertEquals(teacher, null);
    }

    @Test
    public void testGetStudentNull() {
        UUID student = course1.getStudent(null);
        assertEquals(student, null);
    }

    @Test
    public void testGetStudentFound() {
        UUID student = course1.getStudent(student1.getId());
        assertEquals(student, student1.getId());
    }

    @Test
    public void testGetStudentNotFound() {
        UUID student = course1.getStudent(student3.getId());
        assertEquals(student, null);
    }

    @Test
    public void testGetLessonNull() {
        UUID lesson = course1.getLesson(null);
        assertEquals(lesson, null);
    }

    @Test
    public void testGetLessonFound() {
        UUID lesson = course1.getLesson(lesson1.getId());
        assertEquals(lesson, lesson1.getId());
    }

    @Test
    public void testGetLessonNotFound() {
        UUID lesson = course1.getLesson(lesson3.getId());
        assertEquals(lesson, null);
    }

    @Test
    public void testGetSongNull() {
        UUID song = course1.getSong(null);
        assertEquals(song, null);
    }

    @Test
    public void testGetSongFound() {
        UUID song = course1.getSong(song1.getId());
        assertEquals(song, song1.getId());
    }

    @Test
    public void testGetSongNotFound() {
        UUID song = course1.getSong(song3.getId());
        assertEquals(song, null);
    }

    @Test
    public void testIsMatchNull() {
        boolean success = course1.isMatch(null);
        assertFalse(success);
    }

    @Test
    public void testIsMatchSame() {
        boolean success = course1.isMatch(course1);
        assertTrue(success);
    }

    @Test
    public void testIsMatchDifferent() {
        boolean success = course1.isMatch(course2);
        assertFalse(success);
    }

    @Test
    public void testIdIsMatchNull() {
        boolean success = course1.idIsMatch(null);
        assertFalse(success);
    }

    @Test
    public void testIdIsMatchSame() {
        boolean success = course1.idIsMatch(course1.getId());
        assertTrue(success);
    }

    @Test
    public void testIdIsMatchDifferent() {
        boolean success = course1.idIsMatch(course2.getId());
        assertFalse(success);
    }

    @Test
    public void testToStringNull() {
        ArrayList<Object> empty = new ArrayList<>();
        Course nullCourse = new Course(null, null);
        String result = nullCourse.toString();
        assertEquals(result, "Teachers:" + empty + "\nName: null\nStudents: " + empty + "\nAssigned Lessons: " + empty + "\nAssigned Songs: " + empty + "\nId: " + nullCourse.getId()); 
    }

    @Test
    public void testToStringValid() {
        String result = course1.toString();
        assertEquals(result, "Teachers: " + course1.getTeachers()+ "\nName: " + course1.getName() + "\nStudents: " + course1.getStudents() + "\nAssigned Lessons: " + course1.getAssignedLessons() + "\nAssigned Songs: " + course1.getAssignedSongs() + "\nId: " + course1.getId()); 
    }

}
