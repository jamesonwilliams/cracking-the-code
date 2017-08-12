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

