package com.model;
import java.util.ArrayList;

public class LessonList {

    private static LessonList lessonList;
    private ArrayList<Lesson> lessons;

    private LessonList(){
        lessons = DataLoader.getLessons();
    }

    public static LessonList getInstance(){
        if (lessonList == null) {
            lessonList = new LessonList();
        }
        return lessonList;
    }

    // TODO: Make sure lesson can be created :)
    public void addLesson(Lesson lesson){
        lessons.add(lesson);
    }

    public Lesson getLesson(String title){
        for(Lesson current : lessons) {
            if(current.getTitle().equals(title)) {
                return current;
            }
        }
        return null;
    }

    public ArrayList<Lesson> getLessons() {
        return lessons;
    }

    public void updateLesson(Lesson lesson){

    }

    public void deleteLesson(Lesson lesson){
        for(Lesson current : lessons) {
            if(current.isMatch(lesson)) {
                lessons.remove(current);
                return;
            }
        }
    }

    public void save(){

    }

}




