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
 * A linked list is an ordered collection of elements, each containing a
 * link to its successor.
 * @param <T> The type of the values in the list
 */
public interface LinkedList<T> {

    /**
     * Appends a value to the end of the linked list.
     *
     * @param value The value to append to the list
     */
    void append(T value);

    /**
     * Gets the size of the list.
     *
     * @return The size of the list
     */
    int size();

    /**
     * Gets the value at a given position in the linked list.
     *
     * @param position The position in the list, from head
     *
     * @return The element at the requested position, if it exists
     * @throws NoSuchElementException if there is no value at position
     */
    T get(int position) throws NoSuchElementException;

    /**
     * Sets the value at the given position to a value.
     *
     * @param position The position in the list
     * @param value The value to set at that position
     *
     * @throws NoSuchElementException if there is no item at position
     */
    void set(int position, T value) throws NoSuchElementException;

    /**
     * Determines if the list contains no elements.
     *
     * @return true if the list is empty; false, otherwise
     */
    boolean isEmpty();
}
