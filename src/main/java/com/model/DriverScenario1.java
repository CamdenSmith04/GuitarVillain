package com.model;

import java.util.Scanner;

public class DriverScenario1 {
    /*
     * Show Fred is not logged in but Fellicia is.
     * Fred attempts to make new account and bounces
     * Fred makes new account ffred
     * Fred logs out
     * Show users.json
     * Fred successfully logs in
     */
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Facade facade = Facade.getInstance();

        boolean userCreated = facade.signUp("ffredrickson", "theTwoFred!", Experience.BEGINNER, SecurityQuestion.ELEMENTARY_SCHOOL, "Bowman");
        
        System.out.println(userCreated);

        Scanner continueScenario = new Scanner(System.in);
        continueScenario.nextLine();

        userCreated = facade.signUp("ffred", "theTwoFred!", Experience.BEGINNER, SecurityQuestion.ELEMENTARY_SCHOOL, "Bowman");

        System.out.println(userCreated);

        facade.logout();

        continueScenario.nextLine();

        boolean loggedIn = facade.logIn("ffred", "theTwoFred!");

        System.out.println(loggedIn);
    }

}
