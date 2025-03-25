package com.facade;

import java.util.UUID;

import com.model.Song;
import com.model.User;

/**
 * Facade for basic user - actions user can do ONLY when logged in.
 * @author Holdcraft
 */
public interface UserInterface extends GuestInterface {
    public void logout();
    public void browseFriends();
    public void viewFriendProfile(User user);
    public void composeSong();
}
