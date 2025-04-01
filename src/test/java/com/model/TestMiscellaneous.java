package com.model;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Works as intended!
 * @author Abby Holdcraft
 */
public class TestMiscellaneous {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        /*
         * ANNOTATION
         * Works as intended!
         */
        System.out.println("ANNOTATION TEST");
        System.out.println("EXPECTED OUTPUT: This song sucks");
        SongList songList = SongList.getInstance();
        Song theDistance = songList.getSongByTitle("The Distance");
        Annotation tdAnnotation = new Annotation(theDistance.getId(), "This song sucks");
        System.out.println("ACTUAL OUTPUT: " + tdAnnotation.getText());
        System.out.println("\nHIT ENTER FOR NEXT TEXT");
        keyboard.nextLine();

        /*
         * NOTE
         * Works as intended!
         */
        System.out.println("NOTE TEST");
        System.out.println("EXPECTED OUTPUT: Plays a note");
        Note note = new Note(0, 'A', 3);
        note.play();
        System.out.println("\nHIT ENTER FOR NEXT TEXT");
        keyboard.nextLine();

        /*
         * CHORD
         * Works as intended!
         */
        System.out.println("CHORD TEST");
        System.out.println("EXPECTED OUTPUT: Plays the note A");
        ArrayList<Note> notes = new ArrayList<>();
        notes.add(note);
        notes.add(new Note(0, 'B', 3));
        notes.add(new Note(0, 'C', 3));
        Chord chord = new Chord(notes, null, "A");
        chord.play();

        /*
         * TIME SIGNATURE
         * Works as intended!
         */
        System.out.println("\nTIME SIGNATURE TEST");
        System.out.println("EXPECTED OUTPUT: 4/4");
        TimeSignature timeSignature = new TimeSignature(4, 4);
        theDistance.setTimeSignature(timeSignature);
        System.out.println("ACTUAL OUTPUT: " + theDistance.getTimeSignature());

        keyboard.close();
    }
}
