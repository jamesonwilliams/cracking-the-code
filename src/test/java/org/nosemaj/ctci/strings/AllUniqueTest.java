package org.nosemaj.ctci.strings;

import org.nosemaj.ctci.PrivateConstructor;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests the AllUnique string check methods.
 */
public final class AllUniqueTest {

    @Test(expected = IllegalStateException.class)
    public void testConstructorIsPrivate() throws Throwable {
        PrivateConstructor constructor = new PrivateConstructor<AllUnique>(AllUnique.class);
        Assert.assertTrue(constructor.isPrivate());
        constructor.construct();
    }

    @Test
    public void testAllCharsUniquePoly_UniqueInput_ReturnsTrue() {
        Assert.assertTrue(AllUnique.allCharsUniquePoly("abcd"));
    }

    @Test
    public void testAllCharsUniquePoly_RepeatInput_ReturnsFalse() {
        Assert.assertFalse(AllUnique.allCharsUniquePoly("aaaa"));
    }

    @Test
    public void testAllCharsUniqueLinear_UniqueInput_ReturnsTrue() {
        Assert.assertTrue(AllUnique.allCharsUniqueLinear("123"));
    }

    @Test
    public void testAllCharsUniqueLinear_RepeatInput_ReturnsFalse() {
        Assert.assertFalse(AllUnique.allCharsUniqueLinear("123123"));
    }
}
