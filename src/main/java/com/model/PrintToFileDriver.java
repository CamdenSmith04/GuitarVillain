package com.model;

public class PrintToFileDriver {
    public static void main(String[] args){
        Facade facade = new Facade();

        // Log-in
        facade.logIn("andrewgoad", "thegrasstoucher");
        // facade.printSongToFile("Fur Elise");
        facade.logout();
    }   
}
