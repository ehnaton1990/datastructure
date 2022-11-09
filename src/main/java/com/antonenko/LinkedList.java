package com.antonenko;

import java.util.Iterator;

public class LinkedList implements List {
    private Node tail;
    private Node head;
    private int size;


    @Override
    public void add(Object value) {

    }

    @Override
    public void add(Object value, int index) {
        //validation()
        Node newNode = new Node(value);

        if (size == 0) {
            head = tail = newNode;
        } else if (index == 0) {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        } else if (index == size) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {

        }
    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public Object set(Object value, int index) {
        return null;
    }

    @Override
    public boolean contains(Object value) {
        return false;
    }

    @Override
    public int indexOf(Object value) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object value) {
        return 0;
    }

    @Override
    public void clear() {
        for(Node current = head; current!=null; ){
            Node next = current.next;
            current.value = null;
            current.next = null;
            current.prev = null;
            current = next;
        }
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        Node temp = this.head;
        int count = 0;
        while (temp!=null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    private static class Node {
        private Node next;
        private Node prev;
        private Object value;

        public Node(Object value) {
            this.value = value;
        }
    }
}