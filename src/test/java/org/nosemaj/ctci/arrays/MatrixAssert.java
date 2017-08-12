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

package org.nosemaj.ctci.arrays;

import org.junit.Assert;

/**
 * Asserts that two matrices are equal to one another.
 */
public final class MatrixAssert {

    /**
     * Disallows construction of this test utility.
     */
    private MatrixAssert() {
        throw new IllegalArgumentException("No instances.");
    }

    /**
     * Asserts that the expected matrix is equal to the actual matrix.
     *
     * @param expected Expected matrix
     * @param actual Actual matrix
     *
     * @throws AssertionError if expected not equal to actual
     */
    public static void assertEquals(final int[][] expected,
            final int[][] actual) {

        if (expected == null) {
            Assert.assertNull(actual);
            return;
        }

        Assert.assertNotNull(actual);
        Assert.assertEquals(expected.length, actual.length);
        Assert.assertEquals(expected[0].length, actual[0].length);

        for (int row = 0; row < expected.length; row++) {
            for (int col = 0; col < expected[0].length; col++) {
                Assert.assertEquals(
                    String.format("Expected [%d][%d] = %d, but was %d.",
                        row, col, expected[row][col], actual[row][col]),
                    expected[row][col], actual[row][col]);
            }
        }
    }
}
