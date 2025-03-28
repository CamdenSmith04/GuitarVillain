package com.model;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Handles user authorization - e.g. Student cannot assign courses, etc.
 * @author Holdcraft
 */
public class FacadeProxy implements InvocationHandler {

    private final Object target;
    private final Class<?> userRole;

    /**
     * Initializes the proxy.
     * @param target Facade being targeted
     * @param userRole User's role (teacher, student, etc)
     */
    public FacadeProxy(Object target, Class<?> userRole) {
        this.target = target;
        this.userRole = userRole;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // System.out.println(target);
        try {
            if (userRole.getDeclaredMethod(method.getName(), (Class<?>[])args) != null)
                return method.invoke(method, args);
            return null;
        } catch (NoSuchMethodException e) {
            throw new IllegalAccessException("Access denied for: " + method.getName());
        }
    }

    public static GuestInterface makeGuestFacade() {
        GuestInterface facade = new Facade();
        GuestInterface secureFacade = (GuestInterface) Proxy.newProxyInstance(
            GuestInterface.class.getClassLoader(),
            new Class[]{GuestInterface.class},
            new FacadeProxy(facade, String.class)
        );
        return secureFacade;
    }

    /**
     * Creates proxy to call methods securely
     * @param target Facade being used
     * @param userRole 
     * @return
     */
    public static Object createProxy(Object target, Class<?> userRole) {
        return Proxy.newProxyInstance(
            target.getClass().getClassLoader(),
            target.getClass().getInterfaces(),
            new FacadeProxy(target, userRole)
        );
    }
    
}
