package org.nosemaj.ctci.cstrings;

/**
 * Provide a copy of a string which contains the reverse of an input
 * string.
 */
public final class ReverseCopy {

    /**
     * The NUL character.
     */
    private static final char NUL = '\0';

    /**
     * Disallows instantiation of this utility class.
     */
    private ReverseCopy() {
        throw new IllegalStateException("No instances allowed.");
    }

    /**
     * Gets a reversed copy of the provided string.
     *
     * <p>Uses O(n) space, runs in O(n) time.
     *
     * @param string A C-style array of characters
     *
     * @return A reversed copy of the provided string
     */
    public static char[] reverse(final char[] string) {
        if (string == null) {
            return string;
        }

        int length = 0;

        while (string[length] != NUL) {
            length++;
        }

        char[] copy = new char[length + 1];
        copy[length] = NUL;

        for (int index = 0; index < length; index++) {
            copy[length - 1 - index] = string[index];
        }

        return copy;
    }
}
