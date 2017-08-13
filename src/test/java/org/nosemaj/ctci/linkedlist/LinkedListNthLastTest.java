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

import java.util.NoSuchElementException;

/**
 * Tests the method which finds the value n position back from the last
 * element in a list.
 */
public final class LinkedListNthLastTest {

    /**
     * An empty list has no elements, so there is way to index against a
     * non-existant "last" element -- should throw exception.
     *
     * @throws NoSuchElementException This is the expected outcome
     */
    @Test(expected = NoSuchElementException.class)
    public void shouldThrowNoSuchElementOnEmptyList() {
        LinkedListNthLast<Integer> list = new LinkedListNthLast<>();
        list.findNthToLast(0);
    }

    /**
     * Requesting an index that is larger than the list size - 1 would
     * index out of the list -- there is no such element.
     *
     * @throws NoSuchElementException this is the expected outcome
     */
    @Test(expected = NoSuchElementException.class)
    public void shouldThrowNoSuchElementTooFarBack() {
        LinkedListNthLast<Integer> list = new LinkedListNthLast<>();
        list.append(4);
        list.append(6);

        list.findNthToLast(2);
    }

    /**
     * Requesting an element that is within range of an existing list of
     * sufficient size (the happy path) should return the value at the
     * correct position from the last.
     *
     * @throws AssertionError if the happy path is broken
     */
    @Test
    public void shouldFindCorrectValueIndexInRange() {
        LinkedListNthLast<Integer> list = new LinkedListNthLast<>();
        list.append(55);
        list.append(-1);
        list.append(5);
        list.append(8);
        list.append(10);

        Assert.assertEquals(5, list.findNthToLast(2).intValue());
    }

    /**
     * It is valid to find the 0th from the last, which is simply the
     * last. Requesting this of a singleton list returns the single
     * item.
     *
     * @throws AssertionError if indexing of 0 on a singleton list is
     *                        broken
     */
    @Test
    public void shouldReturnSingleElementSingletonList() {
        LinkedListNthLast<Integer> list = new LinkedListNthLast<>();
        list.append(6);
        Assert.assertEquals(6, list.findNthToLast(0).intValue());
    }

    /**
     * There must be no element which is ahead of the last element;
     * passing a negative value to findNthToLast has no meaning.
     *
     * @throws NoSuchElementException This is the expected behaviour
     */
    @Test(expected = NoSuchElementException.class)
    public void shouldThrowNoSuchElementNegativeIndex() {
        LinkedListNthLast<Integer> list = new LinkedListNthLast<>();
        list.append(5);
        list.findNthToLast(-1);
    }
}
