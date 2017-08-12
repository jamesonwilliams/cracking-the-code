package org.nosemaj.ctci.arrays;

import org.nosemaj.ctci.PrivateConstructor;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test the RotateMatrixCopy utility.
 */
public final class RotateMatrixCopyTest {

    /**
     * Ensures that RotateMatrixCopy cannot be instantiated.
     * @throws IllegalStateException This is the expected behaviour when
     *                               trying to invoke the constructor
     * @throws Throwable On test failure
     */
    @Test(expected = IllegalStateException.class)
    public void shouldNotConstruct() throws Throwable {
        PrivateConstructor<RotateMatrixCopy> constructor =
            new PrivateConstructor<>(RotateMatrixCopy.class);
        Assert.assertTrue(constructor.isPrivate());
        constructor.construct();
    }

    /**
     * Tests that a 90 degree right rotation of a 3x3 matrix yeilds the
     * expected 3x3 matrix result.
     *
     * @throws AssertionError if matrix rotation happy path is broken
     */
    @Test
    public void shouldRotateMatrix() {
        int[][] input = {
            { 0, 1, 2 },
            { 3, 4, 5 },
            { 6, 7, 8 }
        };

        int[][] expected = {
            { 6, 3, 0 },
            { 7, 4, 1 },
            { 8, 5, 2 }
        };

        int[][] actual = RotateMatrixCopy.rotate90(input, input.length);
        MatrixAssert.assertEquals(expected, actual);
    }
}

