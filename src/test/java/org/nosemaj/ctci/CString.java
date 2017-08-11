package org.nosemaj.ctci;

/**
 * Mocks the behaviour of a C-style string -- a NUL terminated
 * character array.
 */
public final class CString {

    /**
     * Makes a CString from a Java string.
     * @parm string a Java string
     */
    public static char[] from(String string) {
        if (string == null) {
            return null;
        }

        return String.format("%s\0", string).toCharArray();
    }
}
