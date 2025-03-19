package com.model;
import java.util.ArrayList;


public class FurElise {
    public static void main(String[] args) {
        
        /* 
        Facade facade = new Facade();
        facade.logIn("abbyholdcraft", "thegrasstoucher");
        facade.beginSong("Fur Elise");
        */
        
        SongList songList = SongList.getInstance();
        songList.printSongs();
        Song elise = songList.getSong("Fur Elise");
        elise.play();
        
    }
}
