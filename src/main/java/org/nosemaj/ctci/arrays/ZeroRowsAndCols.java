package org.nosemaj.ctci.arrays;

/**
 * Zero the rows and columns of a matrix whenever a zero is seen at any
 * position.
 */
public final class ZeroRowsAndCols {

    /**
     * Disallows instantiation of this utility class.
     */
    private ZeroRowsAndCols() {
        throw new IllegalStateException("No instances allowed.");
    }

    /**
     * If an MxN matrix contains a zero, then zero out the row and
     * column in which that zero occurs.
     * @param matrix the matrix to modify
     * @param rows Number of rows
     * @param cols Number of columns
     */
    public static void zero(final int[][] matrix, final int rows,
            final int cols) {

        boolean[] zeroRows = new boolean[rows];
        boolean[] zeroCols = new boolean[cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == 0) {
                    zeroRows[row] = true;
                    zeroCols[col] = true;
                }
            }
        }

        for (int row = 0; row < rows; row++) {
            if (!zeroRows[row]) {
                continue;
            }

            for (int col = 0; col < cols; col++) {
                matrix[row][col] = 0;
            }
        }

        for (int col = 0; col < cols; col++) {
            if (!zeroCols[col]) {
                continue;
            }

            for (int row = 0; row < rows; row++) {
                matrix[row][col] = 0;
            }
        }
    }
}

