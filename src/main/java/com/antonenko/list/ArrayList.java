package com.antonenko.list;

import java.util.StringJoiner;

public class ArrayList implements List {
    private static final int DEFAULT_CAPACITY = 10;
    private static Object[] array;
    private int size;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int CAPACITY) {

        array = new Object[CAPACITY];
    }

    @Override
    public void add(Object value) {
        if (size == array.length) {
            Object[] newArray = new Object[DEFAULT_CAPACITY * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[size] = value;
        size++;
    }

    @Override
    public void add(Object value, int index) {
        validation(index);
        check(value);
        growArray();
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = value;
        size++;
    }

    @Override
    public Object remove(int index) {
        validation(index);
        for (int i = 0; i < array.length - 1; i++) {
            if (i == index) {
                array[index] = array[i + 1];
                for (int j = index; j < size; j++) {
                    array[j] = array[j + 1];
                }
            }
        }
        size--;
        return array;
    }

    @Override
    public Object get(int index) {
        validation(index);
        Object value = array[index];
        return value;
    }

    @Override
    public Object set(Object value, int index) {
        validation(index);
        check(value);
        Object oldValue = array[index];
        array[index] = value;
        return oldValue;
    }

    @Override
    public void clear() {
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
    public boolean contains(Object value) {
        check(value);
        for (int i = 0; i < size; i++) {
            if (value.equals(array[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object value) {
        check(value);
        for (int i = 0; i < size; i++)
            if (value.equals(array[i])) {
                return i;
            }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        check(value);
        for (int i = size - 1; i > 0; i--)
            if (value.equals(array[i])) return i;
        return -1;
    }

    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (Object value : array) {
            if (value != null) {
                joiner.add(String.valueOf(value));
            }
        }
        return joiner.toString();
    }

    private void validation(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(" Index " + index + " must be between 0 and " + size);
        }
    }

    private void check(Object value) {
        if (value == null) {
            throw new NullPointerException("Value can't be null");
        }
    }

    private void growArray() {
        if (array.length == size) {
            Object[] newArray = new Object[size * 2 + 1];
            System.arraycopy(array, 0, array, 0, array.length);
            array = newArray;
        }
    }
}

