package com.model;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.assertTrue;

import javax.sound.midi.MidiUnavailableException;

/**
 * NOTES:
 * The following classes only contain basic constructors/getters/setters and therefore will not be tested:
 * Annotation
 * Genre
 * Instrument
 * SecurityQuestion
 * TimeSignature
 * Visibility
 * This class will only test metronome
 * @author Abby Holdcraft
 * 
 * NOTE: Metronome will infinitely loop. Most figure out how to set time (for example, while song is playing, or for x amt of seconds)
 */
public class MetronomeTest {

    Metronome metronome;
    Scanner keyboard = new Scanner(System.in);

    @Before
    public void setup() {
        System.out.println("Please enter true or false when prompted");
    }

    @After
    public void teardown() {
        
    }

    @Test
    public void play90BPM() throws MidiUnavailableException, InterruptedException {
        System.out.println("Playing 90 BPM for 10 seconds");
        metronome = new Metronome(90);
        metronome.startMetronome();
        // TimeUnit.SECONDS.sleep(10);
        metronome.stopMetronome();
        System.out.println("Success?");
        boolean success = Boolean.parseBoolean(keyboard.nextLine());
        assertTrue(success);
    }

    @Test
    public void play1BPM() throws MidiUnavailableException, InterruptedException {
        System.out.println("Playing 1 BPM, should play 1 tick.");
        metronome = new Metronome(1);
        metronome.startMetronome();
        // TimeUnit.SECONDS.sleep(10);
        metronome.stopMetronome();
        System.out.println("Success?");
        boolean success;
        try {
            success = Boolean.parseBoolean(keyboard.nextLine());
        } catch (Exception e) {
            success = false;
        }
        assertTrue(success);
    }

    @Test
    public void play0BPM() throws MidiUnavailableException, InterruptedException {
        System.out.println("Playing 0 BPM, should have no sound");
        metronome = new Metronome(0);
        metronome.startMetronome();
        // TimeUnit.SECONDS.sleep(10);
        metronome.stopMetronome();
        System.out.println("Success?");
        boolean success;
        try {
            success = Boolean.parseBoolean(keyboard.nextLine());
        } catch (Exception e) {
            success = false;
        }
        assertTrue(success);
    }

    @Test
    public void play1000BPM() throws MidiUnavailableException, InterruptedException {
        System.out.println("Playing 1000 BPM, should cap at 300");
        metronome = new Metronome(1000);
        metronome.startMetronome();
        // TimeUnit.SECONDS.sleep(10);
        metronome.stopMetronome();
        System.out.println("Success?");
        boolean success;
        try {
            success = Boolean.parseBoolean(keyboard.nextLine());
        } catch (Exception e) {
            success = false;
        }
        assertTrue(success);
    }

    @Test
    public void playNegativeBPM() throws MidiUnavailableException, InterruptedException {
        System.out.println("Playing -60 BPM, should default to 90 BPM");
        metronome = new Metronome(-60);
        metronome.startMetronome();
        // TimeUnit.SECONDS.sleep(10);
        metronome.stopMetronome();
        System.out.println("Success?");
        boolean success;
        try {
            success = Boolean.parseBoolean(keyboard.nextLine());
        } catch (Exception e) {
            success = false;
        }
        assertTrue(success);
    }

    @Test
    public void play1000000BPM() throws MidiUnavailableException, InterruptedException {
        System.out.println("Playing 1000000 BPM, should cap at 300");
        metronome = new Metronome(1000000);
        metronome.startMetronome();
        // TimeUnit.SECONDS.sleep(10);
        metronome.stopMetronome();
        System.out.println("Success?");
        boolean success;
        try {
            success = Boolean.parseBoolean(keyboard.nextLine());
        } catch (Exception e) {
            success = false;
        }
        assertTrue(success);
    }
}
