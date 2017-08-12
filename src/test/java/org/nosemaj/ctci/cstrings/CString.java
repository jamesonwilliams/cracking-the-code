/*
 * Copyright 2017 nosemaj.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you
 * may not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

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
