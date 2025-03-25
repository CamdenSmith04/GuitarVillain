package com.facade;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Set;

/**
 * Handles user authorization - e.g. Student cannot assign courses, etc.
 * @author Holdcraft
 */
public class AuthHandler implements InvocationHandler {

    private final Facade facade;
    private final Set<String> allowedMethods;

    public AuthHandler(Facade facade, Set<String> allowedMethods) {
        this.facade = facade;
        this.allowedMethods = allowedMethods;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (allowedMethods.contains(method.getName()))
            return method.invoke(facade, args);
        throw new IllegalStateException("Access Denied: Not authorized for this action");
    }

    public static <T> T createProxy(Class<T> facadeInterface, Facade facade, Set<String> allowedMethods) {
        return (T) Proxy.newProxyInstance(
            facadeInterface.getClassLoader(), 
            new Class[]{facadeInterface},
            new AuthHandler(facade, allowedMethods));
    }
    
}
