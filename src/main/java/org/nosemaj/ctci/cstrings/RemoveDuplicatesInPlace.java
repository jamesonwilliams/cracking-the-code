package org.nosemaj.ctci.cstrings;

/**
 * Remove duplicates in place.
 */
public final class RemoveDuplicatesInPlace {

    /**
     * The NUL character.
     */
    private static final char NUL = '\0';

    /**
     * Disallows instantiation of this utility class.
     */
    private RemoveDuplicatesInPlace() {
        throw new IllegalStateException("No instances allowed.");
    }

    /**
     * Removes duplicate characters from a C-style string, in place.
     *
     * <p>The resulting string will be the deduped string with NUL
     * characters padding the remaining positions at the end of the
     * array -- one additional NUL for each duplicate removed.
     *
     * @param string A C-style NUL-terminated array of characters.
     */
    public static void removeDuplicates(final char[] string) {
        if (string == null) {
            return;
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
    }
}
