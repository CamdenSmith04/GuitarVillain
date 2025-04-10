package com.model;
import java.util.UUID;

public class DriverScenario5 {
    
    public static void main(String[] args) {
        Facade facade = new Facade();

        // Log-in
        facade.logIn("bradleyalford", "dragonman@4929");

        // Get the user's songs and play each one
        for (UUID song : facade.getCurrentUser().getSongs()){
            String songTitle = facade.getSong(song).getTitle();
            System.out.println("Now playing: " + songTitle);
            facade.beginSong(songTitle);
        }

        // facade.logout();

    }

}
