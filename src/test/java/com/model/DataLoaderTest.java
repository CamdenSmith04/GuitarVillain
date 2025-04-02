package com.model;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * @author Andrew Goad
 */

public class DataLoaderTest {

    DataLoader dataLoader1 = new DataLoader();
    Module module1;
    Song song1;

    @Before
    public void setup() {
        try{
            FileReader reader = new FileReader("modules.json");
            JSONArray modulesJSON = (JSONArray)new JSONParser().parse(reader);
            ArrayList<Note> notes = new ArrayList<Note>();
            
            module1 = DataLoader.parseModule((JSONObject)modulesJSON.get(0));
            song1 = DataLoader.parseSong((JSONObject)modulesJSON.get(0));

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @After
    public void teardown() {
        
    }
    //UUID id, String title, String author, UUID authorId, double rating, ArrayList<Genre> genres,
    //Instrument instrument, Visibility visibility, int beatsPerMinute, TimeSignature timeSignature, 
    //ArrayList<Measure> measures, ArrayList<String> lyrics, double speed, 
    //boolean completed

    @Test
    public void testParseSongUUID(){
        assertEquals(song1.getId(), UUID.fromString("c6e8e20f-f010-44b5-91f6-2aec36629f83"));
    }

    @Test
    public void testParseSongTitle(){
        assertEquals(song1.getTitle(), "The Wish");
    }

    @Test
    public void testParseSongAuthor(){
        assertEquals(song1.getAuthor(), "bradleyalford");
    }

    @Test
    public void testParseSongAuthorID(){
        assertEquals(song1.getAuthorId(), UUID.fromString("f151895e-d2ac-42b1-826a-cfff30f9bd64"));
    }

    @Test
    public void testParseSongRating(){
        assertEquals(4.49, song1.getRating(),0);
    }

    @Test 
    public void testParseSongGenres(){
        ArrayList<Genre> genres = new ArrayList<Genre>();
        genres.add(Genre.valueOf("POP"));
        genres.add(Genre.valueOf("ROCK"));
        assertEquals(genres, song1.getGenres());
    }

    @Test
    public void testParseSongInstrument(){
        assertEquals(song1.getInstrument(), Instrument.valueOf("GUITAR"));
    }

    @Test
    public void testParseSongVisibility(){
        assertEquals(song1.getVisibility(), Visibility.valueOf("PUBLIC"));
    }

    @Test
    public void testParseSongBeatsPerMinute(){
        assertEquals(song1.getBeatsPerMinute(), 120);
    }

    @Test
    public void testParseSongTimeSignature(){
        assertEquals(song1.getTimeSignature(), new TimeSignature(4, 4));
    }

    @Test
    public void testParseSongMeasures(){
        Measure givenMeasure = song1.getMeasures().get(0);
        Chord testChord = new Chord(new ArrayList<Note>(Arrays.asList(new Note(8, 'c', 12),new Note(16, 'e', 8),new Note(8, 'g', 10))),"chord1.png","C Major");
        assertTrue(givenMeasure.getChords().get(0) == testChord);
    }

    @Test
    public void testParseSongLyrics(){
        assertEquals(song1.getLyrics().get(0), "I wish I could be a cool boy");
    }

    @Test
    public void testParseSongSpeed(){
        assertEquals(song1.getSpeed(), 1.0, 0);
    }

    @Test public void testParseSongCompleted(){
        assertEquals(song1.getCompleted(), false);
    }

    @Test
    public void testParseModuleUUID(){
        assertEquals(module1.getId(), UUID.fromString("bef5b1da-7a29-44b5-b672-b8ad689a78bf"));
    }

    @Test
    public void testParseModuleTitle(){
        assertEquals(module1.getTitle(), "Basics");
    }

    @Test 
    public void testsParseModuleLessons(){
        ArrayList<UUID> lessons = new ArrayList<>();
        lessons.add(UUID.fromString("e8810e9c-9eed-4ee3-8c14-fc22a5bfc289"));
        assertEquals(module1.getLessons(), lessons);
    }

    @Test
    public void testParseModuleSongs(){
        ArrayList<UUID> songs = new ArrayList<>();
        songs.add(UUID.fromString("3617a6b9-7170-49db-945f-1cf6eb816c3f"));
        assertEquals(module1.getSongs(), songs);
    }

    @Test
    public void testParseModuleProgress(){
        assertEquals(module1.getProgress(), 0.75, 0);
    }

    //@Test public void testParseNote
}