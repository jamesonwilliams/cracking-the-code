package org.nosemaj.ctci;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

/**
 * Reflection utility to create instances of classes which have private
 * constructors. This is used only for test.
 */
public final class PrivateConstructor<T> {

    private final Constructor<T> constructor;

    /**
     * Constructs a new instance of the PrivateConstructor.
     * @param clazz The class of the object whose constructor is private
     */
    public PrivateConstructor(Class<T> clazz) {
        try {
            constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
        } catch (NoSuchMethodException noSuchMethodException) {
            throw new RuntimeException(noSuchMethodException);
        }
    }

    /**
     * Determines if the class' constructor is private.
     * @return true if the class has a private constructor; false,
     *         otherwise.
     */
    public boolean isPrivate() {
        return Modifier.isPrivate(constructor.getModifiers());
    }

    /**
     * Constructs a new instance of the class whose constructor has been
     * snooped.
     * @return A new instance of the class
     */
    public T construct() throws Throwable {
        try {
            return constructor.newInstance();
        } catch (InvocationTargetException invocationTargetException) {
            throw invocationTargetException.getCause();
        }
    }
}
