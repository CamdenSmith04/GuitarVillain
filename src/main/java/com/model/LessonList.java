package com.model;
import java.util.ArrayList;

public class LessonList {

    private static LessonList lessonList;

    private ArrayList<Lesson> lessons;

    private LessonList(){
    
    }

    public static LessonList getInstance(){
        if (lessonList == null) {
            lessonList = new LessonList();
        }
        return lessonList;
    }

    public void createLesson(Lesson lesson){
        
    }

    public Lesson getLesson(String title){
        // TODO: FIX
        return null;
    }

    public void updateLesson(Lesson lesson){

    }

    public void deleteLesson(Lesson lesson){

    }

    public void save(){

    }

}




