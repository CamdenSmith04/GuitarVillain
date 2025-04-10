package com.model;
import java.util.ArrayList;
import java.util.UUID;

/**
 * This class keeps track of all the lessons in the program and represents the list of lessons.
 * @author Camden Smith
 */
public class LessonList {

    /**
     * This is the singleton of the lessonList object.
     */
    private static LessonList lessonList;

    /**
     * This is the list of lessons in the lessonList.
     */
    private ArrayList<Lesson> lessons;

    /**
     * This constructs the LessonList object from the JSON files.
     */
    private LessonList(){
        lessons = DataLoader.getLessons();
    }

    /**
     * This uses a static method to create the single version of the lessonList.
     * @return the CourseList courseList that is the singleton.
     */
    public static LessonList getInstance(){
        if (lessonList == null) {
            lessonList = new LessonList();
        }
        return lessonList;
    }

    /**
     * This method adds a lesson object to the list of lessons.
     * @param lesson a lesson to be added to the list of lessons.
     */
    public boolean addLesson(Lesson lesson){
        if (lesson == null) {
            return false;
        }
        for (Lesson match : lessons) {
            if (match.equals(lesson)){
                return false;
            }
        }
        this.lessons.add(lesson);
        return true;
    }

    /**
     * This method gets a Lesson from the list of lessons by title.
     * @param title the title of the lesson being searched for.
     * @return the Lesson if it is found in the list of lessons.
     */
    public Lesson getLessonByTitle(String title){
        for(Lesson current : lessons) {
            if(current.getTitle().equals(title)) {
                return current;
            }
        }
        return null;
    }

    /**
     * This method gets a lesson from the list of lessons by Id.
     * @param lesson the id of the lesson being searched for.
     * @return the Lesson if it is found in the list of lessons.
     */
    public Lesson getLessonById(UUID lesson) {
        for (Lesson current: lessons) {
            if (current.idIsMatch(lesson)) {
                return current;
            }
        }
        return null;
    }

    /**
     * This is a getter method to get the list of lessons in the lessonList.
     * @return the list of lessons.
     */
    public ArrayList<Lesson> getLessons() {
        return lessons;
    }

    /**
     * THis method deletes/removes a lesson from the lesson list if it is found.
     * @param lesson the lesson object to be deleted/removed.
     */
    public boolean deleteLesson(Lesson lesson){
        if (lesson == null) {
            return false;
        }
        for (Lesson match : lessons) {
            if (match.equals(lesson)) {
                this.lessons.remove(lesson);
                return true;
            }
        }
        return false;
    }

}




