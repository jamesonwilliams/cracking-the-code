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
