package com.antonenko;

public class ArrayList implements List {
    //«Публичный класс Elements реализует интерфейс main.java.List».
    private static final int DEFAULT_CAPACITY = 16;
    private static Object[] array = new Object[DEFAULT_CAPACITY];
    private int size;

    public ArrayList(int size) {
        this.size = size;
    }

    public ArrayList() {

    }
    public void array(int CAPACITY) {
        array = new Object[CAPACITY];
    }

    @Override
    public void add(Object value) {
        check(value);
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
        // if we need require extend array
        growArray();
        if (index < size) {
            System.arraycopy(array, index, array, index + 1, size - index);
        }
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
    public Object get(int index) { //приходить індекс, найти в масиві індекс, після чого індекс треба повернути
        validation(index);
        Object value = array[index];
        return value;
    }

    @Override
    public Object set(Object value, int index) { //реалізувати валідацію (index не може бути менше 0), вставити елемент в існуючий index
        validation(index);
        check(value);
        Object oldValue = array[index];// наш метод get
        array[index] = value; // в існуючий елемент закинули нове значення.
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
    public boolean isEmpty() { //перевіряє чи є масив порожнім
        return size == 0;
    }

    @Override
    public boolean contains(Object value) { //шукає однакові елементи
        check(value);
        for (int i = 0; i < size; i++) {
            if (value.equals(array[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object value) { //виводить індекс елемента при першому входженні в масив
        check(value);
        for (int i = 0; i < size; i++)
            if (value.equals(array[i])) {
                return i;
            }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) { // повертає індекс останнього входження зазначеного елемента в масиві
        check(value);
        for (int i = size - 1; i > 0; i--)
            if (value.equals(array[i])) return i;
        return -1;
    }

    public String toString() {
        String result = "[";
        for (int i = 0; i < size; i++) {
            result += array[i];
            if (i < size -1){
                result += ", ";
            }
        }
        result += "]";
        return result;
    }

    private void validation(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(" Index " + index + " must be between 0 and " + size);
        }
    }
    private void check(Object value){
        if(value == null){
            throw new NullPointerException();
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

