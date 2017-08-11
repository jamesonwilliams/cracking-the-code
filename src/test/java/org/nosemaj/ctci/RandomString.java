package org.nosemaj.ctci;

import java.security.SecureRandom;
import java.math.BigInteger;

/**
 * Utility class to generate random strings.
 */
public final class RandomString {

    /**
     * Refuses construction of a RandomString instance.
     */
    private RandomString() {
        throw new IllegalStateException("No instances of RandomString allowed.");
    }

    /**
     * Generates a random string of length 32.
     * @return A random string
     */
    public static String string() {
        return new BigInteger(130, new SecureRandom()).toString(32);
    }
}

