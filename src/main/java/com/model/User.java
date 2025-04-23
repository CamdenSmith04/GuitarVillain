package com.model;
import java.util.ArrayList;
import java.util.UUID;


/**
 * This class represents a User.
 * @author Camden Smith
 */
public class User {
    
    /**
     * This is the username of the user.
     */
    protected String username;

    /**
     * This is the password of the user.
     */
    protected String password;

    /**
     * This is the experience of the user.
     */
    protected Experience experience;

    /**
     * This is the amount of points a user has.
     */
    protected int points;

    /**
     * This is the user's streak.
     */
    protected int streak;

    /**
     * This is the user's security question.
     */
    protected SecurityQuestion securityQuestion;

    /**
     * This is the user's andwer to the security question.
     */
    protected String securityAnswer;

    /**
     * This is the user's friends.
     */
    protected ArrayList<UUID> friends;

    /**
     * This is the user's songs.
     */
    protected ArrayList<UUID> songs;
    
    /**
     * This is the UUID of of the user.
     */
    protected final UUID id;

    /**
     * User's role: User, Teacher, Student
     */
    protected String role;

    /**
     * The list of courses the User is a member of.
     */
    protected ArrayList<UUID> courses;

    /**
     * Name of the image used as User's profile picture.
     */
    protected String profilePicture;

    /**
     * This constructor is used to instantiate an existing user from JSON files.
     * @param id is the user's id.
     * @param username the user's username.
     * @param password the user's password.
     * @param experience the user's experience level.
     * @param points the user's point total.
     * @param streak the user's streak.
     * @param securityQuestion the user's chosen security question.
     * @param securityAnswer the user's answer to the security question.
     * @param friends the user's friends.
     * @param songs the user's songs.
     * @param profilePicture
     */
    public User(UUID id, String username, String password, Experience experience, int points, 
                    int streak, SecurityQuestion securityQuestion, String securityAnswer, 
                    ArrayList<UUID> friends, ArrayList<UUID> songs, String profilePicture) {
        this.username = username;
        this.password = password;
        this.experience = experience;
        this.points = points;
        this.streak = streak;
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;
        this.friends = friends;
        this.songs = songs;
        this.id = id;
        this.role = "User";
        this.profilePicture = profilePicture;
    }

    /**
     * This is a constructor for a new User.
     * @param username the user's desired username.
     * @param password the password the user sets.
     * @param experience the experience level the user sets.
     * @param securityQuestion the security question the user chooses.
     * @param securityAnswer the answer to the chosen security question.
     */
    public User(String username, String password, Experience experience, SecurityQuestion securityQuestion, String securityAnswer) {
        this.id = UUID.randomUUID();
        this.username = username;
        this.password = password;
        this.experience = experience;
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;
        this.points = 0;
        this.streak = 0;
        this.friends = new ArrayList<UUID>();
        this.songs = new ArrayList<UUID>();
        this.role = "User";
    }

    public User(Teacher teacher) {
        this.id = UUID.randomUUID();
        this.username = teacher.username;
        this.password = teacher.password;
        this.experience = teacher.experience;
        this.securityQuestion = teacher.securityQuestion;
        this.securityAnswer = teacher.securityAnswer;
        this.points = teacher.points;
        this.streak = teacher.streak;
        this.friends = teacher.friends;
        this.songs = teacher.songs;
        this.role = "Teacher";
        this.profilePicture = teacher.profilePicture;
    }

    public User(Student student) {
        this.id = UUID.randomUUID();
        this.username = student.username;
        this.password = student.password;
        this.experience = student.experience;
        this.securityQuestion = student.securityQuestion;
        this.securityAnswer = student.securityAnswer;
        this.points = student.points;
        this.streak = student.streak;
        this.friends = student.friends;
        this.songs = student.songs;
        this.role = "student";
        this.profilePicture = student.profilePicture;
    }

    public String getProfilePic() {
        return profilePicture;
    }

    public void setProfilePic(String profilePic) {
        this.profilePicture = profilePic;
    }

    /**
     * This is a getter for the user's username.
     * @return the user's username.
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * This is a getter for the user's password.
     * @return the user's password.
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * This is a getter for the user's id.
     * @return the user's id.
     */
    public UUID getId() {
        return this.id;
    }

    /**
     * This is a getter for the user's experience.
     * @return the user's experience.
     */
    public Experience getExperience() {
        return this.experience;
    }

    /**
     * This is a getter for the user's points.
     * @return the user's points.
     */
    public int getPoints() {
        return this.points;
    }

    /**
     * This is a getter for the user's streak.
     * @return the user's streak.
     */
    public int getStreak() {
        return this.streak;
    }

    /**
     * This is a getter for the user's friends.
     * @return the list of friends the user has.
     */
    public ArrayList<UUID> getFriends() {
        return this.friends;
    }

    /**
     * This is a getter for the user's songs.
     * @return the list of songs the user has.
     */
    public ArrayList<UUID> getSongs() {
        return this.songs;
    }

    /**
     * This is a getter for the user's security answer.
     * @return the user's security answer.
     */
    public String getSecurityAnswer() {
        return this.securityAnswer;
    }

    /**
     * This is a getter for the user's security question.
     * @return the user's security question.
     */
    public SecurityQuestion getSecurityQuestion() {
        return this.securityQuestion;
    }

    /**
     * This is a setter for the user's username.
     * @param username the username which the user will have.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This is a setter for the user's password.
     * @param password the password which the user will have.
     */
    public void setPassword(String password) {
        // TODO: Add password requirements.
        this.password = password;
    }

    /**
     * This is a method to allow the user to reset/change their password.
     * @param securityAnswer the answer to the user's security question.
     * @param newPassword the new password the user will have.
     * @return true if the reset was true.
     */
    public boolean resetPassword(String securityAnswer, String newPassword) {
        if (this.securityAnswer.equalsIgnoreCase(securityAnswer)) {
            this.password = newPassword;
            return true;
        }
            return false;
    }

    /**
     * This is a setter to change the password of a user.
     * @param securityQuestion the user's security question.
     * @param securityAnswer the user's answer to the security question.
     * @param password the user's intended new password.
     */
    public void setPassword(SecurityQuestion securityQuestion, String securityAnswer, String password) {
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;
        this.password = password;
    }

    /**
     * This method is used to see if the user is a match.
     * @param user the user being compared to this user.
     * @return true if the users are a match, otherwise false.
     */
    public boolean isMatch(User user) {
        return this.id.equals(user.getId());
    }

    public boolean isMatch(String username) {
        return this.username.equals(username);
    }

    /**
     * This method is used to see if the UUID of this user is a match.
     * @param user the UUID of a user being compared to this user.
     * @return true if the users have the same UUID, otherwise false.
     */
    public boolean idIsMatch(UUID id){
        return this.id.equals(id);
    }

    /**
     * This is a setter for the user's experience level.
     * @param experience the experience the user will have.
     */
    public void setExperience(Experience experience) {
        this.experience = experience;
    }

    /**
     * This is a setter for the user's points.
     * @param points the points the user will have.
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * This is a setter for the user's streak.
     * @param streak the streak the user will have.
     */
    public void setStreak(int streak) {
        this.streak = streak;
    }

    /**
     * This is a setter for the user's friends.
     * @param friends the friends the user will have.
     */
    public void setFriends(ArrayList<UUID> friends) {
        this.friends = friends;
    }

    /**
     * This is a setter for the user's songs.
     * @param songs the songs the user will have.
     */
    public void setSongs(ArrayList<UUID> songs) {
        this.songs = songs;
    }

    /**
     * This method is used to add a song to the user's songs.
     * @param song the UUID of a song to be added to the user.
     */
    public void addSong(UUID song){
        this.songs.add(song);
    }

    /**
     * This method is used to remove a song from a user.
     * @param song the UUID of a song to be removed from a user.
     */
    public void removeSong(UUID song) {
        this.songs.remove(song);
    }

    /**
     * This is a setter for the user's security question.
     * @param securityQuestion the security question the user will have.
     */
    public void setSecurityQuestion(SecurityQuestion securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    /**
     * This is a setter for the user's security answer.
     * @param securityAnswer the security answer the user will have.
     */
    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }

    /**
     * Gets role of user
     * @return User's role
     */
    public String getRole() {
        return this.role;
    }

    /**
     * Sets the role to a string
     * @param role String of role
     */
    public void setRole(String role) {
        switch (role) {
            case "User":{
                this.role = role;
                break;
            }
            case "Student":{
                this.role = role;
                break;
            }
            case "Teacher":{
                this.role = role;
                break;
            }
            case "Admin":{
                this.role = role;
                break;
            }
            default:
                break;
        }
    }
    
    /**
     * This method converts the users data fields into strings.
     * @return the string of all the data fields.
     */
    @Override
    public String toString() {
        return ("Id: " + this.id + "\n" + 
                "Username: " + this.username + "\n" +
                "Password: " + this.password + "\n" + 
                "Security Question: " + this.securityQuestion + "\n" + 
                "Security Answer: " + this.securityAnswer + "\n" + 
                "Experience: " + this.experience + "\n" + 
                "Points: " + this.points +  "\n" +
                "Streak: " + this.streak + "\n" + 
                "Friends: " + this.friends + "\n" +
                "Songs: " + this.songs);
    }
    
}
