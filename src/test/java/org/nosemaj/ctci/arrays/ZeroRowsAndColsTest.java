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

import org.nosemaj.ctci.PrivateConstructor;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test the ZeroRowsAndCols utility.
 */
public final class ZeroRowsAndColsTest {

    /**
     * Ensures that ZeroRowsAndCols cannot be instantiated.
     * @throws IllegalStateException This is the expected behaviour when
     *                               trying to invoke the constructor
     * @throws Throwable On test failure
     */
    @Test(expected = IllegalStateException.class)
    public void shouldNotConstruct() throws Throwable {
        PrivateConstructor<ZeroRowsAndCols> constructor =
            new PrivateConstructor<>(ZeroRowsAndCols.class);
        Assert.assertTrue(constructor.isPrivate());
        constructor.construct();
    }

    /**
     * Calling zeroRowsAndCols() on a matrix that has no zeros should
     * have no effect on the matrix's content.
     *
     * @throws AssertionError if zerRowsAndCols() is modifying matrixes
     *                        that have no zeros, which it must never do
     */
    @Test
    public void shouldNotChangeInputWhenMatrixHasNoZeros() {
        int[][] input = {
            { 1, 2 },
            { 4, 5 },
            { 7, 8 }
        };

        int[][] expected = {
            { 1, 2 },
            { 4, 5 },
            { 7, 8 }
        };

        ZeroRowsAndCols.zero(input, 3, 2);
        MatrixAssert.assertEquals(expected, input);
    }

    /**
     * Tests that the elements in the rows and columns where a zero was
     * present at the input are zeroed out in the output.
     *
     * @throws AssertionError if zeroRowsAndCols() happy path is broken
     */
    @Test
    public void shouldZeroOutRowsAndColumns() {
        int[][] input = {
            { 0, 2, 3 },
            { 4, 5, 6 }
        };

        int[][] expected = {
            { 0, 0, 0 },
            { 0, 5, 6 }
        };

        ZeroRowsAndCols.zero(input, 2, 3);
        MatrixAssert.assertEquals(expected, input);
    }
}
