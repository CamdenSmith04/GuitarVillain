package com.model;

import org.junit.Test;
import org.apache.poi.hpsf.Array;
import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.Assert;
import org.junit.runners.Parameterized;

import com.model.*;

/**
 * @author Camden Smith
 */
public class CourseListTest {
    
    CourseList courseList = CourseList.getInstance();
    ArrayList<Course> courses = courseList.getCourses();
    

    @Before
    public void setup() {
        courses.clear();

        User user1 = new User("testuser1", "password1", Experience.BEGINNER, SecurityQuestion.ELEMENTARY_SCHOOL, "school1");
        User user2 = new User("testuser2", "password2", Experience.ADVANCED, SecurityQuestion.ELEMENTARY_SCHOOL, "school2");
        User user3 = new User("testuser3", "password3", Experience.INTERMEDIATE, SecurityQuestion.ELEMENTARY_SCHOOL, "school3");

        ArrayList<UUID> teacher1 = new ArrayList<>();
        ArrayList<UUID> teacher2 = new ArrayList<>();
        ArrayList<UUID> teacher3 = new ArrayList<>();

        teacher1.add(user1.getId());
        teacher2.add(user2.getId());
        teacher3.add(user3.getId());
        
        courses.add(new Course(teacher1, "Course 1"));
        courses.add(new Course(teacher2, "Course 2"));
        courses.add(new Course(teacher3, "Course 3"));
        DataWriter.saveCourses();
    }

    @After
    public void teardown() {
        courseList.getInstance().getCourses().clear();
        DataWriter.saveCourses();
    }

    @Test
    public void testAddCourseNull() {
        boolean success = courseList.addCourse(null);
        assertFalse(success);
    }

    @Test
    public void testAddCourseExistingCourse() {
        Course course = courseList.getCourseByName("Course 1");
        boolean success = courseList.addCourse(course);
        assertFalse(success);
    }

    @Test
    public void testAddCourseValid() {
        User user4 = new User("testuser4", "password4", Experience.INTERMEDIATE, SecurityQuestion.ELEMENTARY_SCHOOL, "school4");
        ArrayList<UUID> teacher4 = new ArrayList<>();
        teacher4.add(user4.getId());
        Course course = new Course(teacher4, "Name");
        boolean success = courseList.addCourse(course);
        assertTrue(success);
    }

    @Test
    public void testGetCourseByNameNull() {
        Course course = courseList.getCourseByName(null);
        assertEquals(course, null);
    }

    @Test
    public void testGetCourseByNameNotFound() {
        Course course = courseList.getCourseByName("Invalid title");
        assertEquals(course, null);
    }

    @Test
    public void testGetCourseByNameValid() {
        Course course = courseList.getCourseByName("Course 1");
        assertEquals(courses.get(0), course);
    }

    @Test
    public void testGetCourseByUUIDNotFound() {
        UUID id = UUID.randomUUID();
        Course course = courseList.getCourseById(id);
        assertEquals(course, null);

    }

    @Test
    public void testGetCourseByUUIDValid() {
        UUID id = courses.get(0).getId();
        Course course = courseList.getCourseById(id);
        assertEquals(course, courses.get(0));
    }

    @Test
    public void testDeleteCourseNull() {
        boolean success = courseList.deleteCourse(null);
        assertFalse(success);
    }

    @Test
    public void testDeleteCourseExistingCourse() {
        Course course = courseList.getCourseByName("Course 1");
        boolean success = courseList.deleteCourse(course);
        assertFalse(success);
    }

    @Test
    public void testDeleteCourseNotFound() {
        User user4 = new User("testuser4", "password4", Experience.INTERMEDIATE, SecurityQuestion.ELEMENTARY_SCHOOL, "school4");
        ArrayList<UUID> teacher4 = new ArrayList<>();
        teacher4.add(user4.getId());
        Course course = new Course(teacher4, "Name");
        boolean success = courseList.deleteCourse(course);
        assertTrue(success);
    }


}
