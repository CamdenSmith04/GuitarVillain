package com.model;

public class AndrewDriver {
    public static void main(){
        DataLoader dataLoader = new DataLoader();
        System.out.println("Dataloader constructed");
        dataLoader.getCourses();
        dataLoader.getLessons();
        dataLoader.getSongs();
        dataLoader.getModules();
        dataLoader.getUsers();
        
        
    }
}
