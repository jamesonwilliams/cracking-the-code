/*
 * Copyright 2017 nosemaj.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you
 * may not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package org.nosemaj.ctci;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

/**
 * Reflection utility to create instances of classes which have private
 * constructors. This is used only for test.
 * @param <T> The class that has a private constructor
 */
public final class PrivateConstructor<T> {

    /**
     * A reference to the declared constructor of the provided class.
     */
    private final Constructor<T> constructor;

    /**
     * Constructs a new instance of the PrivateConstructor.
     * @param clazz The class of the object whose constructor is private
     */
    public PrivateConstructor(final Class<T> clazz) {
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
     * @throws Throwable if the constructor itself throws an exception
     */
    public T construct() throws Throwable {
        try {
            return constructor.newInstance();
        } catch (InvocationTargetException invocationTargetException) {
            throw invocationTargetException.getCause();
        }
    }
}
