package com.model;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Implementation of all facade actions
 * @author Abby Holdcraft
 */
public class Facade implements TeacherInterface {

    protected UserList userList;
    protected SongList songList;
    protected ModuleList moduleList;
    protected LessonList lessonList;
    protected CourseList courseList;
    
    protected User currentUser;
    protected Course currentCourse;
    protected Lesson currentLesson;
    protected Song currentSong;
    protected Module currentModule;

    // need to figure out how we want to do setters since this is facade

    /**
     * Initializes Facade and loads all data from json
     */
    public Facade() {
        userList = UserList.getInstance();
        songList = SongList.getInstance();
        moduleList = ModuleList.getInstance();
        lessonList = LessonList.getInstance();
        courseList = CourseList.getInstance();
    }

    /**
     * Logs in existing user. Must be logged out before calling.
     * @param username User's username
     * @param password User's password
     */
    public boolean logIn(String username, String password) {
        currentUser = userList.getUser(username, password);
        return currentUser != null;
    }

    /**
     * Creates new user and logs in as user. Must be logged out before calling.
     * @param username User's username
     * @param password User's password
     * @param experience User's experience
     * @param securityQuestion User's security question
     * @param securityAnswer User's answer to selected security question
     * @return True if user is logged in
     */
    public boolean signUp(String username, String password, Experience experience, SecurityQuestion securityQuestion, String securityAnswer) {
        currentUser = userList.signUp(username, password, experience, securityQuestion, securityAnswer);
        return currentUser != null;
    }

    /**
     * Resets password if user correctly answers security question, then logs in as that user
     * @param securityAnswer Answer to security question
     * @param newPassword New password
     * @return True if operation is successful
     */
    public boolean resetPassword(String username, String securityAnswer, String newPassword) {
        User temp = userList.resetPassword(username, securityAnswer, newPassword); 
        if (temp != null){
            currentUser = temp;
            userList.updateUser(currentUser);
        }
        return temp != null;
    }

    /**
     * Makes user a new student
     */
    public void becomeStudent() {
        if (!(currentUser instanceof Teacher) 
            && !(currentUser instanceof Student)) {
            ArrayList<UUID> courses = new ArrayList<>();

            for (Course course : courseList.getCourses()) {
                for (UUID match : course.getStudents()){
                    if (currentUser.idIsMatch(match)){
                        courses.add(course.getId());
                    }
                }
            }
            this.currentUser = new Student(currentUser, courses);
            userList.updateUser(currentUser);
        }
    }

    /**
     * Makes user a new teacher
     */
    public void becomeTeacher() {
        if (!(currentUser instanceof Teacher) 
            && !(currentUser instanceof Student)) {

            ArrayList<UUID> courses = new ArrayList<>();

            for (Course course : courseList.getCourses()) {
                for (UUID match : course.getTeachers()){
                    if (currentUser.idIsMatch(match)){
                        courses.add(course.getId());
                    }
                }
            }

            this.currentUser = new Teacher(currentUser, courses);
            userList.updateUser(currentUser);
        }
    }

    public void becomeAdmin() {
        currentUser = new Admin(currentUser);
        userList.updateUser(currentUser);
    }

    /**
     * Logs user out
     */
    public void logout() {
        DataWriter.save();
        this.currentUser = null;
        this.currentLesson = null;
        this.currentSong = null;
        this.currentModule = null;
        this.currentCourse = null;
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

    /**
     * Displays all of currentUser's friends
     */
    public void browseFriends() {
        System.out.println("Friends:");
        for (UUID friend : currentUser.getFriends()){
            System.out.println(userList.getUser(friend).getUsername());
        }
    }

    // TODO: Should this be a lesson rather than string name
    public void enterLesson(Lesson lesson) { 

    }

    public void viewCourse(Course course) {
        this.currentCourse = course;
    }

    public void viewFriendProfile(User user) {
        // display public friend user information by UUID?
    }

    public void composeSong() {
        Song newSong = new Song(currentUser.getId());
        currentUser.addSong(newSong.getId());
        this.songList.addSong(newSong);
        currentSong = newSong;
    }

    public void makeCourse(String name) {
        ArrayList<UUID> teachers = new ArrayList<>();
        teachers.add(currentUser.getId());
        Course newCourse = new Course(teachers, name);
        this.courseList.addCourse(newCourse);
        currentCourse = newCourse;
    }
   
    public void deleteCourse(String name) {
        currentCourse = courseList.getCourseByName(name);
        courseList.deleteCourse(currentCourse);
    }
   
    public void addStudent(UUID student) {
        currentCourse.addStudent(student);

    }
    
    public void removeStudent(UUID student) {
        currentCourse.removeStudent(student);

    }
    
    public void assignLesson(UUID lesson) {
        currentCourse.addLesson(lesson);

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
        setCurrentSong(songList.getSongByTitle(title));
        currentSong.play();
    }

    public void beginSong(UUID id) {
        setCurrentSong(songList.getSong(id));
        currentSong.play();
    }

    public ArrayList<User> getUsers() {
        return userList.getUsers();
    }

    public User getUser(UUID user) {
        return userList.getUser(user);
    }

    public ArrayList<Song> getSongs() {
        return songList.getSongs();
    }

    public Song getSong(UUID song) {
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

    public void setCurrentCourse(Course course) {
        this.currentCourse = course;
    }

}
