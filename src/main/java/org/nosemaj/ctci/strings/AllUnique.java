package org.nosemaj.ctci.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * 1.1 Implement an algorithm to determine if a string has all unique
 * characters. What if you can not use additional data structures?
 */
public final class AllUnique {

    /**
     * Disallows construction of this utility class.
     */
    private AllUnique() {
        throw new IllegalStateException("No instances!");
    }

    /**
     * Check if the provided string is composed of all unique
     * characters.
     *
     * <p>Uses O(1) space, but runs in O(n^2) time.
     *
     * @return true if all charactres in string are unique; false,
     *         otherwise.
     */
    public static boolean allCharsUniquePoly(String string) {
        for (int outer = 0; outer < string.length(); outer++) {
            for (int inner = outer + 1; inner < string.length(); inner++) {
                if (string.charAt(outer) == string.charAt(inner)) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Check if the provided string is composed of all unique
     * characters.
     *
     * <p>Uses O(n) space, and runs in O(n) time.
     *
     * @return true if all characters in string are unique; false,
     *         otherwise.
     */
    public static boolean allCharsUniqueLinear(String string) {
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
