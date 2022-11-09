package com.antonenko;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    ArrayList list = new ArrayList();

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
