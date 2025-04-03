package com.model;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

/**
 * This class tests Measure, Chord, and Note classes all at once.
 * @author Abby Holdcraft
 */
public class MeasureEtcTest {
    

    Note note1 = new Note(1, 'e', 3);
    Note note2 = new Note(2, 'a', 3);
    Note note3 = new Note(3, 'g', 3);
    Note note4 = new Note(4, 'd', 3);

    Chord chord1 = new Chord(null, null, "A#");

    Measure measure1;


    @Before
    public void setup() {
        ArrayList<Note> notes = new ArrayList<>();
        notes.add(note1);
        notes.add(note2);
        notes.add(note3);
        notes.add(note4);
        chord1.setNotes(notes);
    }

    @After
    public void teardown() {

    }
    
    @Test
    public void playNoteBasic() {
        note1.play();
        assertTrue(true);
    }

    @Test
    public void playNoteUpdated() {
        note1.setString('d');
        note1.play();
        assertTrue(true);
    }
    
    @Test
    public void playNoteNull() {
        note1 = null;
        note1.play();
        assertTrue(true);
    }

    @Test
    public void playNoteInvalid() {
        note1.setString(' ');
        note1.setFret(-1);
        note1.setTime(-1);
        note1.play();
        assertTrue(true);
    }
    
        
    @Test
    public void playChordBasic() {
        chord1.play();
        assertTrue(true);
    }

    @Test
    public void playChordUpdated() {
        chord1.removeNote(note1);
        chord1.play();
        assertTrue(true);
    }
    
    @Test
    public void playChordNull() {
        chord1 = null;
        chord1.play();
        assertTrue(true);
    }

    @Test
    public void playChordNullValues() {
        chord1.setChordShape(null);
        chord1.setName(null);
        chord1.setNotes(null);
        chord1.play();
        assertTrue(true);
    }

    @Test
    public void playChordInvalid() {
        chord1.setName("Invalid Name");
        ArrayList<Note> notes = new ArrayList<>();
        notes.add(null);
        notes.add(new Note(0, ' ', 0));
        chord1.setNotes(notes);
        chord1.play();
        assertTrue(true);
    }

    @Test
    public void testMeasure() {
        Measure measure1 = new Measure(4, null);
        measure1.addChord(chord1);
        measure1.addChord(chord1);
        measure1.addChord(chord1);
        measure1.addChord(chord1);
        for ( Chord chord : measure1.getChords() )
            chord.play();
    }
}
