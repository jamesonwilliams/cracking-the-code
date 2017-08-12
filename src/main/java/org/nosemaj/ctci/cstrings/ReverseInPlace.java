package org.nosemaj.ctci.cstrings;

/**
 * Reverse a string in place.
 */
public final class ReverseInPlace {

    /**
     * The NUL character.
     */
    private static final char NUL = '\0';

    /**
     * Disallows instantiation of this utility class.
     */
    private ReverseInPlace() {
        throw new IllegalStateException("No instances allowed.");
    }

    /**
     * Reveres the provided string in place.
     *
     * <p>Uses O(1) space, runs in O(n) time.
     *
     * @param string A C-style array of characters
     */
    public static void reverse(final char[] string) {
        if (string == null) {
            return;
        }

        int length = 0;
        int index;
        char placeholder;

        while (string[length] != NUL) {
            length++;
        }

        for (index = 0; index < length / 2; index++) {
            placeholder = string[length - 1 - index];
            string[length - 1 - index] = string[index];
            string[index] = placeholder;
        }
    }
}
