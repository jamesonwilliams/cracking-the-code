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

package org.nosemaj.ctci.strings;

import org.nosemaj.ctci.PrivateConstructor;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests the UrlEncode utility.
 */
public final class UrlEncodeTest {

    /**
     * Ensures that UrlEncode cannot be instantiated.
     * @throws IllegalStateException This is the expected behaviour when
     *                               trying to invoke the constructor
     * @throws Throwable On test failure
     */
    @Test(expected = IllegalStateException.class)
    public void shouldNotConstruct() throws Throwable {
        PrivateConstructor<UrlEncode> constructor =
            new PrivateConstructor<>(UrlEncode.class);
        Assert.assertTrue(constructor.isPrivate());
        constructor.construct();
    }

    /**
     * A string with no spaces will not be modified.
     *
     * @throws AssertionError if a string with no spaces is modified in
     *                        any way
     */
    @Test
    public void shouldReturnInputWhenNoSpaces() {
        testUrlEncodeSpaces("foobar", "foobar");
    }

    /**
     * A string with lots of spaces should be correctly incoded
     * regardless of how many there are or where in the string they are.
     *
     * @throws AssertionError if urlEncodeSpaces is not operating
     *                        correctly
     */
    @Test
    public void shouldEncodeSpacesWhenEverywhere() {
        String expected = "%20%20f%20o%20o%20ba%20%20r%20%20%20";
        String input = "  f o o ba  r   ";
        testUrlEncodeSpaces(expected, input);
    }

    /**
     * A string of all spaces should be fully encoded.
     *
     * @throws AssertionError if a string of just spaces is not encoded
     *                        fully
     */
    @Test
    public void shouldEncodeAllInputCharsWhenAllSpaces() {
        testUrlEncodeSpaces("%20%20%20", "   ");
    }

    /**
     * There is no more encoding needed on an already encoded string.
     *
     * @throws AssertionError if an already encoded string is modified
     *                        in some way (it should not be)
     */
    @Test
    public void shouldReturnInputWhenAlreadyEncoded() {
        testUrlEncodeSpaces("%20foo%20bar", "%20foo%20bar");
    }

    /**
     * Encoding a partially encoded string should fully complete the
     * encoding of the string.
     *
     * @throws AssertionError if a partially encoded string is not fully
     *                        encoded by urlEncodeSpaces().
     */
    @Test
    public void shouldFinishEncodingWhenPartiallyEncoded() {
        testUrlEncodeSpaces("%20foo%20bar%20%20", " foo bar%20 ");
    }

    /**
     * Calls urlEncodeSpaces on a string input, and compares the result
     * to an expected value.
     *
     * @param expected The expected result of urlEncodeSpaces
     * @param input The input provided to urlEncodeSpaces
     *
     * @throws AssertionError if actual result not equal to expected
     */
    private static void testUrlEncodeSpaces(final String expected,
            final String input) {

        String actual = UrlEncode.encodeSpaces(input);
        if (expected == null) {
            Assert.assertNull(actual);
            return;
        }
        Assert.assertNotNull(actual);
        Assert.assertEquals(expected, actual);
    }
}

