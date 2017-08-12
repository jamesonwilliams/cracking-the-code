package org.nosemaj.ctci;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Solutions to Chapter 1 - Strings.
 */
public final class Strings {

    /**
     * Disallows construction of this utility class.
     */
    private Strings() {
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

    /**
     * Check if a string is an anagram of another.
     * 
     * <p>O(n) compute, O(n*m) space.
     *
     * @param first A string
     * @param second Another string
     * @return true if one string is an anagram of the other; false,
     *         otherwise
     */
    public static boolean areAnagrams(String first, String second) {
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

    /**
     * Replaces all instances of a space character by %20.
     * @param string A string that may contain spaces
     * @return A string whose spaces have become %20
     */
    public static String urlEncodeSpaces(String string) {
        StringBuilder builder = new StringBuilder();

        for (int index = 0; index < string.length(); index++) {
            if (string.charAt(index) == ' ') {
                builder.append("%20");
            } else {
                builder.append(string.charAt(index));
            }
        }

        return builder.toString();
    }
}
