package org.nosemaj.ctci;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests the Arrays methods.
 */
public final class ArraysTest {

    /**
     * Ensures that Arrays cannot be constructed.
     *
     * @throws IllegalStateException This is the expected outcome
     * @throws Throwable if the test has failed for any reason
     */
    @Test(expected = IllegalStateException.class)
    public void testConstructorIsPrivate() throws Throwable {
        PrivateConstructor constructor =
            new PrivateConstructor<Arrays>(Arrays.class);
        Assert.assertTrue(constructor.isPrivate());
        constructor.construct();
    }

    /**
     * Reversing a null string should return null.
     *
     * @throws AssertionError if something other than null comes back
     */
    @Test
    public void shouldReturnNullOnNullInputInPlace() {
        Assert.assertNull(Arrays.reverseInPlace(null));
    }

    /**
     * Reversing a palindrome should not modify the semantic content of
     * the string.
     *
     * @throws AssertionError if the reverse of a palindrome is not the
     *                        original palindrom
     */
    @Test
    public void shouldReturnInputWhenReversingPalindromeInPlace() {
        char[] expected = CString.from("aABBAa");
        char[] palindrome = CString.from("aABBAa");
        assertEquals(expected, Arrays.reverseInPlace(palindrome));
    }

    /**
     * Reversing a simple string should return its reverse.
     *
     * @throws AssertionError if simple happy path is broken
     */
    @Test
    public void shouldReverseSimpleStringInPlace() {
        char[] expected = CString.from("otatoP");
        char[] string = CString.from("Potato");
        assertEquals(expected, Arrays.reverseInPlace(string));
    }

    /**
     * Reversing null should return null.
     *
     * @throws AssertionError if something non-null comes back
     */
    @Test
    public void shouldReturnNullOnNullInputCopy() {
        Assert.assertNull(Arrays.reverseCopy(null));
    }

    /**
     * Reversing a palindrome should return the palindrome.
     *
     * @throws AssertionError if the reverse of a palindrome is not
     *                        returned as the palindrome itself
     */
    @Test
    public void shouldReturnPalindromeWhenGivenPalindromeCopy() {
        char[] palindrome = CString.from("fooBARRABoof");
        assertEquals(palindrome, Arrays.reverseCopy(palindrome));
    }

    /**
     * Ensures that a simple string which is not a palindrome can be
     * succesfully reversed.
     *
     * @throws AssertionError if string reverse happy path is broken
     */
    @Test
    public void shouldReverseString() {
        char[] string = CString.from("asdf1234");
        char[] expected = CString.from("4321fdsa");
        assertEquals(expected, Arrays.reverseCopy(string));
    }

    /**
     * Passing null to remove duplicates should just return null.
     *
     * @throws AssertionError if something other than null was returned
     */
    @Test
    public void shouldReturnNullWhenProvidedNull() {
        testRemoveDuplicates(null, null);
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
        testRemoveDuplicates("abcdABCD", "abcdABCD");
    }

    /**
     * The reverse of an empty string is an empty string.
     *
     * @throws AssertionError if an empty string is modified in some way
     *                        -- it must not be.
     */
    @Test
    public void shouldReturnEmptyWhenEmptyInput() {
        testRemoveDuplicates("", "");
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
        testRemoveDuplicates("aBCDEF", "aaBCDEF");
    }

    /**
     * Multiple runs of consecutive repeated chars should be deduped.
     *
     * @throws AssertionError if multiple groups break
     *                        removeDuplicates()
     */
    @Test
    public void shouldDedupeInputOnMultipleDuplicateGroups() {
        testRemoveDuplicates("aBCDE", "aaaBBCCCCDDEEEEE");
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
        testRemoveDuplicates("aBcDefG", "aBaaBBcDefGaB");
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

        Arrays.zeroRowsAndCols(input, 3, 2);
        assertEquals(expected, input);
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

        Arrays.zeroRowsAndCols(input, 2, 3);
        assertEquals(expected, input);
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

        assertEquals(expected, Arrays.rotateMatrixCopy(input, input.length));
    }

    /**
     * Asserts that the expected matrix is equal to the actual matrix.
     *
     * @param expected Expected matrix
     * @param actual Actual matrix
     *
     * @throws AssertionError if expected not equal to actual
     */
    private void assertEquals(final int[][] expected, final int[][] actual) {
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

    /**
     * Tests the remove duplicates method by providing an input for the
     * method, and checking the execution of that input against an
     * expected result.
     *
     * <p> The arguments are first converted to char[].
     *
     * @param expected Expected test result before CString conversion
     * @param input String to convert ot CString as input to remove
     *              duplicates
     * @throws AssertionError if expected is not equal to actual
     */
    private void testRemoveDuplicates(final String expected,
            final String input) {

        char[] expectedCString = CString.from(expected);
        char[] inputCString = CString.from(input);
        char[] result = Arrays.removeDuplicatesInPlace(inputCString);

        if (expected == null) {
            Assert.assertNull(result);
            return;
        }

        Assert.assertNotNull(result);

        int resultLength = 0;
        while (result[resultLength] != '\0') {
            resultLength++;
        }

        int expectedLength = 0;
        while (expectedCString[expectedLength] != '\0') {
            expectedLength++;
        }

        Assert.assertEquals(expectedLength, resultLength);
        for (int index = expectedLength; index < 0; index++) {
            Assert.assertEquals(expectedCString[index], result[index]);
        }
    }

    /**
     * Asserts that expected is the same as actual.
     * @param expected Expected test result
     * @param actual An actual obtained result
     * @throws AssertionError if expected is not equal to actual
     */
    private void assertEquals(final char[] expected, final char[] actual) {
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
