package com.model;

import java.util.UUID;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

/**
 * Tesing DataWriter function.
 * Expected:
 * Add exactly one new object to each list
 * BUGS:
 * if adding an object to the list twice in a row, DataWriter creates an object
 * with only value circularReference = true, which causes loading issues
 * Additionally, objectLists do not check for duplicate items (e.g. User with
 * the same username)
 * 
 * @author Abby Holdcraft
 */
public class DataWriterTest {
    UserList userList = UserList.getInstance();
    CourseList courseList = CourseList.getInstance();
    LessonList lessonList = LessonList.getInstance();
    ModuleList moduleList = ModuleList.getInstance();
    SongList songList = SongList.getInstance();

    User user1 = new User("user1", "newPassword!", Experience.BEGINNER, SecurityQuestion.MOTHER_MAIDEN_NAME, "Georgia");
    User user2 = new User("user2", "AmongUs2020!", Experience.ADVANCED, SecurityQuestion.ELEMENTARY_SCHOOL, "Space");
    Course course1 = new Course(null, "new Course!");
    Lesson lesson1 = new Lesson("lesson 1", "teaching material 1", "visAid.png");
    Song song1 = new Song(UUID.randomUUID(), "new song", "user1", user1.getId(), 3.4, null, Instrument.GUITAR, Visibility.FRIENDS_ONLY, 60, new TimeSignature(4, 4), null, null, 1, false);
    Module module1 = new Module(UUID.randomUUID(), "new module", null, null, 0);

    @Before
    public void setup() {
        // Empty all lists
        userList.getUsers().clear();
        courseList.getCourses().clear();
        lessonList.getLessons().clear();
        moduleList.getModules().clear();
        songList.getSongs().clear();

        course1.addTeacher(user1.getId());
    }

    @After
    public void teardown() {
        
        // Empty all lists
        userList.getUsers().clear();
        courseList.getCourses().clear();
        lessonList.getLessons().clear();
        moduleList.getModules().clear();
        songList.getSongs().clear();
        // Save
        DataWriter.save();
    }

    @Test
    public void saveUserBasic() {
        // Should work
        userList.addUser(user1);
        // Should NOT work
        userList.addUser(user1);
        DataWriter.saveUsers();
        assertEquals(UserList.getInstance().getUser("user1"), user1);
    }

    @Test
    public void saveUserDuplicate() {
        userList.addUser(user1);
        userList.addUser(user1);
        DataWriter.saveUsers();
        assertEquals(UserList.getInstance().getUsers().size(), 1);
    }

    @Test
    public void saveUsersUpdate() {
        userList.addUser(user1);
        user1.setPoints(1234);
        userList.updateUser(user1);
        DataWriter.saveUsers();
        assertEquals(UserList.getInstance(), user1);
    }

    @Test
    public void saveUsersNull() {
        User user = null;
        userList.addUser(user);
        DataWriter.saveUsers();
        assertEquals(UserList.getInstance(), null);
    }

    @Test
    public void saveUsersNullValues() {
        user1.setExperience(null);
        user1.setPassword(null);
        user1.setUsername(null);
        user1.setRole(null);
        user1.setSecurityQuestion(null);
        userList.addUser(user1);
        DataWriter.saveUsers();
        assertEquals(UserList.getInstance().getUser("user1"), user1);
    }

    @Test
    public void saveCoursesBasic() {
        // Should work
        courseList.addCourse(course1);
        DataWriter.saveCourses();
        assertEquals(CourseList.getInstance().getCourseByName("new Course!"), course1);
    }

    @Test
    public void saveCoursesDuplicate() {
        // Should work
        courseList.addCourse(course1);
        // Should NOT work
        courseList.addCourse(course1);
        DataWriter.saveCourses();
        assertEquals(CourseList.getInstance().getCourses().size(), 1);
    }

    @Test
    public void saveCoursesUpdate() {
        course1.addStudent(user2.getId());
        // courseList.updateCourse(course1);
        DataWriter.saveCourses();
        assertEquals(CourseList.getInstance().getCourseByName("new Course!").getStudent(user2.getId()), user2);
    }

    @Test
    public void saveCoursesNull() {
        Course course = null;
        courseList.addCourse(course);
        DataWriter.saveCourses();
        assertEquals(CourseList.getInstance(), null);
    }

    @Test
    public void saveCoursesNullValues() {
        course1.removeTeacher(user1.getId());
        courseList.addCourse(course1);
        DataWriter.saveCourses();
        assertEquals(CourseList.getInstance().getCourseById(course1.getId()), course1);
    }

    @Test
    public void saveLessonsBasic() {
        lessonList.addLesson(lesson1);
        DataWriter.saveLessons();
        assertEquals(LessonList.getInstance().getLessonByTitle("lesson 1"), lesson1);
    }

    @Test
    public void saveLessonsDuplicate() {
        lessonList.addLesson(lesson1);
        lessonList.addLesson(lesson1);
        DataWriter.saveLessons();
        assertEquals(LessonList.getInstance().getLessons().size(), 1);
    }

    @Test
    public void saveLessonsUpdate() {
        lesson1.setCompleted(true);
        // lessonList.updateLesson(lesson1);
        DataWriter.saveLessons();
        assertEquals(LessonList.getInstance().getLessonByTitle("lesson 1"), lesson1);
    }

    @Test
    public void saveLessonsNull() {
        Lesson lesson = null;
        lessonList.addLesson(lesson);
        DataWriter.saveLessons();
        assertEquals(LessonList.getInstance(), null);
    }

    @Test
    public void saveLessonsNullValues() {
        lesson1.setEducationalMaterial(null);
        lesson1.setTitle(null);
        lesson1.setVisualAid(null);
        lessonList.addLesson(lesson1);
        DataWriter.saveLessons();
        assertEquals(LessonList.getInstance().getLessonById(lesson1.getId()), lesson1);
    }

    @Test
    public void saveSongsBasic() {
        songList.addSong(song1);
        DataWriter.saveSongs();
        assertEquals(SongList.getInstance().getSong(song1.getId()), song1);
    }

    @Test
    public void saveSongsDuplicate() {
        songList.addSong(song1);
        songList.addSong(song1);
        DataWriter.saveSongs();
        assertEquals(SongList.getInstance().getSongs().size(), 1);
    }

    @Test
    public void saveSongsUpdate() {
        song1.setCompleted(true);
        // songList.updateSongs(song1);
        DataWriter.saveSongs();
        assertEquals(SongList.getInstance().getSong(song1.getId()), song1);
    }

    @Test
    public void saveSongsNull() {
        Song song = null;
        songList.addSong(song);
        DataWriter.saveSongs();
        assertEquals(SongList.getInstance(), null);
    }

    @Test
    public void saveSongsNullValues() {
        song1.setAuthor(null);
        song1.setTitle(null);
        song1.setGenres(null);
        songList.addSong(song1);
        DataWriter.saveSongs();
        assertEquals(SongList.getInstance().getSong(song1.getId()), song1);
    }

    @Test
    public void saveModulesBasic() {
        moduleList.addModule(module1);
        DataWriter.saveModules();
        assertEquals(ModuleList.getInstance().getModuleById(module1.getId()), module1);
    }

    @Test
    public void saveModulesDuplicate() {
        moduleList.addModule(module1);
        moduleList.addModule(module1);
        DataWriter.saveModules();
        assertEquals(ModuleList.getInstance().getModules().size(), 1);
    }

    @Test
    public void saveModulesUpdate() {
        module1.setProgress(0.5);
        module1.addSong(song1.getId());
        // moduleList.updateModules(module1);
        DataWriter.saveModules();
        assertEquals(ModuleList.getInstance().getModuleById(module1.getId()), module1);
    }

    @Test
    public void saveModulesNull() {
        Module module = null;
        moduleList.addModule(module);
        DataWriter.saveModules();
        assertEquals(ModuleList.getInstance(), null);
    }

    @Test
    public void saveModulesNullValues() {
        module1.setLessons(null);
        module1.setTitle(null);
        module1.setSongs(null);
        moduleList.addModule(module1);
        DataWriter.saveModules();
        assertEquals(ModuleList.getInstance().getModuleById(module1.getId()), module1);
    }

}
