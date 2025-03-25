package com.facade;

import com.model.Course;
import com.model.Lesson;

/**
 * Facade for Student - can do actions of basic user and Student
 * @author Holdcraft
 */
public interface StudentFacade extends UserFacade {
    public void browseMyCourses();
    public void viewCourse(Course course);
    public void enterLesson(Lesson lesson);
    
}