package com.antonenko.list;

import java.util.Objects;
import java.util.StringJoiner;

public class LinkedList implements List {
    private Node tail;
    private Node head;
    private int size;

    @Override
    public void add(Object value) {
        add(value, size);
    }

    @Override
    public void add(Object value, int index) {
        check(value);
        //checkIndex(index);
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
            Node node = getNode(index);
            newNode.prev = node.prev;
            node.prev.next = node;
        }
        size++;
    }

    @Override
    public Object remove(int index) {
        //checkIndex(index);
        getNode(index);
        Node current = getNode(index);
        removeNode(current);
        return current.value;
    }

    private void removeNode(Node node) {
        if (size == 1) {
            head = tail = null;
        } else if (node == head) {
            head.prev = null;
            head = node.next;
        } else if (node == tail) {
            tail = node.prev;
            tail.next = null;
        } else {
            Node prevNode = node.prev;
            Node nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }
        size--;
    }

    @Override
    public Object get(int index) {
        //checkIndex(index);
        return getNode(index).value;
    }

    @Override
    public Object set(Object value, int index) {
        check(value);
        //checkIndex(index);
        Node current = getNode(index);
        Object oldValue = current.value;
        current.value = value;
        return oldValue;
    }

    @Override
    public boolean contains(Object value) {
        check(value);
        boolean isTrue;
        if (!(this.indexOf(value) == -1)) {
            isTrue = true;
        } else {
            isTrue = false;
        }
        return isTrue;
    }

    @Override
    public int indexOf(Object value) {
        check(value);
        Node nextNode = head;
        for (int index = 0; index < size; index++) {
            if (Objects.equals(nextNode.value, value)) {
                return index;
            }
            nextNode = nextNode.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        check(value);
        return (int) this.tail.value;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString(){
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        Node current = head;
        while (current!=null){
            stringJoiner.add(current.value.toString());
            current = current.next;
        }
        return stringJoiner.toString();
    }

    //private void checkIndex(int index) {
    //  if (index < 0 || index > size - 1) {
    //      throw new IndexOutOfBoundsException("Index " + index + " must between 0 to " + (size - 1));
    //   }
    // }

    private void check(Object value) {
        if (value == null) {
            throw new NullPointerException();
        }
    }

    private Node getNode(int index) {
        Node current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    private static class Node<Object> {
        private Node next;
        private Node prev;
        private Node element;
        private Object value;

        public Node(Object value) {
            this.value = value;
        }


        public Node(java.lang.Object value, Node next) {
        }
    }
}