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
 * Tests the ability to remove an item from the middle of a list.
 */
public final class LinkedListRemoveMiddleNodeTest {

    /**
     * Request to remove an item at a valid position should work find.
     *
     * @throws AssertionError if happy path is broken
     */
    @Test
    public void shouldRemoveFromMiddleWhenValidPosition() {
        LinkedListRemoveMiddleNode<Integer> list =
            new LinkedListRemoveMiddleNode<>();
        list.append(4);
        list.append(5);
        list.append(6);

        list.removeMiddlePosition(1);

        Assert.assertEquals(2, list.size());
        Assert.assertEquals(4, list.get(0).intValue());
        Assert.assertEquals(6, list.get(1).intValue());
    }

    /**
     * An attempt to remove the final element from a list should result
     * in an exception.
     *
     * @throws IllegalArgumentException expected outcome
     */
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalStateRequestPositionAtEnd() {
        LinkedListRemoveMiddleNode<Integer> list =
            new LinkedListRemoveMiddleNode<>();
        list.append(4);

        list.removeMiddlePosition(0);
    }

    /**
     * An attempt to remove an item by position when the position is out
     * of bounds of the list should result in an exception.
     *
     * @throws NoSuchElementException this is the expected outcome
     */
    @Test(expected = NoSuchElementException.class)
    public void shouldThrowNoSuchElementIfOutOfBounds() {
        LinkedListRemoveMiddleNode<Integer> list =
            new LinkedListRemoveMiddleNode<>();

        list.append(4);
        list.append(7);

        list.removeMiddlePosition(2); // Out of bounds
    }
}
