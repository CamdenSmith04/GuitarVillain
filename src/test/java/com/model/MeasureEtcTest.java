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
/**
 * This class tests Measure, Chord, and Note classes all at once.
 * @author Abby Holdcraft
 */
public class MeasureEtcTest {
    
    Note note1;
    Note note2;
    Note note3;
    Note note4;
    
    Chord chord1;
    // Chord chord2;
    // Chord chord3;
    // Chord chord4;

    Measure measure1;


    @Before
    public void setup() {
        Note note1 = new Note(1, 'A', 3);
        Note note2 = new Note(2, 'B', 3);
        Note note3 = new Note(3, 'C', 3);
        Note note4 = new Note(4, 'D', 3);
        ArrayList<Note> notes = new ArrayList<>();
        notes.add(note1);
        notes.add(note2);
        notes.add(note3);
        notes.add(note4);
        Chord chord1 = new Chord(notes, null, "A#");
        // Chord chord2 = chord1;
        // Chord chord3 = chord1;
        // Chord chord4 = chord1;
        ArrayList<Chord> chords = new ArrayList<>();
        chords.add(chord1);
        chords.add(chord1);
        chords.add(chord1);
        chords.add(chord1);
        Measure measure1 = new Measure(4, null);
    }

    @After
    public void teardown() {

    }

    @Test
    public void getSongBasic() {
        
    }
}
