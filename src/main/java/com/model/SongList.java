package com.model;

import java.util.ArrayList;
import java.util.UUID;

public class SongList {
    
    private static SongList songList;
    private ArrayList<Song> songs;

    private SongList() {
        songs = DataLoader.getSongs();
    }

    public static SongList getInstance() {
        if (songList == null) {
            songList = new SongList();
        }
        return songList;
    }

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

    public Song getSongById(UUID song) {
        for (Song current: songs) {
            if(current.idIsMatch(song)) {
                return current;
            }
        }
        return null;
    }

    public void browseSongs() {
        for (Song song : songs) {
            System.out.println(song.getLyrics());
        }
    }

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

    public ArrayList<Song> searchTitle(String title) {
        ArrayList<Song> returnArray = new ArrayList<>();
        for(Song song : songs) {
            if(song.getTitle().equals(title)) {
                returnArray.add(song);
            }
        }
        return returnArray;
    }

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

    public ArrayList<Song> searchAuthor(String author) {
        ArrayList<Song> returnArray = new ArrayList<>();
        for(Song song : songs) {
            if(song.getAuthor().equals(author)) {
                returnArray.add(song);
            }
        }
        return returnArray;
    }

    public void updateSong(Song song) {

    }

    public void save() {
        
    }

}
