package org.nosemaj.ctci.cstrings;

import org.junit.Assert;

/**
 * Mocks the behaviour of a C-style string -- a NUL terminated
 * character array.
 */
public final class CString {

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

        return String.format("%s%c", string, '\0').toCharArray();
    }

    /**
     * Asserts that expected is the same as actual.
     * @param expected Expected test result
     * @param actual An actual obtained result
     * @throws AssertionError if expected is not equal to actual
     */
    public static void assertEquals(final char[] expected,
            final char[] actual) {

        if (expected == null) {
            Assert.assertNull(actual);
            return;
        }

        Assert.assertNotNull(actual);
        Assert.assertEquals(expected.length, actual.length);

        for (int index = 0; index < expected.length; index++) {
            Assert.assertEquals(expected[index], actual[index]);
        }
    }
}
