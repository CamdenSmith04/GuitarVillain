package com.model;

import java.util.ArrayList;
import java.util.UUID;

import java.lang.reflect.Field;

public class HoldcraftDriver {
    public static void main(String[] args) {
        // Test DataLoader and DataWriter for users
        // Facade facade = new Facade();
        // facade.logIn("abbyholdcraft", "thegrasstoucher");
        // System.out.println("\n\nCurrent User: " + facade.getCurrentUser());
        // User user = facade.getCurrentUser();
        // ArrayList<UUID> friends = user.getFriends();
        // System.out.println(friends == null);
        // for (UUID friend : friends)
        //     System.out.println(friend);
        // facade.logout();

        // Facade facade = new Facade();
        // ArrayList<Song> songs = facade.getSongs();
        // for (Song song : songs) {
        //     System.out.println("\n" + song);
        // }

        // facade.logout();

        // SongList songList = SongList.getInstance();
        
        // DataWriter.saveSongs();

        Facade facade = new Facade();
        
        facade.beginSong("Fur Elise");
        DataWriter.save();



    }
}
