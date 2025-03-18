package com.model;

public class HoldcraftDriver {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.logIn("abbyholdcraft", "thegrasstoucher");
        System.out.println("Current User: " + facade.getCurrentUser());
    }
}
