package com.model;

import java.util.ArrayList;

public class SongList {
    
    private static SongList songList;
    private ArrayList<Song> songs;

    private SongList() {
        songs = new ArrayList<Song>();
    }

    public static SongList getInstance() {
        if (songList == null) {
            songList = new SongList();
        }
        return songList;
    }

    // TODO: Make sure song can be created :)
    public void addSong(Song song) {
        songs.add(song);
    }

    public Song getSong(String title) {
        for(Song current : songs) {
            if(current.getTitle().equals(title)) {
                return current;
            }
        }
        return null;
    }

    public void updateSong(Song song) {

    }

    public void deleteSong(Song song) {
        for(Song current : songs) {
            if(current.isMatch(song)) {
                songs.remove(current);
            }
        }
    }

    public ArrayList<Song> searchTitle(String title) {
        ArrayList<Song> returnArray = new ArrayList<Song>();
        for(Song song : songs) {
            if(song.getTitle().equals(title)) {
                returnArray.add(song);
            }
        }
        return returnArray;
    }

    public ArrayList<Song> seachGenre(Genre genre) {
        ArrayList<Song> returnArray = new ArrayList<Song>();
        for(Song song : songs) {
            if(song.getGenre() == genre) {
                returnArray.add(song);
            }
        }
        return returnArray;
    }

    public ArrayList<Song> searchAuthor(String author) {
        ArrayList<Song> returnArray = new ArrayList<Song>();
        for(Song song : songs) {
            if(song.getAuthor().equals(author)) {
                returnArray.add(song);
            }
        }
        return returnArray;
    }

    public void save() {
        
    }

}
