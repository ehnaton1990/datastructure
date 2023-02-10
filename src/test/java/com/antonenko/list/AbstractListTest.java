package com.antonenko.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractListTest {
    private List list;

    @BeforeEach
    public void before() {
        list = getList();
    }

    protected abstract List getList();

    @Test
    public void testAdd() {
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("d");

        assertEquals(4, list.size());

        list.add("M");
        assertEquals(5, list.size());
    }

    @Test
    public void testAddToIndex() {

        //when
        list.add("A",0);
        list.add("B",1);
        list.add("C",2);
        assertEquals(3, list.size());

        //then
        list.add("Y", 1);
        assertEquals(4,list.size());

        assertEquals("A", list.get(0));
        assertEquals("Y", list.get(1));
        assertEquals("B", list.get(2));
        assertEquals("C", list.get(3));
    }

    @Test
    public void testFirstIndexOf() {
        list.add("A");
        list.add("c");
        list.add("c");
        list.add("A");
        list.add("M");

        assertEquals(-1, list.indexOf("E"));
        assertEquals(1, list.indexOf("c"));
        assertEquals(0, list.indexOf("A"));
    }

    @Test
    public void testLastIndexOf() {
        list.add("A");
        list.add("c");
        list.add("c");
        list.add("A");
        list.add("M");

        assertEquals(-1, list.lastIndexOf("E"));
        assertEquals(2, list.lastIndexOf("c"));
        assertEquals(3, list.lastIndexOf("A"));
    }

    @Test
    public void testSet() {
        list.add("A");
        list.add("b");
        list.add("c");

        list.set("L", 0);
        list.set("S", 0);
        list.set("Z", 1);
        list.set(200, 2);

        assertEquals("S", list.get(0));
        assertEquals("Z", list.get(1));
        assertEquals(200, list.get(2));
        assertEquals(-1, list.indexOf("E"));
    }

    @Test
    public void testGet() {
        list.add("A");
        list.add("b");
        list.add("C");
        list.add("d");

        assertEquals("A", list.get(0));
        assertEquals(-1, list.indexOf("E"));
    }

    @Test
    public void testAddValueToTheTopOfTheList() {
        //prepare
        list.add("A");
        list.add("B");
        list.add("C");
        assertEquals(3, list.size());
        assertEquals(0, list.indexOf("A"));

        //when
        list.add("M", 0);

        //then
        assertEquals(4, list.size());
        assertTrue(list.contains("M"));
        assertEquals(0, list.indexOf("M"));
        assertEquals(1, list.indexOf("A"));
        assertEquals(2, list.indexOf("B"));
        assertEquals(3, list.indexOf("C"));
    }

    @Test
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());

        list.add("R");
        assertFalse(list.isEmpty());
    }

    @Test
    public void testRemove() {
        //prepare
        list.add("a");
        list.add("B");
        list.add("c");
        assertEquals(3, list.size());

        //when
        list.remove(2);

        //then
        assertEquals(2, list.size());
        assertEquals(-1, list.indexOf("E"));
    }

    @Test
    public void testContains() {
        list.add("A");
        list.add("B");

        assertTrue(list.contains("A"));
        assertFalse(list.contains("Z"));
    }

    @Test
    public void testClear() {
        list.add("A");
        list.add("B");
        assertEquals(2, list.size());
        list.clear();

        assertEquals(0, list.size());
    }

    @Test
    public void testSize() {
        list.add("F");
        list.add("F");
        list.add("F");

        assertEquals(3, list.size());

    }

    @Test
    public void testToString() {
        assertEquals("[]", list.toString());
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        assertEquals("[A, B, C, D, E]", list.toString());
    }

    @Test
    void shouldThrowIndexOfBoundException() {
        //add
        assertThrows(IndexOutOfBoundsException.class, () -> list.add("A", -100));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add("A", 100));
        //remove
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(17));
        //set
        assertThrows(IndexOutOfBoundsException.class, () -> list.set("K", -125));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set("C", 197));
        //get
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-125));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(197));
    }

    @Test
    public void shouldThrowNullPointerExceptionWhenAddNullValue() {
        int index = 0;
        assertThrows(NullPointerException.class, () -> {
            list.add(null, index);
        });
    }

    @Test
    public void shouldThrowNullPointerExceptionWhenSetNullValue() {
        int index = 0;
        assertThrows(NullPointerException.class, () -> {
            list.set(null, index);
        });
    }

    @Test
    public void shouldThrowNullPointerExceptionWhenCheckIfContainsAndValueIsNull() {
        assertThrows(NullPointerException.class, () -> {
            list.contains(null);
        });
    }

    @Test
    public void shouldThrowNullPointerExceptionWhenGetIndexOfAndValueIsNull() {
        assertThrows(NullPointerException.class, () -> {
            list.indexOf(null);
        });
    }

    @Test
    public void shouldThrowNullPointerExceptionWhenGetLastIndexOfAndValueIsNull() {
        assertThrows(NullPointerException.class, () -> {
            list.lastIndexOf(null);
        });
    }
}
