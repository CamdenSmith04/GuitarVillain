package com.model;

import java.util.ArrayList;
import java.util.UUID;

/**
 * This class keeps track of all the songs in the program and represents the list of songs.
 * @author Bradley Alford
 */
public class SongList {
    
    /**
     * This is the singleton of the songList object.
     */
    private static SongList songList;

    /**
     * This is the list of songs in the songList.
     */
    private ArrayList<Song> songs;

    /**
     * This constructs the SongList object from the JSON files.
     */
    private SongList() {
        songs = DataLoader.getSongs();
    }

    /**
     * This uses a static method to create the single version of the songList.
     * @return the SongList songList that is the singleton.
     */
    public static SongList getInstance() {
        if (songList == null) {
            songList = new SongList();
        }
        return songList;
    }

    /**
     * This method adds a Song object to the list of songs.
     * @param song a song to be added to the list of songs.
     */
    public void addSong(Song song) {
        songs.add(song);
    }

    /**
     * This method gets a Song from the list of songs by title.
     * @param name the name of the song being searched for.
     * @return the Song if it is found in the list of songs.
     */
    public Song getSongByTitle(String title) {
        for(Song current : songs) {
            if(current.getTitle().equals(title)) {
                return current;
            }
        }
        return null;
    }

    /**
     * This method gets a Song from the list of songs by Id.
     * @param song the UUID of the song being searched for.
     * @return the song if it is found in the list of songs.
     */
    public Song getSong(UUID id) {
        for (Song current: songs) {
            if(current.idIsMatch(song)) {
                return current;
            }
        }
        return null;
    }

    /**
     * This method prints out the lyrics of all the songs.
     */
    public void browseSongs() {
        for (Song song : songs) {
            System.out.println(song.getLyrics());
        }
    }

    /**
     * This is a getter method to get the list of songs in the songList object.
     * @return the list of songs.
     */
    public ArrayList<Song> getSongs() {
        return songs;
    }

    /**
     * This method deletes/removes a song from the song list if it is found.
     * @param song the song object to be deleted/removed.
     */
    public void deleteSong(Song song) {
        for(Song current : this.songs) {
            if(current.isMatch(song)) {
                songs.remove(current);
                return;
            }
        }
    }

    /**
     * This method gets all the songs with the same title.
     * @param title the desired title being searched for.
     * @return an array list of all the songs with a matching title.
     */
    public ArrayList<Song> searchTitle(String title) {
        ArrayList<Song> returnArray = new ArrayList<>();
        for(Song song : songs) {
            if(song.getTitle().equals(title)) {
                returnArray.add(song);
            }
        }
        return returnArray;
    }

    /**
     * This method gets all the songs with the same genre.
     * @param genre the desired genre being searched for.
     * @return an array list of all the songs with a matching genre.
     */
    public ArrayList<Song> seachGenre(Genre genre) {
        ArrayList<Song> returnArray = new ArrayList<>();
        for(Song song : songs) {
            for(Genre current : song.getGenres()) {
                if(current == genre) {
                    returnArray.add(song);
                }
            }
        }
        return returnArray;
    }

    /**
     * This method gets all the songs with the same author.
     * @param author the desired author being searched for.
     * @return an array list of all the songs with a matching author.
     */
    public ArrayList<Song> searchAuthor(String author) {
        ArrayList<Song> returnArray = new ArrayList<>();
        for(Song song : songs) {
            if(song.getAuthor().equals(author)) {
                returnArray.add(song);
            }
        }
        return returnArray;
    }

}
