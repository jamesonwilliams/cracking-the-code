package org.nosemaj.ctci;

import java.util.NoSuchElementException;

/**
 * An implementation of a linked list.
 */
public final class LinkedListImpl<T> implements LinkedList<T> {

    private Node<T> head;

    @Override
    public void append(T value) {
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
    public T get(int position) {
        return getNodeAtPosition(position).getData();
    }

    /**
     * Gets the node at a given position.
     * @param position The node's position in the list
     * @throws NoSuchElementExcption if there is no node at position
     */
    private Node<T> getNodeAtPosition(int position) {
        Node<T> node = head;
        for (int index = 0; index < position; index++) {
            if (node == null) {
                throw new NoSuchElementException();
            }

            node = node.getNext();
        }

        if (node == null) {
            throw new NoSuchElementException();
        }

        return node;
    }

    @Override
    public void set(int position, T value) {
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

    /**
     * A node in a linked list.
     */
    public static final class Node<T> {

        private Node<T> next;
        private T data;

        /**
         * Constructs a new instance of a linked list node.
         * @param data The data associated with this node
         */
        public Node(T data) {
            this(data, null);
        }

        /**
         * Constructs a new instance of a linked list node.
         * @param data The data associated with this node
         * @param next The next node after this one
         */
        public Node(T data, Node<T> next) {
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
        public void setData(T data) {
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
        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
