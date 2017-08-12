package org.nosemaj.ctci.strings;

/**
 * Check for unique characters in a string in polynomial time, but with
 * constant space.
 */
public final class UniqueCharsPolynomial {

    /**
     * Disallows instantiation of this utility class.
     */
    private UniqueCharsPolynomial() {
        throw new IllegalStateException("No instances.");
    }

    /**
     * Check if the provided string is composed of all unique
     * characters.
     *
     * <p>Uses O(1) space, but runs in O(n^2) time.
     *
     * @param string String to check for unique characters
     *
     * @return true if all charactres in string are unique; false,
     *         otherwise.
     */
    public static boolean unique(final String string) {
        for (int outer = 0; outer < string.length(); outer++) {
            for (int inner = outer + 1; inner < string.length(); inner++) {
                if (string.charAt(outer) == string.charAt(inner)) {
                    return false;
                }
            }
        }

        return true;
    }
}
