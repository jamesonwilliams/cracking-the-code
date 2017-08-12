package org.nosemaj.ctci.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Checks if a string contains unqiue characters, in linear time, but
 * using O(n) space.
 */
public final class UniqueCharsLinear {

    /**
     * Disallows instantiation of this utility class.
     */
    private UniqueCharsLinear() {
        throw new IllegalStateException("No instances.");
    }

    /**
     * Check if the provided string is composed of all unique
     * characters.
     *
     * <p>Uses O(n) space, and runs in O(n) time.
     *
     * @param string The string to check for unique characters
     *
     * @return true if all characters in string are unique; false,
     *         otherwise.
     */
    public static boolean unique(final String string) {
        Set<Character> seenChars = new HashSet<>();

        for (int index = 0; index < string.length(); index++) {
            if (seenChars.contains(string.charAt(index))) {
                return false;
            }

            seenChars.add(string.charAt(index));
        }

        return true;
    }
}
