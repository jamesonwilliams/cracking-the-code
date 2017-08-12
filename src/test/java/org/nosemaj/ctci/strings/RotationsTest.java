package org.nosemaj.ctci.strings;

import org.nosemaj.ctci.PrivateConstructor;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests the Rotations utility.
 */
public final class RotationsTest {

    /**
     * Ensures that Rotations cannot be instantiated.
     * @throws IllegalStateException This is the expected behaviour when
     *                               trying to invoke the constructor
     * @throws Throwable On test failure
     */
    @Test(expected = IllegalStateException.class)
    public void shouldNotConstruct() throws Throwable {
        PrivateConstructor<Rotations> constructor =
            new PrivateConstructor<>(Rotations.class);
        Assert.assertTrue(constructor.isPrivate());
        constructor.construct();
    }

    /**
     * Tests check() on two equal length strings that are also actaully
     * rotations of one another.
     *
     * @throws AssertionError if check() is not correctly determining if
     *                        strings are rotations of eachother
     */
    @Test
    public void shouldReturnTrueWhenInputsAreRotations() {
        Assert.assertTrue(Rotations.check("foo", "oof"));
    }

    /**
     * Tests check() on two unrelated strings that are not rotations of
     * eachother.
     *
     * @throws AssertionError if check() is completely broken
     */
    @Test
    public void shouldReturnFalseWhenUnrelatedInputs() {
        Assert.assertFalse(Rotations.check("foo", "bar"));
    }

    /**
     * Tests check() when one string contains the other inside of it,
     * but they are not rotations of eachother since they differ in
     * number of characters (length).
     *
     * @throws AssertionError if the strings are incorrectly determined
     *                        to be rotations of one another
     */
    @Test
    public void shouldReturnFalseWhenStringSubstring() {
        Assert.assertFalse(Rotations.check("ofo", "foofoofoo"));
    }

}
