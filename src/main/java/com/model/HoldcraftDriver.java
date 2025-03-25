package com.model;

import java.util.ArrayList;

/**
 * Testing code by Abby
 * @author Abby Holdcraft
 */
public class HoldcraftDriver {
    public static void main(String[] args) {


        Facade facade = new Facade();
        facade.logIn("abbyholdcraft", "thegrasstoucher");
        facade.becomeAdmin();
        ArrayList<User> userList = facade.getUsers();
        User user = userList.get(3);
        System.out.println(user.getUsername());
        System.out.println(user.getRole());
        
        
        System.out.println(facade.getCurrentUser().getClass());
        System.out.println(facade.getCurrentUser() instanceof Admin);
        facade.logout();

        
        facade.logIn("abbyholdcraft", "thegrasstoucher");
        System.out.println(facade.getCurrentUser().getClass());
        System.out.println(facade.getCurrentUser() instanceof Admin);





    }
}
