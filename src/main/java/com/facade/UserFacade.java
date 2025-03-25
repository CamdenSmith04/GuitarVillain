package com.facade;

import java.util.UUID;

import com.model.Song;
import com.model.User;

/**
 * Facade for basic user - actions user can do ONLY when logged in.
 * @author Holdcraft
 */
public interface UserFacade {
    // TODO decide which methods to include (should non-logged in user access getSongs? does facade need getsongs?)
    public void becomeTeacher();
    public void becomeStudent();
    public void logout();
    public void browseSongs();
    public void browseLessons();
    public void viewFriendProfile(User user);
    public Song composeSong();
    public void addSong(Song song);
    public void beginSong(String title);
    public void beginSong(UUID id);
}
