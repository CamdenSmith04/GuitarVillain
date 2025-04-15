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

    private static Facade instance;

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
        currentUser = null;
        currentSong = null;
        currentModule = null;
        currentLesson = null;
        currentCourse = null;
    }

    public static Facade getInstance() {
        if (instance == null) {
            instance = new Facade(); // Create the instance if it doesn't exist yet
        }
        return instance; // Return the single instance
    }

    /**
     * Logs in existing user. Must be logged out before calling.
     * @param username User's username
     * @param password User's password
     */
    public boolean logIn(String username, String password) {
        currentUser = userList.getUser(username, password);
        if (currentUser != null) userList.updateUser(currentUser);
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
        if (currentUser != null) userList.updateUser(currentUser);
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
    public boolean becomeStudent() {
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
        return (this.currentUser.getClass().equals(Student.class));
    }

    /**
     * This method makes a user a teacher class.
     * @return true or false if was successful
     */
    public boolean becomeTeacher() {
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
        return (this.currentUser.getClass().equals(Teacher.class));
    }

    /**
     * Makes user an instance of Admin
     */
    public boolean becomeAdmin() {
        currentUser = new Admin(currentUser);
        userList.updateUser(currentUser);
        return true;
    }

    /**
     * This method logs the user out and clears all the stored information.
     * @return true or false if logout was successful or not.
     */
    public boolean logout() {
        try {
            DataWriter.save();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    /**
     * This method calls the songList browse song method to allow the user to see all the songs.
     */
    public void browseSongs() {
        songList.browseSongs();
    }

    /**
     * This method prints out all the lessons in the lesson list.
     */
    public void browseLessons() {
        for (Lesson lesson : lessonList.getLessons()) {
            System.out.println(lesson);
        }
    }

    /**
     * This method prints out all the courses in the course lesson.
     */
    public void browseMyCourses() {
        for (Course course : courseList.getCourses()) {
            System.out.println(course);
        }
    }

    /**
     * This method prints out all the friends a user has.
     */
    public void browseFriends() {
        System.out.println("Friends:");
        for (UUID friend : currentUser.getFriends()){
            System.out.println(userList.getUser(friend).getUsername());
        }
    }

    /**
     * This method allows the user to view a specific course.
     * @param course the course the user will be able to view.
     */
    public void viewCourse(Course course) {
        this.currentCourse = course;
    }

    /**
     * This method will enable a user to view one of their friends profiles.
     * @param user the friend who we will be viewing.
     */
    public void viewFriendProfile(User friend) {
        
    }

    /**
     * This method enables the user to create a new song.
     * @return the new song that was created.
     */
    public void composeSong() {
        Song newSong = new Song(currentUser.getId());
        currentUser.addSong(newSong.getId());
        this.songList.addSong(newSong);
        currentSong = newSong;
    }

    /**
     * Creates a new course
     * @param name Name of the course
     */
    public void makeCourse(String name) {
        ArrayList<UUID> teachers = new ArrayList<>();
        teachers.add(currentUser.getId());
        Course newCourse = new Course(teachers, name);
        this.courseList.addCourse(newCourse);
        currentCourse = newCourse;
    }
   
    /**
     * Deletes a course
     * @param name Name of the course
     */
    public void deleteCourse(String name) {
        currentCourse = courseList.getCourseByName(name);
        courseList.deleteCourse(currentCourse);
    }
   
    /**
     * This method adds a student to the student list.
     * @param student the student to be added.
     */
    public void addStudent(UUID student) {
        currentCourse.addStudent(student);
    }
    
    /**
     * This method removes a student from the student list.
     * @param student the student to be removed.
     */
    public void removeStudent(UUID student) {
        currentCourse.removeStudent(student);
    }
    
    /**
     * This method adds a lesson to a course.
     * @param lesson the lesson to be added.
     */
    public void assignLesson(UUID lesson) {
        currentCourse.addLesson(lesson);
    }
    
    /**
     * This method removes a lesson from a course.
     * @param lesson the lesson to be removed.
     */
    public void removeLesson(UUID lesson) {
        this.currentCourse.removeLesson(lesson);
    }
    
    /**
     * This method adds a song to a course.
     * @param song the song to be added.
     */
    public void assignSong(UUID song) {
        this.currentCourse.addSong(song);
    }
    
    /**
     * This method removes a song from a course.
     * @param song the song to be removed.
     */
    public void removeSong(UUID song) {
        this.currentCourse.removeSong(song);
    }
   
    /**
     * This method will allow the user to start a lesson.
     * @param name the lesson that will be started.
     */
    public void beginLesson(String name) {
        
    }

    /**
     * This method allows the user to start a song by title.
     * @param title the title of the song that will be started.
     */
    public void beginSong(String title) {
        setCurrentSong(songList.getSongByTitle(title));
        currentSong.play();
    }

    /**
     * Prints a song to a file
     * @param title Name of the song
     * @param fileName Name of the file
     */
    public void printSongToFile(String title, String fileName){
        songList.getSongByTitle(title).printToFile(fileName);
    }
    
        /**
     * Prints a song to a file
     * @param id UUID of the song
     * @param fileName Name of the file
     */
    public void printSongToFile(UUID id, String fileName){
        songList.getSong(id).printToFile(fileName);
    }

    /**
     * Prints a song to a file
     * @param title Name of the song
     */
    public void printSongToFile(String title){
        Song song = songList.getSongByTitle(title);
        song.printToFile(song.getTitle() + ".txt");
    }
    
    /**
     * Prints a song to a file
     * @param id Id of the song
     */
    public void printSongToFile(UUID id){
        Song song = songList.getSong(id);
        song.printToFile(song.getTitle() + ".txt");
    }
    
    /**
     * This method allows the user to start a song by UUID.
     * @param id the id of the song that will be started.
     */
    public void beginSong(UUID id) {
        setCurrentSong(songList.getSong(id));
        currentSong.play();
    }

    /**
     * This is a getter for the list of users.
     * @return the list of users.
     */
    public ArrayList<User> getUsers() {
        return userList.getUsers();
    }

    /**
     * Gets a user from the userlist by id
     * @param userId Id of user
     * @return User if found
     */
    public User getUser(UUID userId) {
        return userList.getUser(userId);
    }

    /**
     * Gets a user from userlist by username
     * @param username Username of user
     * @return User if found
     */
    public User getUser(String username) {
        return userList.getUser(username);
    }

    /**
     * This is a getter for the list of songs.
     * @return the list of songs.
     */
    public ArrayList<Song> getSongs() {
        return songList.getSongs();
    }

    /**
     * Gets a song from songlist by id
     * @param songId Id of song
     * @return Song if found
     */
    public Song getSong(UUID songId) {
        return songList.getSong(songId);
    }

    /**
     * This is a getter for the list of modules.
     * @return the list of modules.
     */
    public ArrayList<Module> getModules() {
        return moduleList.getModules();
    }

    /**
     * This method gets a specific module from the module list.
     * @param module the module being searched for.
     * @return the module that is found.
     */
    public Module getModuleById(UUID module) {
        return moduleList.getModuleById(module);
    }

    /**
     * This is a getter for the list of lessons.
     * @return the list of lessons.
     */
    public ArrayList<Lesson> getLessons() {
        return lessonList.getLessons();
    }

    /**
     * This method gets a specific lesson from the lesson list.
     * @param lesson the lesson being searched for.
     * @return the lesson that is found.
     */
    public Lesson getLessonById(UUID lesson) {
        return lessonList.getLessonById(lesson);
    }

    /**
     * This is a getter for the list of courses.
     * @return the list of courses.
     */
    public ArrayList<Course> getCourses() {
        return courseList.getCourses();
    }

    /**
     * This method gets a specific course from the course list.
     * @param course the course being searched for.
     * @return the course that is found.
     */
    public Course getCourseById(UUID course) {
        return courseList.getCourseById(course);
    }

    /**
     * This method is a getter for the current user.
     * @return the current user.
     */
    public User getCurrentUser() {
        return this.currentUser;
    }

    /**
     * This method is a getter for the current course.
     * @return the current course.
     */
    public Course getCurrentCourse() {
        return this.currentCourse;
    }

    /**
     * This method is a getter for the current lesson.
     * @return the current lesson.
     */
    public Lesson getCurrentLesson() {
        return this.currentLesson;
    }

    /**
     * This method is a getter for the current song.
     * @return the current song.
     */
    public Song getCurrentSong() {
        return this.currentSong;
    }

    /**
     * This method is a getter for the current module.
     * @return the current module.
     */
    public Module getCurrentModule() {
        return this.currentModule;
    }

    /**
     * This method is a setter for the current song.
     * @param song the song that will be set as the current song.
     */
    public void setCurrentSong(Song song) {
        this.currentSong = song;
    }

    /**
     * This method is a setter for the current course.
     * @param course the course that will be set as the current course.
     */
    public void setCurrentCourse(Course course) {
        this.currentCourse = course;
    }

    /**
     * This method is a setter for the current module.
     * @param module the module that will be set as the current module.
     */
    public void setCurrentModule(Module module) {
        this.currentModule = module;
    }

    /**
     * This method is a setter for the current user.
     * @param user the user that will be set as the current user.
     */
    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    /**
     * This method is a setter for the current lesson.
     * @param lesson the lesson that will be set as the lesson module.
     */
    public void setCurrentLesson(Lesson lesson) {
        this.currentLesson = lesson;
    }

}
