package com.facade;
import java.util.UUID;

import com.model.Course;

/**
 * Facade for Teacher - can do basic user, student, and teacher.
 * @author Holdcraft
 */
public interface TeacherFacade extends StudentFacade {
    public void browseMyCourses();
    public Course makeCourse(String name);
    public void addCourse(Course course);
    public void deleteCourse(Course course);
    public void addStudent(UUID student);
    public void removeStudent(UUID student);
    public void assignLesson(UUID lesson);
    public void removeLesson(UUID lesson);
    public void assignSong(UUID song);
    public void removeSong(UUID song);
    public void enterStudentMode();
}
