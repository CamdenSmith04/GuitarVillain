package com.model;

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
