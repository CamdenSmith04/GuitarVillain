package com.scenarios;
import java.util.UUID;

import com.facade.*;
import com.model.*;

public class DriverScenario5 {
    
    public static void main(String[] args) {
        Facade facade = new Facade();

        // Log-in
        User current_user = facade.logIn("bradleyalford", "dragonman@4929");

        // Get the user's songs and play each one
        for (UUID song : current_user.getSongs()){
            String songTitle = facade.getSongById(song).getTitle();
            System.out.println("Now playing: " + songTitle);
            facade.beginSong(songTitle);
        }

    }

}
