package com.model;

public class CamdenDriver {
    public static void main(String[] args) {
        Facade facade = new Facade();

        facade.getCourses();
        // System.out.println(facade.getLessons());
        System.out.println(facade.getSongs());
        // System.out.println(facade.getModules());
        // System.out.println(facade.getUsers());
    }

}
