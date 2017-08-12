package org.nosemaj.ctci;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests the Strings string check methods.
 */
public final class StringsTest {

    @Test(expected = IllegalStateException.class)
    public void testConstructorIsPrivate() throws Throwable {
        PrivateConstructor constructor = new PrivateConstructor<Strings>(Strings.class);
        Assert.assertTrue(constructor.isPrivate());
        constructor.construct();
    }

    @Test
    public void testAllCharsUniquePoly_UniqueInput_ReturnsTrue() {
        Assert.assertTrue(Strings.allCharsUniquePoly("abcd"));
    }

    @Test
    public void testAllCharsUniquePoly_RepeatInput_ReturnsFalse() {
        Assert.assertFalse(Strings.allCharsUniquePoly("aaaa"));
    }

    @Test
    public void testAllCharsUniqueLinear_UniqueInput_ReturnsTrue() {
        Assert.assertTrue(Strings.allCharsUniqueLinear("123"));
    }

    @Test
    public void testAllCharsUniqueLinear_RepeatInput_ReturnsFalse() {
        Assert.assertFalse(Strings.allCharsUniqueLinear("123123"));
    }

    @Test
    public void testAreAnagrams_DifferentStrings() {
        Assert.assertFalse(Strings.areAnagrams("foo", "bar"));
    }

    @Test
    public void testAreAnagrams_GoatToga() {
        Assert.assertTrue(Strings.areAnagrams("goat", "toga"));
    }

    @Test
    public void testAreAnagrams_TogaGoat() {
        Assert.assertTrue(Strings.areAnagrams("toga", "goat"));
    }

    @Test
    public void testAreAnagrams_Compounds() {
        Assert.assertTrue(Strings.areAnagrams("togagoat", "goattoga"));
    }

    @Test
    public void testAreAnagrams_SubString() {
        Assert.assertFalse(Strings.areAnagrams("boat", "a"));
    }
}
