package org.nosemaj.ctci;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;
import java.util.NoSuchElementException;

/**
 * Tests the implementation of a Linked List.
 */
public final class LinkedListImplTest {
    private Random random;

    @Before
    public void setup() {
        random = new Random();
    }

    @Test
    public void testAppend_Null() {
        LinkedList<Integer> list = new LinkedListImpl<>();
        list.append(null);
        Assert.assertEquals(1, list.size());
        Assert.assertNull(list.get(0));
    }

    @Test
    public void testAppend_ValidNode_FromEmptyList() {
        LinkedList<Integer> list = new LinkedListImpl<>();
        Integer value = random.nextInt();
        list.append(value);
        Assert.assertEquals(1, list.size());
        Assert.assertEquals(value, list.get(0));
    }

    @Test
    public void testAppend_ValidNode_ConstructList() {
        LinkedList<Integer> list = new LinkedListImpl<>();

        Integer[] values = { random.nextInt(), random.nextInt(), random.nextInt() };

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

    @Test(expected = NoSuchElementException.class)
    public void testGet_NonExistantElement() {
        LinkedList<Object> list = new LinkedListImpl<>();
        list.get(10);
    }

    @Test(expected = NoSuchElementException.class)
    public void testSet_NonExistantElement() {
        LinkedList<Object> list = new LinkedListImpl<>();
        list.set(4, new Object());
    }

    @Test(expected = NoSuchElementException.class)
    public void testSet_NonExistantElement_NonTrivialList() {
        LinkedList<Object> list = new LinkedListImpl<>();
        list.set(4, new Object());
    }

    @Test
    public void testSet_ValidPosition() {
        LinkedList<Integer> list = new LinkedListImpl<>();
        Integer original = random.nextInt();
        list.append(original);
        Integer replacement = random.nextInt();
        list.set(0, replacement);
        Assert.assertEquals(replacement, list.get(0));
    }

}
