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
 * Test the OneWay utility.
 */
public final class OneWayTest {

    /**
     * Ensures that OneWay cannot be instantiated.
     * @throws IllegalStateException This is the expected behaviour when
     *                               trying to invoke the constructor
     * @throws Throwable On test failure
     */
    @Test(expected = IllegalStateException.class)
    public void shouldNotConstruct() throws Throwable {
        PrivateConstructor<OneWay> constructor =
            new PrivateConstructor<>(OneWay.class);
        Assert.assertTrue(constructor.isPrivate());
        constructor.construct();
    }

    /**
     * "pale" becomes "ple" by removing an 'a'.
     *
     * @throws AssertionError if remove not accounted for
     */
    @Test
    public void shouldReturnTrueForPaleAndPle() {
        Assert.assertTrue(OneWay.areOneOperationApart("pale", "ple"));
    }

    /**
     * "pales" becomes "pale" by removing an 's'.
     *
     * @throws AssertionError if remove last not accounted for
     */
    @Test
    public void shouldReturnTrueForPalesAndPale() {
        Assert.assertTrue(OneWay.areOneOperationApart("pales", "pale"));
    }

    /**
     * "pale" becomes "bale" by replacing 'p' with 'b'.
     *
     * @throws AssertionError if replace not accounted for
     */
    @Test
    public void shouldReturnTrueForPaleAndBale() {
        Assert.assertTrue(OneWay.areOneOperationApart("pale", "bale"));
    }

    /**
     * "pale" becomes "bake" by replacing **two** letters.
     *
     * @throws AssertionError if double replacement wrongly allowed
     */
    @Test
    public void shouldReturnFalseForPaleAndBake() {
        Assert.assertFalse(OneWay.areOneOperationApart("pale", "bake"));
    }

    /**
     * "foo" can be made into "foo" by replacing any letter with itself.
     *
     * @throws AssertionError if implementation incorrectly handles the
     *                        case where the strings are the same.
     */
    @Test
    public void shouldReturnTrueForSameStrings() {
        Assert.assertTrue(OneWay.areOneOperationApart("foo", "foo"));
    }

    /**
     * "Gray box" test for strings with duplicate characters.
     *
     * @throws AssertionError if strings with repeated characters break
     *                        implementation
     */
    @Test
    public void shouldReturnTrueForStringsWithDuplicates() {
        Assert.assertTrue(OneWay.areOneOperationApart("aaaaaBBcD", "aaaaBBcD"));
    }

    /**
     * "Gray box" test for dissimilar strings with duplicates.
     *
     * @throws AssertionError if dissimilar strings with duplicates are
     *                        evaluated as one operation apart.
     */
    @Test
    public void shouldReturnFalseForDissimilarStringsWithDuplicates() {
        Assert.assertFalse(OneWay.areOneOperationApart("aaaaaaaB", "aB"));
    }

    /**
     * Branch coverage for range check.
     */
    @Test
    public void shouldReturnTrueInsertInMiddle() {
        Assert.assertTrue(OneWay.areOneOperationApart("aaab", "aaaa"));
    }
}

