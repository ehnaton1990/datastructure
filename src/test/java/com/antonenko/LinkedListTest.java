package com.antonenko;

public class LinkedListTest extends AbstractListTest {
    @Override
    protected List getList() {
        return new LinkedList();
    }
}