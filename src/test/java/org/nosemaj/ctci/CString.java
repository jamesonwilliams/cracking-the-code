package org.nosemaj.ctci;

/**
 * Mocks the behaviour of a C-style string -- a NUL terminated
 * character array.
 */
public final class CString {

    /**
     * The ASCII NUL character, used as a delimeter.
     */
    private static final char NUL = '\0';

    /**
     * Disallows construction of this utility class.
     */
    private CString() {
        throw new IllegalStateException("No instances");
    }

    /**
     * Makes a CString from a Java string.
     * @param string a Java string
     * @return A nul-delimited character array representation of the
     *         string
     */
    public static char[] from(final String string) {
        if (string == null) {
            return null;
        }

        return String.format("%s%c", string, NUL).toCharArray();
    }
}
