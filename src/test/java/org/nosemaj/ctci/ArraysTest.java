package org.nosemaj.ctci;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests the Arrays methods.
 */
public final class ArraysTest {

    @Test(expected = IllegalStateException.class)
    public void testConstructorIsPrivate() throws Throwable {
        PrivateConstructor constructor = new PrivateConstructor<Arrays>(Arrays.class);
        Assert.assertTrue(constructor.isPrivate());
        constructor.construct();
    }

    @Test
    public void testReverseInPlace_NullInput() {
        Assert.assertNull(Arrays.reverseInPlace(null));
    }

    @Test
    public void testReverseInPlace_Palindrome() {
        char[] expected = CString.from("aABBAa");
        char[] palindrome = CString.from("aABBAa");
        assertEquals(expected, Arrays.reverseInPlace(palindrome));
    }

    @Test
    public void testReverseInPlace_Asymmetrical() {
        char[] expected = CString.from("otatoP");
        char[] string = CString.from("Potato");
        assertEquals(expected, Arrays.reverseInPlace(string));
    }

    @Test
    public void testReverseCopy_NullInput() {
        Assert.assertNull(Arrays.reverseCopy(null));
    }

    @Test
    public void testReverseCopy_Palindrome() {
        char[] palindrome = CString.from("fooBARRABoof");
        assertEquals(palindrome, Arrays.reverseCopy(palindrome));
    }

    @Test
    public void testReverseCopy_Asymmetrical() {
        char[] string = CString.from("asdf1234");
        char[] expected = CString.from("4321fdsa");
        assertEquals(expected, Arrays.reverseCopy(string));
    }

    @Test
    public void testRemoveDuplicatesInPlace_NullInput() {
        testRemoveDuplicates(null, null);
    }

    @Test
    public void testRemoveDuplicatesInPlace_UniqueChars() {
        testRemoveDuplicates("abcdABCD", "abcdABCD");
    }

    @Test
    public void testRemoveDuplicatesInPlace_Empty() {
        testRemoveDuplicates("", "");
    }

    @Test
    public void testRemoveDuplicatesInPlace_NearbyDuplicateAtStart() {
        testRemoveDuplicates("aBCDEF", "aaBCDEF");
    }

    @Test
    public void testRemoveDuplicatesInPlace_SeveralGroups() {
        testRemoveDuplicates("aBCDE", "aaaBBCCCCDDEEEEE");
    }

    @Test
    public void testRemoveDuplicates_InterspersedDupes() {
        testRemoveDuplicates("aBcDefG", "aBaaBBcDefGaB");
    }

    @Test
    public void testZeroRowsAndCols_NoZeros() {
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

    @Test
    public void testZeroRowsAndCols_OneZero() {
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

    @Test
    public void testRotateMatrixCopy() {
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
     * @param expected Expected matrix
     * @param actual Actual matrix
     */
    private void assertEquals(int[][] expected, int[][] actual) {
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
     * @param exected Expected test result before CString conversion
     * @param input String to convert ot CString as input to remove
     *              duplicates
     * @throws AssertionError if expected is not equal to actual
     */
    private void testRemoveDuplicates(String expected, String input) {
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
    private void assertEquals(char[] expected, char[] actual) {
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
