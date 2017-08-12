package org.nosemaj.ctci.linkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;
import java.util.NoSuchElementException;

/**
 * Tests the implementation of a Linked List.
 */
public final class LinkedListImplTest {

    /**
     * Random number generator.
     */
    private Random random;

    /**
     * Initalize the random number generator.
     */
    @Before
    public void setup() {
        random = new Random();
    }

    /**
     * Appending a null item to the list should be accetpable; the list
     * size should increase by 1.
     *
     * @throws AssertionError if null was not successfully added to list
     */
    @Test
    public void shouldAppendNull() {
        LinkedList<Integer> list = new LinkedListImpl<>();
        list.append(null);
        Assert.assertEquals(1, list.size());
        Assert.assertNull(list.get(0));
    }

    /**
     * Appending a single item to the list should result in a list of
     * size one -- the first element being the item that was appeneded.
     *
     * @throws AssertionError if a single item cannot be added to an
     *                        empty list
     */
    @Test
    public void shouldAppendValidNodeToEmptyList() {
        LinkedList<Integer> list = new LinkedListImpl<>();
        Integer value = random.nextInt();
        list.append(value);
        Assert.assertEquals(1, list.size());
        Assert.assertEquals(value, list.get(0));
    }

    /**
     * Tests the construction of a list with several items; they should
     * be found in the order in which they were appened, and the list
     * should have the correct size at each step.
     *
     * @throws AssertionError if basic construction of a simple list of
     *                        some items fails
     */
    @Test
    public void shouldConstructMultipleItemList() {
        LinkedList<Integer> list = new LinkedListImpl<>();

        Integer[] values = {
            random.nextInt(),
            random.nextInt(),
            random.nextInt()
        };

        // Add some values and watch the list size increase
        for (int index = 0; index < values.length; index++) {
            list.append(values[index]);
            Assert.assertEquals(index + 1, list.size());
        }

        // Ensure the values are present and in the correct order
        for (int index = 0; index < values.length; index++) {
            Assert.assertEquals(values[index], list.get(index));
        }
    }

    /**
     * An attempt to access a position in the list where there is no
     * item should result in an {@link NoSuchElementException}.
     *
     * @throws NoSuchElementException This is the expected result of
     *                                this test
     */
    @Test(expected = NoSuchElementException.class)
    public void shouldNotGetNonExistantElement() {
        LinkedList<Object> list = new LinkedListImpl<>();
        list.get(10);
    }

    /**
     * An attempt to access a position in the list where there is no
     * item should result in an {@link NoSuchElementException}.
     *
     * @throws NoSuchElementException This is the expected result of
     *                                this test
     */
    @Test(expected = NoSuchElementException.class)
    public void shouldNotSetNonExistantElement() {
        LinkedList<Object> list = new LinkedListImpl<>();
        list.set(4, new Object());
    }

    /**
     * Ensures that it is possible to set the value at given position in
     * a list.
     *
     * @throws AssertionError if the value at the requested position has
     *                        not been set correctly
     */
    @Test
    public void shouldSetValueInValidPosition() {
        LinkedList<Integer> list = new LinkedListImpl<>();
        Integer original = random.nextInt();
        list.append(original);
        Integer replacement = random.nextInt();
        list.set(0, replacement);
        Assert.assertEquals(replacement, list.get(0));
    }

}
