package org.nosemaj.ctci.strings;

import org.nosemaj.ctci.PrivateConstructor;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test the polynomial algorithm to check for unique chars in a string.
 */
public final class UniqueCharsPolynomialTest {

    /**
     * Ensures that UniqueCharsPolynomial cannot be instantiated.
     * @throws IllegalStateException This is the expected behaviour when
     *                               trying to invoke the constructor
     * @throws Throwable On test failure
     */
    @Test(expected = IllegalStateException.class)
    public void shouldNotConstruct() throws Throwable {
        PrivateConstructor<UniqueCharsPolynomial> constructor =
            new PrivateConstructor<>(UniqueCharsPolynomial.class);
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
        Assert.assertTrue(UniqueCharsPolynomial.unique("abcd"));
    }

    /**
     * Tests that a string with duplicates is evaluated as not unique.
     *
     * @throws AssertionError if the string is determined to contain
     *                        unique characters
     */
    @Test
    public void shouldReturnFalseOnDuplicateInputPoly() {
        Assert.assertFalse(UniqueCharsPolynomial.unique("aaaa"));
    }
}
