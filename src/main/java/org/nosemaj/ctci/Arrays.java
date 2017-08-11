package org.nosemaj.ctci;

/**
 * Solutions to Chapter 1 - Arrays.
 */
public final class Arrays {

    private static final char NUL = '\0';

    /**
     * Disallows construction of this utility class.
     */
    private Arrays() {
        throw new IllegalStateException("No instances!");
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
    public static char[] reverseCopy(char[] string) {
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

    /**
     * Reveres the provided string in place.
     *
     * <p>Uses O(1) space, runs in O(n) time.
     *
     * @param string A C-style array of characters
     *
     * @return The provided string, which is now reversed
     */
    public static char[] reverseInPlace(char[] string) {
        if (string == null) {
            return string;
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

        return string;
    }

    /**
     * Removes duplicate characters from a C-style string, in place.
     *
     * <p>The resulting string will be the deduped string with NUL
     * characters padding the remaining positions at the end of the
     * array -- one additional NUL for each duplicate removed.
     *
     * @param string A C-style NUL-terminated array of characters.
     * @return The provided C string, but modifed as described
     */
    public static char[] removeDuplicatesInPlace(char[] string) {
        if (string == null) {
            return string;
        }

        int leading;
        int trailing;
        int length = 0;

        while (string[length] != NUL) {
            length++;
        }

        // Find duplicates, and replace them with a NUL, in O(n^2) time.
        for (trailing = 0; trailing < length; trailing++) {
            for (leading = trailing + 1; leading < length; leading++) {
                if (string[trailing] == string[leading]) {
                    string[leading] = NUL;
                }
            }
        }

        /**
         * Linear scan of array to move non-NUL chars to the front of
         * the array. Trailing index keeps track of the first NUL char
         * that can be populated. Leading index scans for the next
         * non-NUL char to move into the trailing index's position. This
         * continues until the trailing index has hit the end of the
         * string.
         */
        trailing = 0;
        leading = 0;
        while (leading < length) {
            // Advance trailing index to first NUL char
            while (string[trailing] != NUL) {
                trailing++;
            }

            // Advance the leading index to the next non-NUL char.
            leading = trailing + 1;
            while (leading < length && string[leading] == NUL) {
                leading++;
            }

            // If there was a non-NUL, move it to leading
            if (leading < length && string[leading] != NUL) {
                string[trailing] = string[leading];
                string[leading] = NUL;
            }
        }

        return string;
    }
}
