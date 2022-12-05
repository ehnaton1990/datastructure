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
        setReference(index);
        Node<Object> temp = new Node<Object>(value, reference, reference.prev);
        temp.prev.next = temp;
        size++;
    }

    @Override
    public Object remove(int index) {
        //checkIndex(index);
        Node current = head;
        if (index == 0) {
            size--;
            head = current.next;
            return current.element;
        }
        Node temp = null;
        for (int i = 0; i < index; i++) {
            temp = current;
            current = current.next;
        }
        temp.next = current.next;
        size--;
        return current.element;
    }

    @Override
    public Object get(int index) {
        setReference(index);
        return reference.value;
    }

    @Override
    public Object set(Object value, int index) {
        //checkIndex(index);
        setReference(index);
        Object result = reference.value;
        reference.value = value;
        return result;
    }

    @Override
    public boolean contains(Object value) {
        boolean isTrue;
        if(!(this.indexOf(value) == -1)){
            isTrue = true;
        }else {
            isTrue = false;
        }
        return isTrue;
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
            throw new IndexOutOfBoundsException("List index out of bounds");
        }
    }

    private void check(Object value) {
        if (value == null) {
            throw new NullPointerException();
        }
    }

    private void setReference(int index) {
        reference = head;
        for (int i = 0; i < index; i++) {
            reference = reference.next;
        }
    }

    private static class Node<Object> {
        private Node next;
        private Node prev;
        private Node element;
        private Object value;
        private Object mElement;
        private Node<Object> mNextNode;

        public Node(Object value) {
            this.value = value;
        }

        public Node(Object value, Object reference, Object prev) {
        }

        public Node<Object> getmNextNode() {
            return this.mNextNode;
        }

        public void setmElement(Object value) {
            this.mElement = value;
        }
    }
}