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

    @Test
    public void testUrlEncodeSpaces_NoSpaces() {
        Assert.assertEquals("foobar", Strings.urlEncodeSpaces("foobar"));
    }

    @Test
    public void testUrlEncodeSpaces_ManySpaces() {
        String expected = "%20%20f%20o%20o%20ba%20%20r%20%20%20";
        String input = "  f o o ba  r   ";
        Assert.assertEquals(expected, Strings.urlEncodeSpaces(input));
    }

    @Test
    public void testUrlEncodeSpaces_OnlySpaces() {
        Assert.assertEquals("%20%20%20", Strings.urlEncodeSpaces("   "));
    }

    @Test
    public void testUrlEncodeSpaces_AlreadyEncoded() {
        Assert.assertEquals("%20foo%20bar", Strings.urlEncodeSpaces("%20foo%20bar"));
    }

    @Test
    public void testUrlEncodeSpaces_PartiallyEncoded() {
        Assert.assertEquals("%20foo%20bar%20%20", Strings.urlEncodeSpaces(" foo bar%20 "));
    }

    @Test
    public void testIsRotation_FooOof() {
        Assert.assertTrue(Strings.isRotation("foo", "oof"));
    }

    @Test
    public void testIsRotation_FooBar() {
        Assert.assertFalse(Strings.isRotation("foo", "bar"));
    }

    @Test
    public void testIsRotation_PortionInsideDouble() {
        Assert.assertFalse(Strings.isRotation("ofo", "foofoofoo"));
    }
}
