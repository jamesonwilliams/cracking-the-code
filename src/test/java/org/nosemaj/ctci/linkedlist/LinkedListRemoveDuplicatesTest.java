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

package org.nosemaj.ctci.linkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test the extension of linked list which can remove duplicates.
 */
public final class LinkedListRemoveDuplicatesTest {

    /**
     * Test the happy path, where the list contains duplicates and they
     * are successfully removed. The resuling list will have the same
     * order as the first occurrences of the original items in the list.
     *
     * @Throws AssertionError if the order of the first unique
     *                        characters has changed or if not all
     *                        duplicates were removed
     */
    @Test
    public void shouldRemoveDuplicateEntries() {
        LinkedListRemoveDuplicates<Integer> list =
            new LinkedListRemoveDuplicates<>();
        list.append(1);
        list.append(1);
        list.append(5);
        list.append(1);
        list.append(4);
        list.append(5);
        list.append(5);

        list.removeDuplicates();

        Assert.assertEquals(3, list.size());
        assertEquals(1, list.get(0));
        assertEquals(5, list.get(1));
        assertEquals(4, list.get(2));
    }

    /**
     * An attempt to remove duplicates on an empty list should do
     * nothing.
     *
     * @throws AssertionError If the list is not empty after trying to
     *                        remove duplicates
     */
    @Test
    public void shouldNotEffectEmptyList() {
        LinkedListRemoveDuplicates<Integer> list =
            new LinkedListRemoveDuplicates<>();

        list.removeDuplicates();

        Assert.assertEquals(0, list.size());
    }

    /**
     * An attempt to remove duplicates on a list that has no duplicates
     * should not change the list at all.
     *
     * @throws AssertionError if a list with unique items is modified in
     *                        any way by trying to remove duplicates
     */
    @Test
    public void shouldNotEffectUniqueItemsList() {
        LinkedListRemoveDuplicates<Integer> list =
            new LinkedListRemoveDuplicates<>();
        list.append(1);
        list.append(10);
        list.append(4);
        list.append(3);

        list.removeDuplicates();

        Assert.assertEquals(4, list.size());
        assertEquals(1, list.get(0));
        assertEquals(10, list.get(1));
        assertEquals(4, list.get(2));
        assertEquals(3, list.get(3));
    }

    /**
     * The bufferless implementation of remove duplicates should
     * complete a happy path of removing duplicates from a list that
     * does contain them.
     *
     * @throws AssertionError if the implementation does not end with a
     *                        list containing the epxected number of
     *                        unique values in the correct order
     */
    @Test
    public void shouldRemoveDuplicatesNoBuffer() {

        LinkedListRemoveDuplicates<Integer> list =
            new LinkedListRemoveDuplicates<>();
        list.append(0);
        list.append(0);
        list.append(1);
        list.append(0);
        list.append(1);
        list.append(1);

        list.removeDuplicatesNoBuffer();

        Assert.assertEquals(2, list.size());
        assertEquals(0, list.get(0));
        assertEquals(1, list.get(1));
    }

    /**
     * The bufferless implementation of remove duplicates should
     * have no effect on a list that is empty.
     *
     * @throws AssertionError if calling remove duplicates on an empty
     *                        list results in something other than an
     *                        empty list
     */
    @Test
    public void shouldNotEffectEmptyListNoBuffer() {
        LinkedListRemoveDuplicates<Integer> list =
            new LinkedListRemoveDuplicates<>();

        list.removeDuplicatesNoBuffer();

        Assert.assertEquals(0, list.size());
    }

    /**
     * The bufferless implementation of remove duplicates should have no
     * effect on a list which already contains only unique values.
     *
     * @throws AssertionError if calling remove duplicates on a list of
     *                        unqiue items modifies that list in any way
     */
    @Test
    public void shouldNotEffectUniqueItemsListNoBuffer() {
        LinkedListRemoveDuplicates<Integer> list =
            new LinkedListRemoveDuplicates<>();

        list.append(5);
        list.append(-45);
        list.append(9);

        list.removeDuplicatesNoBuffer();

        Assert.assertEquals(3, list.size());
        assertEquals(5, list.get(0));
        assertEquals(-45, list.get(1));
        assertEquals(9, list.get(2));
    }

    /**
     * Utility method to convert an actual Integer class to an int
     * primitive prior to passing to JUnit.
     *
     * @param expected expected native int
     * @param actual Obtained Integer class representation
     *
     * @throws AssertionError if the native int value of actual is not
     *                        the same as the expected native int
     */
    private void assertEquals(final int expected, final Integer actual) {
        Assert.assertEquals(expected, actual.intValue());
    }
}
