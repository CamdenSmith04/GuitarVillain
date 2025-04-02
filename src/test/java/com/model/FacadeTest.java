package com.model;
import java.util.ArrayList;
import java.util.UUID;

import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
/**
 * @author Andrew Goad
 */


public class FacadeTest {
    Facade facade1;

    @Before
    public void setup(){
        facade1 = new Facade();
    }

    @Test
    public void LogInTest(){
        facade1.logIn("andrewgoad", "2point9fourpointO");
        assertEquals(facade1.getCurrentUser(), facade1.getUser("andrewgoad"))
    }

    @Test
    public void LogInTestWrong(){
        facade1.logIn("andrewgoad", "not my password");
        assertNull(facade1.getCurrentUser());
    }

    @Test
    public void LogInAlreadyLoggedIn(){
        facade1.logIn("andrewgoad", "2point9fourpointO");
        facade1.logIn("abbyholdcraft","theOneFred!");
        assertEquals(facade1.getCurrentUser(), facade1.getUser("andrewgoad"));
        //attempting login while user already logged in should keep original user logged in
    }

    @Test
    public void SignUpTest(){
        facade1.signUp("baileymccoy", "mclaren", Experience.valueOf("ADVANCED"), SecurityQuestion.valueOf("PET_NAME"), "Olive");
        assertEquals(facade1.getUser("baileymccoy"), facade1.getCurrentUser());
    }

    @Test 
    public void SignUpLoggedin(){
        facade1.logIn("andrewgoad", "2point9fourpointO");
        cade1.signUp("baileymccoy", "mclaren", Experience.valueOf("ADVANCED"), SecurityQuestion.valueOf("PET_NAME"), "Olive");
        assertEquals(facade1.getUser("andrewgoad"), facade1.getCurrentUser());
    }

    @Test
    /*this.currentUser = null;
        this.currentLesson = null;
        this.currentSong = null;
        this.currentModule = null;
        this.currentCourse = null; */
    public void logOutUser(){
        facade1.logIn("andrewgoad", "2point9fourpointO");
        facade1.logout();
        assertNull(facade1.getCurrentUser());
    }

    @Test
    public void logOutLesson(){
        facade1.logIn("andrewgoad", "2point9fourpointO");
        facade1.logout();
        assertNull(facade1.getCurrentLesson());
    }
    @Test
    public void logOutSong(){
        facade1.logIn("andrewgoad", "2point9fourpointO");
        facade1.logout()
        assertNull(facade1.getCurrentSong());
    }
    @Test
    public void logOutModule(){
        facade1.logIn("andrewgoad", "2point9fourpointO");
        facade1.logOut();
        assertNull(facade1.getCurrentModule());
    }
    @Test
    public void logOutCourse(){
        facade1.logIn("andrewgoad", "2point9fourpointO");
        assertNull(facade1.getCurrentCourse());
    }

    @Test
    public void viewCourseTest(){
        facade1.viewCourse(facade1.getCourseById(UUID.fromString("1bbdee53-4b2e-4023-b4c9-ffddbfc71abe")));
        assertEquals(facade1.getCurrentCourse(), facade1.getCourseById(UUID.fromString("1bbdee53-4b2e-4023-b4c9-ffddbfc71abe")));
    }

    @Test
    public void viewCourseNull(){
        facade1.viewCourse(null);
        assertNull(facade1.getCurrentCourse());
    }

    @Test
    public void composeSongTest(){ 
        facade1.logIn("andrewgoad", "2point9fourpointO");
        facade1.composeSong();
        assertTrue(facade1.getCurrentSong().getAuthor() == "andrewgoad");
    }

    @Test
    public void composeSongLoggedOut(){
        facade1.composeSong();
        assertNull(facade1.getCurrentSong().getAuthor());
    }

    @Test
    public void makeCourseTest(){
        facade1.logIn("andrewgoad", "2point9fourpointO");
        facade1.makeCourse("Andrew's School of Music and Chicken Plant");
        assertEquals(facade1.getCurrentCourse().getName(), "Andrew's School of Music and Chicken Plant");
    }

    @Test
    public void makeCourseLoggedOut(){
        facade1.makeCourse("Andrew's School of Music and Chicken Plant");
        assertNull(facade1.getCurrentCourse().getTeachers());
    }

}
