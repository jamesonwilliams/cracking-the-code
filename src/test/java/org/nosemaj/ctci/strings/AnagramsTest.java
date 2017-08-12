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

package org.nosemaj.ctci.strings;

import org.nosemaj.ctci.PrivateConstructor;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests the Anagrams check methods.
 */
public final class AnagramsTest {

    /**
     * Ensures that Anagrams cannot be instantiated.
     * @throws IllegalStateException This is the expected behaviour when
     *                               trying to invoke the constructor
     * @throws Throwable On test failure
     */
    @Test(expected = IllegalStateException.class)
    public void shouldNotConstruct() throws Throwable {
        PrivateConstructor<Anagrams> constructor =
            new PrivateConstructor<>(Anagrams.class);
        Assert.assertTrue(constructor.isPrivate());
        constructor.construct();
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
        Assert.assertFalse(Anagrams.check("foo", "bar"));
    }

    /**
     * Valid anagrams should be evaluated as such.
     *
     * @throws AssertionError if check() cannot correctly identify
     *                        when two simple anagrams are actaully
     *                        anagrams
     */
    @Test
    public void shouldReturnTrueWhenInputsAreAnagrams() {
        Assert.assertTrue(Anagrams.check("goat", "toga"));
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

        boolean bothWaysWork = Anagrams.check(first, second)
            && Anagrams.check(second, first);

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
        Assert.assertTrue(Anagrams.check("togagoat", "goattoga"));
    }

    /**
     * A simple substring of another string is not an anagram.
     *
     * @throws AssertionError if a substring is incorrectly claimed to
     *                        be an anagram of a larger string
     */
    @Test
    public void shouldReturnFalseWhenStringAndSubstring() {
        Assert.assertFalse(Anagrams.check("boat", "a"));
    }
}
