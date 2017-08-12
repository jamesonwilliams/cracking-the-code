package org.nosemaj.ctci.cstrings;

import org.nosemaj.ctci.PrivateConstructor;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test the reverse in place utility.
 */
public final class ReverseInPlaceTest {

    /**
     * Ensures that ReverseInPlace cannot be constructed.
     *
     * @throws IllegalStateException This is the expected outcome
     * @throws Throwable if the test has failed for any reason
     */
    @Test(expected = IllegalStateException.class)
    public void testConstructorIsPrivate() throws Throwable {
        PrivateConstructor<ReverseInPlace> constructor =
            new PrivateConstructor<>(ReverseInPlace.class);
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
        char[] input = null;
        ReverseInPlace.reverse(input);
        Assert.assertNull(input);
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
        ReverseInPlace.reverse(palindrome);
        CString.assertEquals(expected, palindrome);
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
        ReverseInPlace.reverse(string);
        CString.assertEquals(expected, string);
    }
}

