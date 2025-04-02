package com.model;

import java.util.concurrent.TimeUnit;

import javax.sound.midi.MidiUnavailableException;

import org.jfugue.pattern.Pattern;
import org.jfugue.realtime.RealtimePlayer;

/**
 * This class represents a metronome.
 * @author Bradley Alford
 */
public class Metronome {
    /**
     * The tempo of a metronome.
     */
    private int beatsPerMinute;

    /**
     * This is a constructor for a metronome.
     * @param beatsPerMinute The tempo for the metronome.
     */
    public Metronome(int beatsPerMinute) {
        if (beatsPerMinute < 0)
            this.beatsPerMinute = 90;
        else if (beatsPerMinute > 300)
            this.beatsPerMinute = 300;
        else
            this.beatsPerMinute = beatsPerMinute;
    }

    boolean quit = false;

    /**
     * Starts the metronome and plays until stopped.
     * @throws MidiUnavailableException An exception for if the MIDI can not be found.
     * @throws InterruptedException 
     */
    public void startMetronome() throws MidiUnavailableException, InterruptedException {
        RealtimePlayer player = new RealtimePlayer();
        Pattern pattern = new Pattern("C").setTempo(this.beatsPerMinute);
        quit = false;
        while(!quit) {
            player.play(pattern);
        }
        player.close();
    }

    /**
     * Stops the currently playing metronome.
     */
    public void stopMetronome() {
        quit = true;
    }
}
