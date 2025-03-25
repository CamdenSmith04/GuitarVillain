package com.model;
import java.util.ArrayList;
import java.util.UUID;

/**
 * This class represents our facade.
 * @authors Camden Smith, Abby Holdcraft, Andrew Goad, Bradley Alford
 */
public class Facade {

    /**
     * This represents the list of users.
     */
    private UserList userList;

    /**
     * This represents the list of songs.
     */
    private SongList songList;

    /**
     * This represents the list of modules.
     */
    private ModuleList moduleList;

    /**
     * This represents the list of lessons.
     */
    private LessonList lessonList;

    /**
     * This represents the list of courses.
     */
    private CourseList courseList;
    
    /**
     * This represents the current user.
     */
    private User currentUser;

    /**
     * This represents the current course.
     */
    private Course currentCourse;

    /**
     * This represents the current lesson.
     */
    private Lesson currentLesson;

    /**
     * This represents the current song.
     */
    private Song currentSong;

    /**
     * This represents the current module.
     */
    private Module currentModule;

    
    /**
     * This method consructs the facade.
     */
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
     * @return true if login successful.
     */
    public boolean logIn(String username, String password) {
        if (currentUser == null)
            currentUser = userList.getUser(username, password);
        return (currentUser != null);
    }

    /**
     * This adds a new user to the user list.
     * @param username the new user's username.
     * @param password the new user's password.
     * @param experience the new user's experience.
     * @param securityQuestion the new user's security question.
     * @param securityAnswer the answer to the new user's security question.
     * @return the user that was signed up.
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
     * This method makes a user a teacher class.
     */
    public boolean becomeTeacher() {
        if (!(currentUser instanceof Teacher) && !(currentUser instanceof Student)) {

            ArrayList<UUID> courses = new ArrayList<>();

            for (Course course : courseList.getCourses()) {
                for (UUID match : course.getTeachers()){
                    if (currentUser.idIsMatch(match)){
                        courses.add(course.getId());
                    }
                }
            }

            this.currentUser = new Teacher(currentUser, courses);
        }
        return (this.currentUser.getClass().equals(Teacher.class));
    }

    /**
     * This method makes a user a student class.
     */
    public boolean becomeStudent() {
        if (!(currentUser instanceof Teacher) && !(currentUser instanceof Student)){

            ArrayList<UUID> courses = new ArrayList<>();

            for (Course course : courseList.getCourses()) {
                for (UUID match : course.getStudents()){
                    if (currentUser.idIsMatch(match)){
                        courses.add(course.getId());
                    }
                }
            }
            this.currentUser = new Student(currentUser, courses);
        }
        return (this.currentUser.getClass().equals(Student.class));
    }

    /**
     * This method logs the user out and clears all the stored information.
     */
    public boolean logout() {
        try {
            DataWriter.save();
            this.currentUser = null;
            this.currentLesson = null;
            this.currentSong = null;
            this.currentModule = null;
            this.currentCourse = null;
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
        for (UUID friend : currentUser.getFriends()){
            System.out.println(userList.getUser(friend));
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
    public Song composeSong() {
        Song newSong = new Song(currentUser.getId());
        currentUser.addSong(newSong.getId());
        return newSong;
    }

    /**
     * This method adds a song to the song list.
     * @param song the song to be added.
     */
    public void addSong(Song song) {
        this.songList.addSong(song);
    }

    /**
     * This method enables the user to create a new course.
     * @param name the name of the new course.
     * @return the new course that was created.
     */
    public Course makeCourse(String name) {
        ArrayList<UUID> teachers = new ArrayList<>();
        teachers.add(currentUser.getId());
        Course newCourse = new Course(teachers, name);
        return newCourse;
    }

    /**
     * This method adds a course to the course list.
     * @param course the course to be added.
     */
    public void addCourse(Course course) {
        for (Course match : this.courseList.getCourses()) {
            if (match.getName().equals(course.getName())) {
                System.out.println("Course with this name already exists.");
                return;
            }
        }
        this.courseList.addCourse(course);
    }
   
    /**
     * This method will remove a course from the course list.
     * @param course the course to be removed.
     */
    public void deleteCourse(Course course) {
        
    }
   
    /**
     * This method adds a student to the student list.
     * @param student the student to be added.
     */
    public void addStudent(UUID student) {
        this.currentCourse.addStudent(student);
    }
    
    /**
     * This method removes a student from the student list.
     * @param student the student to be removed.
     */
    public void removeStudent(UUID student) {
        this.currentCourse.removeStudent(student);

    }
    
    /**
     * This method adds a lesson to a course.
     * @param lesson the lesson to be added.
     */
    public void assignLesson(UUID lesson) {
        this.currentCourse.addLesson(lesson);

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
        songList.getSongByTitle(title).play();
    }
    
    /**
     * This method allows the user to start a song by UUID.
     * @param id the id of the song that will be started.
     */
    public void beginSong(UUID id) {
        songList.getSong(id).play();
    }

    /**
     * This is a getter for the list of users.
     * @return the list of users.
     */
    public ArrayList<User> getUsers() {
        return userList.getUsers();
    }

    /**
     * This method gets a specific user from the user list.
     * @param user the user being searched for.
     * @return the user that is found.
     */
    public User getUserById(UUID user) {
        return userList.getUser(user);
    }

    /**
     * This is a getter for the list of songs.
     * @return the list of songs.
     */
    public ArrayList<Song> getSongs() {
        return songList.getSongs();
    }

    /**
     * This method gets a specific song from the song list.
     * @param song the song being searched for.
     * @return the song that is found.
     */
    public Song getSongById(UUID song) {
        return songList.getSong(song);
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
