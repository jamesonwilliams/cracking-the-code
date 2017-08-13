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

import java.util.NoSuchElementException;

/**
 * A linked list which can remove a node by its reference.
 *
 * <p>Note: since {@link Node} won't be exposed to the user, we wrap
 * this method in {@link removeFromMiddle(int)}, which can be called
 * from outside code.
 *
 * @param <T> The type of item in the list
 */
public final class LinkedListRemoveMiddleNode<T> extends LinkedListImpl<T> {

    /**
     * Remove a node from the middle of a list.
     *
     * <p> This works (and in O(1) space and time) when the node the
     * final node -- in that case, this doesn't work at all.
     *
     * @param node Any interior node in a list
     * @throws IllegalArgumentException
     *         if the provided node has nothing after it (i.e. isn't in
     *         the middle of the list somewhere.)
     */
    private void removeMiddleNode(final Node<T> node)
            throws IllegalArgumentException {

        // Requested to delete a middle node, but the list has no middle
        if (node.getNext() == null) {
            throw new IllegalArgumentException();
        }

        // Copy the data from the next node
        node.setData(node.getNext().getData());

        // Delete the next node
        node.setNext(node.getNext().getNext());
    }

    /**
     * Removes any value from the list which is not in the final
     * position.
     *
     * @param position Any position in the list except the last.
     *
     * @throws IllegalArgumentException if position is the last position
     * @throws NoSuchElementException if position is not in list at all
     */
    public void removeMiddlePosition(final int position)
            throws IllegalArgumentException, NoSuchElementException {

        removeMiddleNode(getNodeAtPosition(position));
    }
}
