package org.nosemaj.ctci.strings;

import org.nosemaj.ctci.PrivateConstructor;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test the linear-time implemeation of unique chars checker.
 */
public final class UniqueCharsLinearTest {

    /**
     * Ensures that UniqueCharsLinear cannot be instantiated.
     * @throws IllegalStateException This is the expected behaviour when
     *                               trying to invoke the constructor
     * @throws Throwable On test failure
     */
    @Test(expected = IllegalStateException.class)
    public void shouldNotConstruct() throws Throwable {
        PrivateConstructor constructor =
            new PrivateConstructor<UniqueCharsLinear>(UniqueCharsLinear.class);
        Assert.assertTrue(constructor.isPrivate());
        constructor.construct();
    }

    /**
     * Tests that a string with all unique characters is evaluated as
     * being unqiue.
     *
     * @throws AssertionError if unique() incorrectly
     *                        assesses a unique string
     */
    @Test
    public void shouldReturnTrueOnUniqueInputLinear() {
        Assert.assertTrue(UniqueCharsLinear.unique("123"));
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
        Assert.assertFalse(UniqueCharsLinear.unique("123123"));
    }
}

