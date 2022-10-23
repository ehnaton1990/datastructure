package com.antonenko;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {
    ArrayList list = new ArrayList();

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
    }

    @Test
    public void testRemove() {
        //prepare
        list.add("a");
        list.add("B");
        list.add("c");
        assertEquals(3, list.size());

        //when
        assertEquals(0, list.remove(2));

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
}