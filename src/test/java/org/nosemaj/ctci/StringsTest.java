package org.nosemaj.ctci;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests the Strings string check methods.
 */
public final class StringsTest {

    /**
     * Ensures that Strings cannot be instantiated.
     * @throws IllegalStateException This is the expected behaviour when
     *                               trying to invoke the constructor
     * @throws Throwable On test failure
     */
    @Test(expected = IllegalStateException.class)
    public void shouldNotConstruct() throws Throwable {
        PrivateConstructor constructor =
            new PrivateConstructor<Strings>(Strings.class);
        Assert.assertTrue(constructor.isPrivate());
        constructor.construct();
    }

    /**
     * Tests that a string with unique charactrs is evaluaded as
     * unique.
     *
     * @throws AssertionError if the unique string is determined to not
     *                        be unique
     */
    @Test
    public void shouldReturnTrueOnUniqueInputPoly() {
        Assert.assertTrue(Strings.allCharsUniquePoly("abcd"));
    }

    /**
     * Tests that a string with duplicates is evaluated as not unique.
     *
     * @throws AssertionError if the string is determined to contain
     *                        unique characters
     */
    @Test
    public void shouldReturnFalseOnDuplicateInputPoly() {
        Assert.assertFalse(Strings.allCharsUniquePoly("aaaa"));
    }

    /**
     * Tests that a string with all unique characters is evaluated as
     * being unqiue.
     *
     * @throws AssertionError if allCharsUniqueLinear() incorrectly
     *                        assesses a unique string
     */
    @Test
    public void shouldReturnTrueOnUniqueInputLinear() {
        Assert.assertTrue(Strings.allCharsUniqueLinear("123"));
    }

    /**
     * Tests that a string which has duplicated characters will *not* be
     * evaluated as unique.
     *
     * @throws AssertionError if a string with duplicates is incorrectly
     *                        assessed as being unique
     */
    @Test
    public void shouldReturnFalseOnDuplicateInputLinear() {
        Assert.assertFalse(Strings.allCharsUniqueLinear("123123"));
    }

    /**
     * Unrelated inputs should be evaluated as *not* being anagrams of
     * one another.
     *
     * @throws AssertionError if two unrelated inputs are incorrectly
     *                        determined to be anagrams.
     */
    @Test
    public void shouldReturnFalseOnUnrelatedInputs() {
        Assert.assertFalse(Strings.areAnagrams("foo", "bar"));
    }

    /**
     * Valid anagrams should be evaluated as such.
     *
     * @throws AssertionError if areAnagrams() cannot correctly identify
     *                        when two simple anagrams are actaully
     *                        anagrams
     */
    @Test
    public void shouldReturnTrueWhenInputsAreAnagrams() {
        Assert.assertTrue(Strings.areAnagrams("goat", "toga"));
    }

    /**
     * Validates that the position in which strings are passed to the
     * method does not interfere with correct determination of that they
     * are anagrams.
     *
     * @throws AssertionError if the first and second arguments are
     *                        being handled differently in the
     *                        implementation
     */
    @Test
    public void shouldReturnTrueWhenInputAreAnagramsSwapped() {
        String first = "goat";
        String second = "toga";

        boolean bothWaysWork = Strings.areAnagrams(first, second)
            && Strings.areAnagrams(second, first);

        Assert.assertTrue(bothWaysWork);
    }

    /**
     * Ensures that anagrams made up of anagrams are also anagrams.
     *
     * @throws AssertionError if compound anagrams are not determined to
     *                        be anagrams themselves
     */
    @Test
    public void shouldReturnTrueWhenInputsAreCompoundAnagrams() {
        Assert.assertTrue(Strings.areAnagrams("togagoat", "goattoga"));
    }

    /**
     * A simple substring of another string is not an anagram.
     *
     * @throws AssertionError if a substring is incorrectly claimed to
     *                        be an anagram of a larger string
     */
    @Test
    public void shouldReturnFalseWhenStringAndSubstring() {
        Assert.assertFalse(Strings.areAnagrams("boat", "a"));
    }

    /**
     * A string with no spaces will not be modified.
     *
     * @throws AssertionError if a string with no spaces is modified in
     *                        any way
     */
    @Test
    public void shouldReturnInputWhenNoSpaces() {
        testUrlEncodeSpaces("foobar", "foobar");
    }

    /**
     * A string with lots of spaces should be correctly incoded
     * regardless of how many there are or where in the string they are.
     *
     * @throws AssertionError if urlEncodeSpaces is not operating
     *                        correctly
     */
    @Test
    public void shouldEncodeSpacesWhenEverywhere() {
        String expected = "%20%20f%20o%20o%20ba%20%20r%20%20%20";
        String input = "  f o o ba  r   ";
        testUrlEncodeSpaces(expected, input);
    }

    /**
     * A string of all spaces should be fully encoded.
     *
     * @throws AssertionError if a string of just spaces is not encoded
     *                        fully
     */
    @Test
    public void shouldEncodeAllInputCharsWhenAllSpaces() {
        testUrlEncodeSpaces("%20%20%20", "   ");
    }

    /**
     * There is no more encoding needed on an already encoded string.
     *
     * @throws AssertionError if an already encoded string is modified
     *                        in some way (it should not be)
     */
    @Test
    public void shouldReturnInputWhenAlreadyEncoded() {
        testUrlEncodeSpaces("%20foo%20bar", "%20foo%20bar");
    }

    /**
     * Encoding a partially encoded string should fully complete the
     * encoding of the string.
     *
     * @throws AssertionError if a partially encoded string is not fully
     *                        encoded by urlEncodeSpaces().
     */
    @Test
    public void shouldFinishEncodingWhenPartiallyEncoded() {
        testUrlEncodeSpaces("%20foo%20bar%20%20", " foo bar%20 ");
    }

    /**
     * Tests isRotation() on two equal length strings that are also
     * actaully rotations of one another.
     *
     * @throws AssertionError if isRotation() is not correctly
     *                        determining if strings are rotations of
     *                        eachother
     */
    @Test
    public void shouldReturnTrueWhenInputsAreRotations() {
        Assert.assertTrue(Strings.isRotation("foo", "oof"));
    }

    /**
     * Tests isRotation() on two unrelated strings that are not
     * rotations of eachother.
     *
     * @throws AssertionError if isRotation() is completely broken
     */
    @Test
    public void shouldReturnFalseWhenUnrelatedInputs() {
        Assert.assertFalse(Strings.isRotation("foo", "bar"));
    }

    /**
     * Tests isRotation() when one string contains the other inside of
     * it, but they are not rotations of eachother since they differ in
     * number of characters (length).
     *
     * @throws AssertionError if the strings are incorrectly determined
     *                        to be rotations of one another
     */
    @Test
    public void shouldReturnFalseWhenStringSubstring() {
        Assert.assertFalse(Strings.isRotation("ofo", "foofoofoo"));
    }

    /**
     * Calls urlEncodeSpaces on a string input, and compares the result
     * to an expected value.
     *
     * @param expected The expected result of urlEncodeSpaces
     * @param input The input provided to urlEncodeSpaces
     *
     * @throws AssertionError if actual result not equal to expected
     */
    private static void testUrlEncodeSpaces(final String expected,
            final String input) {

        String actual = Strings.urlEncodeSpaces(input);
        if (expected == null) {
            Assert.assertNull(actual);
            return;
        }
        Assert.assertNotNull(actual);
        Assert.assertEquals(expected, actual);
    }
}
