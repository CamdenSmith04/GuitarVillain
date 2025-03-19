package com.model;
import java.util.ArrayList;
import java.util.UUID;

public class Facade {

    private UserList userList;
    private SongList songList;
    private ModuleList moduleList;
    private LessonList lessonList;
    private CourseList courseList;
    
    private User currentUser;
    private Course currentCourse;
    private Lesson currentLesson;
    private Song currentSong;

    // need to figure out how we want to do setters since this is facade

    public Facade() {
        userList = UserList.getInstance();
        songList = SongList.getInstance();
        moduleList = ModuleList.getInstance();
        lessonList = LessonList.getInstance();
        courseList = CourseList.getInstance();
    } 

    /**
     * Gives user options to log in or sign up
     */
    public void signIn() {
        userList = UserList.getInstance();
        songList = SongList.getInstance();
        moduleList = ModuleList.getInstance();
        courseList = CourseList.getInstance();
    } 

    /**
     * Logs in existing user
     */
    public User logIn(String username, String password) {
        return currentUser = userList.getUser(username, password);
    }

    /**
     * Creates new user
     */
    public User signUp(String username, String password, Experience experience, SecurityQuestion securityQuestion, String securityAnswer) {
        return currentUser = userList.signUp(username, password, experience, securityQuestion, securityAnswer);
    }

    /**
     * Resets password if user correctly answers security question
     * @param securityAnswer Answer to security question
     * @param newPassword New password
     * @return True if operation is successful
     */
    public boolean resetPassword(String securityAnswer, String newPassword) {
        return currentUser.resetPassword(securityAnswer, newPassword);
    }

    /**
     * Makes user a new teacher
     */
    public void becomeTeacher() {
        if (!(currentUser instanceof Teacher) && !(currentUser instanceof Student))
            currentUser = new Teacher(currentUser, null);
    }

    /**
     * Makes user a new student
     */
    public void becomeStudent() {
        if (!(currentUser instanceof Teacher) && !(currentUser instanceof Student))
            currentUser = new Student(currentUser, null);
    }

    /**
     * Logs user out
     */
    public void logout() {
        DataWriter.save();
        this.currentUser = null;
    }

    public void browseSongs() {
        songList.browseSongs();
    }

    public void browseLessons() {
        for (Lesson lesson : lessonList.getLessons()) {
            System.out.println(lesson.toString());
        }
    }

    public void browseMyCourses() {
        for (Course course : courseList.getCourses()) {
            System.out.println(course.toString());
        }
    }

    public void browseFriends() {
        /*
        for (User friend : currentUser.getFriends()){
            System.out.println(friend.toString());
        }
            */
    }

    public void playSong(UUID id) {
        songList.getSong("Fur Elise");
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
        //courseList.remove(course);
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
        songList.getSong(title).play();
    }

    public ArrayList<User> getUsers() {
        return userList.getUsers();
    }

    public ArrayList<Song> getSongs() {
        return songList.getSongs();
    }

    public ArrayList<Module> getModules() {
        return moduleList.getModules();
    }

    public ArrayList<Lesson> getLessons() {
        return lessonList.getLessons();
    }

    public ArrayList<Course> getCourses() {
        return courseList.getCourses();
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
