package com.model;
import java.util.ArrayList;
import java.util.UUID;

public class CreateAndPlayDriver {

    public static void main(String[] args) {
        Facade facade = new Facade();

        // Log-in
        User current_user = facade.logIn("camdensmith", "password123");

        // See users friends
        ArrayList<User> users = facade.getUsers();
        for (UUID friend : current_user.getFriends()) {
            for (User user : users) { 
                if (user.idIsMatch(friend)) {
                    System.out.println(user.getUsername());
                }
            }
        }

        System.out.println("-----------------------");

        // Make a new song
        Song newSong = facade.composeSong();
        newSong.setAuthor(current_user.getUsername());
        newSong.setTitle("Cool New Song");
        newSong.setRating(5.00);
        newSong.addGenre(Genre.POP);
        newSong.addGenre(Genre.ROCK);
        newSong.setInstrument(new Instrument(Name.GUITAR));
        newSong.setVisibility(Visibility.PUBLIC);
        newSong.setBeatsPerMinute(120);
        newSong.setTimeSignature(new TimeSignature(4,4));
        newSong.addLyric("This is such a cool song");
        newSong.addLyric("THIS IS AWESOME!!!");
        newSong.setSpeed(1.00);
        newSong.setCompleted(false);
        
        // Add notes

        // 1 Measure - 3 Chords - 9 Notes
        ArrayList<Chord> chords = new ArrayList<>();
        ArrayList<Note> notes = new ArrayList<>();
        notes.add(new Note(1, 'a', 3));
        notes.add(new Note(2, 'b', 3));
        notes.add(new Note(1, 'a', 3));

        chords.add(new Chord(notes, "none", "A major"));

        notes = new ArrayList<>();
        notes.add(new Note(1, 'c', 3));
        notes.add(new Note(2, 'd', 3));
        notes.add(new Note(1, 'c', 3));

        chords.add(new Chord(notes, "none", "C major"));

        notes = new ArrayList<>();
        notes.add(new Note(1, 'a', 3));
        notes.add(new Note(2, 'b', 3));
        notes.add(new Note(1, 'a', 3));

        chords.add(new Chord(notes, "none", "A major"));

        newSong.addMeasure(new Measure(3, chords));

        // 1 Measure - 3 Chords - 9 Notes
        chords = new ArrayList<>();
        notes = new ArrayList<>();
        notes.add(new Note(1, 'e', 2));
        notes.add(new Note(2, 'f', 2));
        notes.add(new Note(1, 'e', 2));

        chords.add(new Chord(notes, "none", "E major"));

        notes = new ArrayList<>();
        notes.add(new Note(1, 'c', 3));
        notes.add(new Note(2, 'd', 3));
        notes.add(new Note(1, 'c', 3));

        chords.add(new Chord(notes, "none", "C major"));

        notes = new ArrayList<>();
        notes.add(new Note(1, 'e', 4));
        notes.add(new Note(2, 'f', 4));
        notes.add(new Note(1, 'e', 4));

        chords.add(new Chord(notes, "none", "E major"));

        newSong.addMeasure(new Measure(3, chords));


        System.out.println(newSong.toString());

        facade.getSongs().add(newSong);

        facade.beginSong("Cool New Song");

        // facade.logout();
        
    }
    
}
