package com.model;

import java.util.ArrayList;

public class SongList {
    
    private static SongList songList;

    private ArrayList<Song> songs;

    private SongList() {

    }

    public static SongList getInstance() {
        if (songList == null) {
            songList = new SongList();
        }
        return songList;
    }

    public void createSong(Song song) {

    }

    public Song getSong(String title) {
        //TODO: Fix
        return null;
    }

    public void updateSong(Song song) {

    }

    public void deleteSong(Song song) {

    }

    public ArrayList<Song> searchTitle(String title) {
        //TODO: Fix
        return null;
    }

    public ArrayList<Song> seachGenre(Genre genre) {
        //TODO: Fix
        return null;
    }

    public ArrayList<Song> searchAuthor(String author) {
        //TODO: Fix
        return null;
    }

    public void save() {
        
    }

}
