package com.antonenko;

public class LinkedList implements List {
    private Node tail;
    private Node head;

    private Node reference;
    private int size;

    public LinkedList() {
        this.reference = reference;
    }

    @Override
    public void add(Object value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    @Override
    public void add(Object value, int index) {
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
        checkIndex(index);
        Object result = reference.next.value;
        reference.prev.next = reference.next;
        reference.next.prev = reference.prev;
        size--;
        return result;
    }

    @Override
    public Object get(int index) {
        checkIndex(index);
        return reference.value;
    }

    @Override
    public Object set(Object value, int index) {
        checkIndex(index);
        int current = 0;
        Node tempNode = head;
        while (current < index) {
            tempNode = tempNode.getmNextNode();
            current++;
        }
        Object previousElement = tempNode.getmNextNode();
        tempNode.setmElement();

        return previousElement;
    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value) >= 0;
    }

    @Override
    public int indexOf(Object value) {
        int index = 0;
        Node current = head.next;
        while (current != null) {
            if (current.equals(value)) {
                return index;
            }
            index++;
            current = current.next;
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
        for (Node current = head; current != null; ) {
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
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(" Index " + index + " must be between 0 and " + size);
        }
    }

    private void check(Object value) {
        if (value == null) {
            throw new NullPointerException();
        }
    }

    private static class Node<Object> {
        private Node next;
        private Node prev;
        private Object value;

        public Node(Object value) {
            this.value = value;
        }

        public Node<Object> getmNextNode() {
            return this.getmNextNode();
        }

        public Node<Object> setmElement() {
            return this.setmElement();
        }
    }
}