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

import java.util.HashSet;
import java.util.Set;

/**
 * A linked list which can remove duplicates.
 * @param <T> The type of item in the list
 */
public final class LinkedListRemoveDuplicates<T> extends LinkedListImpl<T> {

    /**
     * Removes dupilcate items from the list.
     */
    public void removeDuplicates() {
        Set<T> seenData = new HashSet<>();
        Node<T> node = getHead();

        while (node != null) {
            // Record the value for this node
            seenData.add(node.getData());

            // If there are no more nodes, we're done
            if (node.getNext() == null) {
                return;
            }

            if (seenData.contains(node.getNext().getData())) {
                // If the next node has a seen value, chomp it.
                node.setNext(node.getNext().getNext());
            } else {
                // Otherwise, advance the current node pointer
                node = node.getNext();
            }
        }
    }

    /**
     * Removes duplicates from the list, but without using a buffer.
     */
    public void removeDuplicatesNoBuffer() {
        Node<T> trailing = getHead();
        Node<T> leading;

        while (trailing != null) {
            leading = trailing;

            while (leading.getNext() != null) {
                if (leading.getNext().getData().equals(trailing.getData())) {
                    leading.setNext(leading.getNext().getNext());
                } else {
                    leading = leading.getNext();
                }
            }

            trailing = trailing.getNext();
        }
    }
}
