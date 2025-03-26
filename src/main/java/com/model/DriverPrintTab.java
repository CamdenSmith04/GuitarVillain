package com.model;

public class DriverPrintTab {
    public static void main(String[] args){
        Facade facade = new Facade();

        // Log-in
        facade.logIn("andrewgoad", "thegrasstoucher");
        facade.printSongToFile("Fur Elise");
    }   
}
