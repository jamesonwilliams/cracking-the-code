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

import org.nosemaj.ctci.PrivateConstructor;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests the RemoveDuplicatesInPlace utility.
 */
public final class RemoveDuplicatesInPlaceTest {

    /**
     * Ensures that RemoveDuplicatesInPlace cannot be instantiated.
     * @throws IllegalStateException This is the expected behaviour when
     *                               trying to invoke the constructor
     * @throws Throwable On test failure
     */
    @Test(expected = IllegalStateException.class)
    public void shouldNotConstruct() throws Throwable {
        PrivateConstructor<RemoveDuplicatesInPlace> constructor =
            new PrivateConstructor<>(RemoveDuplicatesInPlace.class);
        Assert.assertTrue(constructor.isPrivate());
        constructor.construct();
    }

    /**
     * Passing null to remove duplicates should just return null.
     *
     * @throws AssertionError if something other than null was returned
     */
    @Test
    public void shouldReturnNullWhenProvidedNull() {
        testRemoveDuplicatesInPlace(null, null);
    }

    /**
     * When there are no duplicates, the result of removeDuplicates()
     * should be the same as the input.
     *
     * @throws AssertionError if removeDuplicates() is not simply
     *                        passing through already unique strings
     */
    @Test
    public void shouldReturnInputWhenNoDuplicatesInInput() {
        testRemoveDuplicatesInPlace("abcdABCD", "abcdABCD");
    }

    /**
     * The reverse of an empty string is an empty string.
     *
     * @throws AssertionError if an empty string is modified in some way
     *                        -- it must not be.
     */
    @Test
    public void shouldReturnEmptyWhenEmptyInput() {
        testRemoveDuplicatesInPlace("", "");
    }

    /**
     * The remove duplicates method should handle simple duplicate at
     * start of string.
     *
     * @throws AssertionError if simple duplicate at start of string is
     *                        not removed correctly
     */
    @Test
    public void shouldReturnDedupeWhenSingleStartingDupe() {
        testRemoveDuplicatesInPlace("aBCDEF", "aaBCDEF");
    }

    /**
     * Multiple runs of consecutive repeated chars should be deduped.
     *
     * @throws AssertionError if multiple groups break
     *                        removeDuplicates()
     */
    @Test
    public void shouldDedupeInputOnMultipleDuplicateGroups() {
        testRemoveDuplicatesInPlace("aBCDE", "aaaBBCCCCDDEEEEE");
    }

    /**
     * Interspersed duplicated values (buffered by other characters)
     * must be deduplicated.
     *
     * @throws AssertionError if the removeDuplicates() cannot handle
     *                        the case where duplicates are interspersed
     *                        within the bigger string
     */
    @Test
    public void shouldDedupeInputOnInterspersedDupes() {
        testRemoveDuplicatesInPlace("aBcDefG", "aBaaBBcDefGaB");
    }

    /**
     * Tests the remove duplicates method by providing an input for the
     * method, and checking the execution of that input against an
     * expected result.
     *
     * <p> The arguments are first converted to char[].
     *
     * @param expected Expected test result before CString conversion
     * @param input String to convert to CString as input to remove
     *              duplicates
     * @throws AssertionError if expected is not equal to the modified
     *                        input
     */
    private void testRemoveDuplicatesInPlace(final String expected,
            final String input) {

        char[] expectedCString = CString.from(expected);
        char[] inputCString = CString.from(input);
        RemoveDuplicatesInPlace.removeDuplicates(inputCString);

        if (expected == null) {
            Assert.assertNull(inputCString);
            return;
        }

        Assert.assertNotNull(inputCString);

        int resultLength = 0;
        while (inputCString[resultLength] != '\0') {
            resultLength++;
        }

        int expectedLength = 0;
        while (expectedCString[expectedLength] != '\0') {
            expectedLength++;
        }

        Assert.assertEquals(expectedLength, resultLength);
        for (int index = expectedLength; index < 0; index++) {
            Assert.assertEquals(expectedCString[index], inputCString[index]);
        }
    }
}
