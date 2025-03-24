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
     * Gives user options to log in or sign up
     */
    public void signIn() {
        userList = UserList.getInstance();
        songList = SongList.getInstance();
        moduleList = ModuleList.getInstance();
        courseList = CourseList.getInstance();
        lessonList = LessonList.getInstance();
    } 

    /**
     * Logs in existing user
     * @param username User's username
     * @param password User's password
     * @return User if found
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
        if (!(currentUser instanceof Teacher) && !(currentUser instanceof Student)) {

            ArrayList<Course> courses = new ArrayList<>();

            for (Course course : courseList.getCourses()) {
                for (UUID match : course.getTeachers()){
                    if (currentUser.idIsMatch(match)){
                        courses.add(course);
                    }
                }
            }

            this.currentUser = new Teacher(currentUser, courses);
        }
    }

    /**
     * Makes user a new student
     */
    public void becomeStudent() {
        if (!(currentUser instanceof Teacher) && !(currentUser instanceof Student)){

            ArrayList<Course> courses = new ArrayList<>();

            for (Course course : courseList.getCourses()) {
                for (UUID match : course.getStudents()){
                    if (currentUser.idIsMatch(match)){
                        courses.add(course);
                    }
                }
            }
            this.currentUser = new Student(currentUser, courses);
        }
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

    // public void playSong(UUID id) {
    //     songList.getSong("Fur Elise");
    // }

    // TODO: Should this be a lesson rather than string name
    public void enterLesson(Lesson lesson) { 

    }

    public void viewCourse(Course course) {
        this.currentCourse = course;
    }

    public void viewFriendProfile(User user) {
        // display public friend user information by UUID?
    }

    public Song composeSong() {
        Song newSong = new Song(currentUser.getId());
        currentUser.addSong(newSong.getId());
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
        for (Course match : this.courseList.getCourses()) {
            if (match.getName().equals(course.getName())) {
                System.out.println("Course with this name already exists.");
                return;
            }
        }
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
        songList.getSongByTitle(title).play();
    }

    public ArrayList<User> getUsers() {
        return userList.getUsers();
    }

    public User getUserById(UUID user) {
        return userList.getUserById(user);
    }

    public ArrayList<Song> getSongs() {
        return songList.getSongs();
    }

    public Song getSongById(UUID song) {
        return songList.getSongById(song);
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
