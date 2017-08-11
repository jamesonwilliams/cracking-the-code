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
