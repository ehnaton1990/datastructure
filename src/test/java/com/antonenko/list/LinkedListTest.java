package com.antonenko.list;

public class LinkedListTest extends AbstractListTest {
    @Override
    protected List getList() {
        return new LinkedList();
    }
}