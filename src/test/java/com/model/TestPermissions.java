package com.model;

import java.lang.reflect.Proxy;
/**
 * Tests AuthorizationProxy to make secure facades and switch between user permissions
 * EXPECTED OUTPUT: 
 * true
 * ACTUAL OUTPUT:
 * class [Ljava.lang.Object; cannot be cast to class [Ljava.lang.Class; ([Ljava.lang.Object; and [Ljava.lang.Class; are in module java.base of loader 'bootstrap')
 * BUGS: 
 * Does not actually call method.
 * FIX PROPOSAL:
 * Ditch this method and add isUser, isTeacher, isStudent, isAdmin checks to neccesary methods. Time spent learning this method is not worth it.
 * @author Abby Holdcraft
 */
public class TestPermissions {
    public static void main(String[] args) {

        GuestInterface facade = new Facade();

        GuestInterface secureFacade = (GuestInterface) Proxy.newProxyInstance(
            GuestInterface.class.getClassLoader(),
            new Class[]{GuestInterface.class}, 
            new FacadeProxy(facade, String.class)
        );

        try {
            System.out.println(secureFacade.logIn("abbyholdcraft", "thegrasstoucher"));
            // secureFacade.logout();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
