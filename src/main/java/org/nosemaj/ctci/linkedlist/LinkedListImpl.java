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
 * An implementation of a linked list.
 * @param <T> The type of element in the list
 */
public class LinkedListImpl<T> implements LinkedList<T> {

    /**
     * Reference to the first node in the list.
     */
    private Node<T> head;

    @Override
    public void append(final T value) {
        Node<T> node = new Node<>(value);

        if (head == null) {
            head = node;
            return;
        }

        Node<T> last = head;
        while (last.getNext() != null) {
            last = last.getNext();
        }

        last.setNext(node);
    }

    @Override
    public T get(final int position) {
        return getNodeAtPosition(position).getData();
    }

    /**
     * Gets a reference to the list head.
     * @return A reference to the list head
     */
    protected Node<T> getHead() {
        return this.head;
    }

    /**
     * Gets the node at a given position.
     *
     * @param position The node's position in the list
     *
     * @return The node at the requested position, if it exists
     * @throws NoSuchElementExcption if there is no node at position
     */
    protected Node<T> getNodeAtPosition(final int position) {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Node<T> node = head;

        for (int index = 0; index < position; index++) {
            node = node.getNext();

            if (node == null) {
                throw new NoSuchElementException();
            }
        }

        return node;
    }

    @Override
    public void set(final int position, final T value) {
        getNodeAtPosition(position).setData(value);
    }

    @Override
    public int size() {
        Node<T> node = head;
        int count = 0;

        while (node != null) {
            count++;
            node = node.getNext();
        }

        return count;
    }

    @Override
    public String toString() {
        Node<T> node = getHead();
        StringBuilder builder = new StringBuilder();
        int position = 0;

        while (node != null) {
            builder.append(String.format("[%d]%s%n", position, node));
            position++;
            node = node.getNext();
        }

        return builder.toString();
    }

    /**
     * A node in a linked list.
     * @param <T> The type of data in the node
     */
    public static final class Node<T> {

        /**
         * The node that follows this.
         */
        private Node<T> next;

        /**
         * The data in this node.
         */
        private T data;

        /**
         * Constructs a new instance of a linked list node.
         * @param data The data associated with this node
         */
        public Node(final T data) {
            this(data, null);
        }

        /**
         * Constructs a new instance of a linked list node.
         * @param data The data associated with this node
         * @param next The next node after this one
         */
        public Node(final T data, final Node<T> next) {
            this.data = data;
            this.next = next;
        }

        /**
         * Gets the node's data.
         * @return The data inside the node
         */
        public T getData() {
            return data;
        }

        /**
         * Sets the node's data.
         * @param data The data to set in the node
         */
        public void setData(final T data) {
            this.data = data;
        }

        /**
         * Gets the next node.
         * @return The node after the current one, possibly null
         */
        public Node<T> getNext() {
            return next;
        }

        /**
         * Sets the next node.
         * @param next The node that follows this one.
         */
        public void setNext(final Node<T> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            String nextText = null;
            if (next != null) {
                nextText = String.valueOf(next.hashCode());
            }

            return String.format("[%s,%s]-->%s",
                String.valueOf(this.hashCode()), data, nextText);
        }
    }

    @Override
    public boolean isEmpty() {
        return getHead() == null;
    }
}
