package com.drivers;

import com.dataManagers.DataLoader;

public class AndrewDriver {
    public static void main(String[] args) {
        DataLoader.getCourses();
        DataLoader.getLessons();
        DataLoader.getSongs();
        DataLoader.getModules();
        DataLoader.getUsers();
        System.out.println("Dataloader constructed");
        
        
    }
}
