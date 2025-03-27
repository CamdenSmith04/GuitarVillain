package com.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import com.model.*;

public class UsersTest {
    @Test
    public void testTesting(){
        assertTrue(true);
    }

    @Test
    public void testValidLogin(){
        Library library = Library.getInstance();
        library.login("asmith");
        String firstName = library.getCurrentUser().getFirstName().toLowerCase();

        assertEquals("amy", firstName);
    }

    @Test
    public void testInValidLogin(){
        Library library = Library.getInstance();
        boolean success = library.login("bross");
        assertFalse(success);
    }

    @Test 
    public void testAddValidUser() {
        Library library = Library.getInstance();
        library.createAccount("jmath", "John","Math", 15, "803-222-3333");
        library.logout();
        library = Library.getInstance();
        library.login("jmath");
        String lastName = library.getCurrentUser().getLastName().toLowerCase();
        assertEquals("math", lastName);
    }

    @Test 
    public void testDuplicateValidUser() {
        Library library = Library.getInstance();
        boolean success = library.createAccount("jmath", "Jannet","Math", 15, "803-222-3333");
        assertFalse(success);
    }
}