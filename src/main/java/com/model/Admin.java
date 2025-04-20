package com.model;

import java.util.ArrayList;
import java.util.Random;

/**
 * User type that has access to all commands
 */
public class Admin extends User {

    public static void main(String[] args) {
        Random rand = new Random();
        ArrayList<Song> songs = DataLoader.getSongs();
        for (Song song : songs) {
            for (Note note : song.getNotes()) {
                String str = String.valueOf(note.getString());
                char set = str.charAt(0);
                if (str.equals("E")) {
                    switch (rand.nextInt(2)) {
                        case 0:
                            set = str.charAt(0);
                            break;
                    
                        default:
                            str = str.toLowerCase();
                            set = str.charAt(0);
                            
                    }

                }
                note.setString(set);
            }
        }
        SongList.getInstance().setSongs(songs);
        DataWriter.save();
    }

    public Admin(User user) {
        super(user.id, user.username, user.password, user.experience, user.points, user.streak, user.securityQuestion, user.securityAnswer, user.friends, user.songs);
        this.role = "Admin";
    }
}
