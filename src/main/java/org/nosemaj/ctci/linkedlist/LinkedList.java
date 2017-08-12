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
}
