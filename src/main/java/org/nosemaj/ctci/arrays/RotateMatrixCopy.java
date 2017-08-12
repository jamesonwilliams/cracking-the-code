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

/**
 * Gets a copy of a matrix, but rotated.
 */
public final class RotateMatrixCopy {

    /**
     * Disallows instantiation of this utility class.
     */
    private RotateMatrixCopy() {
        throw new IllegalStateException("No instances allowed.");
    }

    /**
     * Rotates a square matrix 90 degrees right.
     * @param matrix the matrix to rotate
     * @param size The size of one side of the matrix
     * @return A rotated copy of the provided matrix
     */
    public static int[][] rotate90(final int[][] matrix,
            final int size) {

        int[][] result = new int[size][size];

        for (int col = size - 1; col >= 0; col--) {
            for (int row = 0; row < size; row++) {
                result[row][col] = matrix[size - 1 - col][row];
            }
        }

        return result;
    }
}
