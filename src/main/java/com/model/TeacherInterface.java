package com.facade;
import java.util.UUID;

import com.model.Course;

/**
 * Facade for Teacher - can do basic user, student, and teacher.
 * @author Holdcraft
 */
public interface TeacherInterface extends StudentInterface {
    public void makeCourse(String name);
    public void deleteCourse(Course course);
}
