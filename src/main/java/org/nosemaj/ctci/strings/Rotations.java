package org.nosemaj.ctci.strings;

/**
 * Utility to determine if one string is a rotation of another, and
 * vice-versa.
 */
public final class Rotations {

    /**
     * Disallows instantiation of this utility class.
     */
    private Rotations() {
        throw new IllegalStateException("No instances.");
    }

    /**
     * Check if one string is rotation of the other.
     *
     * <p>e.g. watterbottle and erbottlewat
     *
     * @param first A string
     * @param second Another string
     *
     * @return true if the strings are rotations of eachother; false,
     *         otherwise
     */
    public static boolean check(final String first, final String second) {
        if (first.length() != second.length()) {
            return false;
        }

        return (first + first).contains(second);
    }
}
