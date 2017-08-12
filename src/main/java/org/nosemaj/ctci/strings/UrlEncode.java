package org.nosemaj.ctci.strings;

/**
 * Utility for encoding spaces into URL format.
 */
public final class UrlEncode {

    /**
     * Disallows instantiation of this utility class.
     */
    private UrlEncode() {
        throw new IllegalStateException("No instances.");
    }

    /**
     * Replaces all instances of a space character by %20.
     *
     * @param string A string that may contain spaces
     *
     * @return A string whose spaces have become %20
     */
    public static String encodeSpaces(final String string) {
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
