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
