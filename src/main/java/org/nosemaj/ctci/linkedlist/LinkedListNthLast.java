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
 * A linked list which can also find the nth to last item.
 * @param <T> The type of item in the list
 */
public final class LinkedListNthLast<T> extends LinkedListImpl<T> {

    /**
     * Finds the nth to last element in the list. As a corrolary, the
     * list must have at least one (the last) item to index against --
     * this method has no meaning on an empty list.
     *
     * @param fromLast The index from the last item (which is 0)
     *
     * @return The nth to last item in the list, 0 or greater
     * @throws NoSuchElementException if the requested distance refers
     *                                to a position that is out of
     *                                bounds of the list
     */
    public T findNthToLast(final int fromLast) throws NoSuchElementException {

        Node<T> trailing = getHead();
        Node<T> leading = getHead();

        // There are no elements "ahead of" the last
        if (fromLast < 0 || isEmpty()) {
            throw new NoSuchElementException();
        }

        /*
         * Create a distance between the leading and trailing pointers
         * that is equal to the desired fromLast value. If we hit the
         * end of the list before creating the desired separation, there
         * is no such element to satisfy the request.
         */
        for (int separation = 0; separation < fromLast; separation++) {
            leading = leading.getNext();
            if (leading == null) {
                throw new NoSuchElementException();
            }
        }

        while (leading.getNext() != null) {
            leading = leading.getNext();
            trailing = trailing.getNext();
        }

        return trailing.getData();
    }
}
