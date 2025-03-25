package com.facade;
import java.util.ArrayList;
import java.util.UUID;

import com.dataManagers.*;
import com.model.*;
import com.model.Module;

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
    private Module currentModule;

    // need to figure out how we want to do setters since this is facade

    public Facade() {
        userList = UserList.getInstance();
        songList = SongList.getInstance();
        moduleList = ModuleList.getInstance();
        lessonList = LessonList.getInstance();
        courseList = CourseList.getInstance();
    } 

    /**
     * Logs in existing user
     * @param username User's username
     * @param password User's password
     * @return User if found
     */
    public User logIn(String username, String password) {
        if (currentUser == null)
            currentUser = userList.getUser(username, password);
        return currentUser;
    }

    /**
     * Creates new user and sets it to currentUser
     */
    public User signUp(String username, String password, Experience experience, SecurityQuestion securityQuestion, String securityAnswer) {
        if (currentUser == null)
            currentUser = userList.signUp(username, password, experience, securityQuestion, securityAnswer);
        return currentUser;
    }

    /**
     * Resets password if user correctly answers security question
     * @param securityAnswer Answer to security question
     * @param newPassword New password
     * @return True if operation is successful
     */
    public void resetPassword(String username, String securityAnswer, String newPassword) {
        User temp = userList.resetPassword(username, securityAnswer, newPassword); 
        if (temp != null)
            currentUser = temp;
    }

    /**
     * Makes user a new teacher
     */
    public void becomeTeacher() {
        if (!(currentUser instanceof Teacher) && !(currentUser instanceof Student)){
            currentUser = new Teacher(currentUser, null);
            
        }
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
            System.out.println(lesson);
        }
    }

    public void browseMyCourses() {
        for (Course course : courseList.getCourses()) {
            System.out.println(course);
        }
    }

    public void browseFriends() {
        for (UUID friend : currentUser.getFriends()){
            System.out.println(userList.getUser(friend));
        }
    }

    // public void playSong(UUID id) {
    //     songList.getSong("Fur Elise");
    // }

    // TODO: Should this be a lesson rather than string name
    public void enterLesson(Lesson lesson) { 

    }

    // TODO: Should this be a course rather than a string name
    public void viewCourse(Course course) {

    }

    public void viewFriendProfile(User user) {
        // display public friend user information by UUID?
    }

    public Song composeSong() {
        Song newSong = new Song(currentUser.getId());
        currentUser.addSong(newSong);
        return newSong;
    }

    public void addSong(Song song) {
        this.songList.addSong(song);
    }

    public Course makeCourse(String name) {
        ArrayList<UUID> teachers = new ArrayList<>();
        teachers.add(currentUser.getId());
        Course newCourse = new Course(teachers, name);
        return newCourse;
    }

    public void addCourse(Course course) {
        this.courseList.addCourse(course);
    }
   
    public void deleteCourse(Course course) {
        //courseList.remove(course);
    }
   
    public void addStudent(UUID student) {
        this.currentCourse.addStudent(student);

    }
    
    public void removeStudent(UUID student) {
        this.currentCourse.removeStudent(student);

    }
    
    public void assignLesson(UUID lesson) {
        this.currentCourse.addLesson(lesson);

    }
    
    public void removeLesson(UUID lesson) {
        this.currentCourse.removeLesson(lesson);
    }
    
    public void assignSong(UUID song) {
        this.currentCourse.addSong(song);
    }
    
    public void removeSong(UUID song) {
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

    public void beginSong(UUID id) {
        songList.getSong(id).play();
    }

    public ArrayList<User> getUsers() {
        return userList.getUsers();
    }

    public User getUserById(UUID user) {
        return userList.getUser(user);
    }

    public ArrayList<Song> getSongs() {
        return songList.getSongs();
    }

    public Song getSongById(UUID song) {
        return songList.getSong(song);
    }

    public ArrayList<Module> getModules() {
        return moduleList.getModules();
    }

    public Module getModuleById(UUID module) {
        return moduleList.getModuleById(module);
    }

    public ArrayList<Lesson> getLessons() {
        return lessonList.getLessons();
    }

    public Lesson getLessonById(UUID lesson) {
        return lessonList.getLessonById(lesson);
    }

    public ArrayList<Course> getCourses() {
        return courseList.getCourses();
    }

    public Course getCourseById(UUID course) {
        return courseList.getCourseById(course);
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

    public Module getCurrentModule() {
        return this.currentModule;
    }

    public void setCurrentSong(Song song) {
        this.currentSong = song;
    }

    @Override
    public void enterStudentMode() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'enterStudentMode'");
    }

}
