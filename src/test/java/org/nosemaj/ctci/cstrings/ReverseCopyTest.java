/*
 * Copyright 2017 nosemaj.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you
 * may not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package org.nosemaj.ctci.cstrings;

import org.nosemaj.ctci.PrivateConstructor;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test the ReverseCopy utility.
 */
public final class ReverseCopyTest {

    /**
     * Ensures that ReverseCopy cannot be instantiated.
     * @throws IllegalStateException This is the expected behaviour when
     *                               trying to invoke the constructor
     * @throws Throwable On test failure
     */
    @Test(expected = IllegalStateException.class)
    public void shouldNotConstruct() throws Throwable {
        PrivateConstructor<ReverseCopy> constructor =
            new PrivateConstructor<>(ReverseCopy.class);
        Assert.assertTrue(constructor.isPrivate());
        constructor.construct();
    }

    /**
     * Reversing null should return null.
     *
     * @throws AssertionError if something non-null comes back
     */
    @Test
    public void shouldReturnNullOnNullInputCopy() {
        Assert.assertNull(ReverseCopy.reverse(null));
    }

    /**
     * Reversing a palindrome should return the palindrome.
     *
     * @throws AssertionError if the reverse of a palindrome is not
     *                        returned as the palindrome itself
     */
    @Test
    public void shouldReturnPalindromeWhenGivenPalindromeCopy() {
        char[] palindrome = CString.from("fooBARRABoof");
        CString.assertEquals(palindrome, ReverseCopy.reverse(palindrome));
    }

    /**
     * Ensures that a simple string which is not a palindrome can be
     * succesfully reversed.
     *
     * @throws AssertionError if string reverse happy path is broken
     */
    @Test
    public void shouldReverseString() {
        char[] string = CString.from("asdf1234");
        char[] expected = CString.from("4321fdsa");
        CString.assertEquals(expected, ReverseCopy.reverse(string));
    }
}
