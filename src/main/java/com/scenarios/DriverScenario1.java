package com.scenarios;

import com.facade.*;
import com.model.*;

public class DriverScenario1 {
    
    public static void main(String[] args) {
        Facade facade = new Facade();

        System.out.println("--------------------");
        System.out.println("Current user's list");
        System.out.println("--------------------");
        System.out.println();

        int userNumber = 1;
        for (User user : facade.getUsers()) {
            System.out.println("User " + userNumber);
            System.out.println(user.getUsername());
            System.out.println();
            userNumber += 1;
        }

        System.out.println("--------------------");
        System.out.println("New user Signing-Up");
        System.out.println("--------------------");
        System.out.println();

        facade.signUp("newuser123", "newpassword@$", Experience.BEGINNER, SecurityQuestion.MOTHER_MAIDEN_NAME, "Porche-uh");

        userNumber = 1;
        for (User user : facade.getUsers()) {
            System.out.println("User " + userNumber);
            if (userNumber == 5) {
                System.out.println("\u001B[32m" + user.getUsername() + "\u001B[0m");
            }
            else{
                System.out.println(user.getUsername());
            }
            System.out.println();
            userNumber += 1;
        }

        // Remain commented under this is ran for real
        // facade.logout();


    }

}
