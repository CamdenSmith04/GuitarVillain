package com.model;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Scanner;

public class Facade {

    private ArrayList<User> users;
    private ArrayList<Song> songs;
    private ArrayList<Module> modules;
    private ArrayList<Lesson> lessons;
    private ArrayList<Course> courses;
    
    private User currentUser;
    private Course currentCourse;
    private Lesson currentLesson;
    private Song currentSong;

    // need to figure out how we want to do setters since this is facade

    public Facade() {
        users = DataLoader.getUsers();
        songs = DataLoader.getSongs();
        modules = DataLoader.getModules();
        lessons = DataLoader.getLessons();
        courses = DataLoader.getCourses();
    } 

    /**
     * Gives user options to log in or sign up
     */
    public void signIn() {
        System.out.println("Welcome to GuitarVillain!");
        Scanner keyboard = new Scanner(System.in);
        String input;
        for (boolean cont = true; cont;) {
            System.out.println("Would you like to:\n"
                + "(1) Log in\n"
                + "(2) Sign up");
            input = keyboard.nextLine();
            input = input.trim();
            switch (input) {
                case "1": { // Log in
                    currentUser = logIn();
                    if (currentUser==null)
                        System.out.println("Sorry, we could not find a match. Please sign in again.");
                    else
                        cont = false;
                    break;
                }
                case "2": { // Sign up
                    currentUser = signUp();
                    cont = false;
                    break;
                }
                default:
                    System.out.println("Sorry, I didn't understand that. Please enter 1 or 2");
            } 
        }
        keyboard.close();
    }

    /**
     * Logs in existing user
     */
    public User logIn() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What is your login information?");
        System.out.print("Username: ");
        String username = keyboard.nextLine();
        System.out.print("Password: ");
        String password = keyboard.nextLine();
        for (User user : users) {
            if (user.loginIsMatch(username, password)) {
                return user;
            }
        }
        keyboard.close();
        return null;
    }

    /**
     * Creates new user
     */
    public User signUp() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String username = keyboard.nextLine();
        System.out.print("Enter your password: ");
        String password = keyboard.nextLine();
        System.out.println("What is your level of experience in guitar?");
        Experience experience = null;
        for (boolean cont = true; cont;) {
            for (Experience exp : EnumSet.allOf(Experience.class)) {
                System.out.println(exp);
            }
            String experienceStr = keyboard.nextLine();
            experienceStr = experienceStr.trim();
            experienceStr = experienceStr.toUpperCase();
            try {
                experience = Experience.valueOf(experienceStr);
                cont = false;
            } catch (IllegalArgumentException e) {
                System.out.println("Please enter a valid string of one of the following options (e.g. \"EASY\")");
            }
        }
        System.out.println("Would you like to set a Security Question to reset your password later?");
        System.out.println("YES or NO");
        String securityAnswer = keyboard.nextLine();
        SecurityQuestion securityQuestion = null;
        if (securityAnswer.equalsIgnoreCase("YES")) {
            System.out.println("Which question would you like to answer?");
            for (boolean cont = true; cont;) {
                for (SecurityQuestion secQ : EnumSet.allOf(SecurityQuestion.class)) {
                    System.out.println(secQ + ": " + secQ.getLabel());
                }
                securityAnswer = keyboard.nextLine();
                securityAnswer = securityAnswer.trim();
                securityAnswer = securityAnswer.toUpperCase();
                securityAnswer = securityAnswer.replaceAll(" ", "_");
                try {
                    securityQuestion = SecurityQuestion.valueOf(securityAnswer);
                    cont = false;
                } catch (IllegalArgumentException e) {
                    System.out.println("Please enter a valid string of one of the following options (e.g. \"PET_NAME\")");
                }
            }
            for (boolean cont = true; cont;) {
                System.out.println("What is your answer to the question: " + securityQuestion.getLabel());
                securityAnswer = keyboard.nextLine();
                System.out.println("Your answer was:\n" + securityAnswer + "\nIs this right?\nYES or NO");
                String input = keyboard.nextLine();
                if (input.equalsIgnoreCase("YES"))
                    cont = false;
                else
                    System.out.println("All right. Please try again.");
            }
        }
        else {
            securityAnswer = null;
        }

        User retUser = new User(username, password, experience, securityQuestion, securityAnswer);
        this.users.add(retUser);

        System.out.println("User " + username + " successfully created!");

        keyboard.close();
        return retUser;
    }

    public void resetPassword() {

        // Match security question and answer and then use resetPassword method for user

    }

    public void becomeTeacher() {
        // decorator class

    }

    public void becomeStudent() {
        // decorator class
    }

    public void logout() {
        this.currentUser = null;
    }

    public void browseSongs() {
        for (Song song : this.songs) {
            System.out.println(song.toString());
        }
    }

    public void browseLessons() {
        for (Lesson lesson : this.lessons) {
            System.out.println(lesson.toString());
        }
    }

    public void browseMyCourses() {
        for (Course course : this.courses) {
            System.out.println(course.toString());
        }
    }

    public void browseFriends() {

        for (User friend : this.currentUser.getFriends()){
            System.out.println(friend.toString());
        }

    }

    public void playSong() {

    }

    // TODO: Should this be a lesson rather than string name
    public void enterLesson(Lesson lesson) { 

    }

    // TODO: Should this be a course rather than a string name
    public void viewCourse(Course course) {

    }

    public void viewFriendProfile(User user) {
        // display public friend user information by UUID?
    }

    public void composeSong(String title) {
        // this should make a new empty song constructor
        // needs to ask the user for song details and what not
    }

    // TODO: String name or course
    public void makeCourse(String name) {
        // this should make a new empty song constructor
        // needs to ask the user for course details and what not

    }
   
    public void deleteCourse(Course course) {
        this.courses.remove(course);
    }
   
    public void addStudent(Student student) {
        this.currentCourse.addStudent(student);

    }
    
    public void removeStudent(Student student) {
        this.currentCourse.removeStudent(student);

    }
    
    public void assignLesson(Lesson lesson) {
        this.currentCourse.addLesson(lesson);

    }
    
    public void removeLesson(Lesson lesson) {
        this.currentCourse.removeLesson(lesson);
    }
    
    public void assignSong(Song song) {
        this.currentCourse.addSong(song);
    }
    
    public void removeSong(Song song) {
        this.currentCourse.removeSong(song);
    }
    // TODO: String name or course
    public void beginLesson(String name) {
        // go to the start of the module? enter a lesson? not sure
    }
    // TODO: String name or course
    public void beginSong(String title) {
        // This will call play method in song/chord? not sure
    }

    public ArrayList<User> getUsers() {
        return this.users;
    }

    public ArrayList<Song> getSongs() {
        return this.songs;
    }

    public ArrayList<Module> getModules() {
        return this.modules;
    }

    public ArrayList<Lesson> getLessons() {
        return this.lessons;
    }

    public ArrayList<Course> getCourses() {
        return this.courses;
    }

    public User getCurrentUser() {
        return this.currentUser;
    }

    public Course getCurrentCourse() {
        return this.currentCourse;
    }

    public Lesson getCurrentLesson() {
        return this.currentLesson;
    }

    public Song getCurrentSong() {
        return this.currentSong;
    }

}
