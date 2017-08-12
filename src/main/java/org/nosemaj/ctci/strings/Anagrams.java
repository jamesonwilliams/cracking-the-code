package org.nosemaj.ctci.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility to determine if strings are anagrams.
 */
public final class Anagrams {

    /**
     * Disallows instantiation of this utility class.
     */
    private Anagrams() {
        throw new IllegalStateException("No instances.");
    }

    /**
     * Check if a string is an anagram of another.
     *
     * <p>O(n) compute, O(n*m) space.
     *
     * @param first A string
     * @param second Another string
     *
     * @return true if one string is an anagram of the other; false,
     *         otherwise
     */
    public static boolean check(final String first, final String second) {
        Map<Character, Integer> charCounts = new HashMap<>();

        if (first.length() != second.length()) {
            return false;
        }

        // Record char counts of first string
        for (int index = 0; index < first.length(); index++) {
            Character current = first.charAt(index);
            Integer numSeen = charCounts.get(current);
            if (numSeen == null) {
                numSeen = Integer.valueOf(1);
            } else {
                numSeen++;
            }
            charCounts.put(current, numSeen);
        }

        // Decrease char counts for each char in second string
        for (int index = 0; index < second.length(); index++) {
            Character current = second.charAt(index);
            Integer numSeen = charCounts.get(current);
            if (numSeen == null) {
                return false;
            }
            charCounts.put(current, --numSeen);
        }

        // If any count is not 0, they're not anagrams
        for (Integer count : charCounts.values()) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}

