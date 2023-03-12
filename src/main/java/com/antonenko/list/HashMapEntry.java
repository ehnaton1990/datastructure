package com.antonenko.list;

class HashMapEntry {
    public Object key;
    public Object value;

    public HashMapEntry(Object key, Object value) {
        this.key = key;
        this.value = value;
    }
}

class SimpleHashMap implements HashMap {
    private final HashMapEntry[] items;
    private int noOfItems;

    public SimpleHashMap(int size) {
        this.items = new HashMapEntry[size];
        this.noOfItems = 0;
    }

    private int hash(Object key) {
        return Math.abs(key.hashCode());
    }

    @Override
    public Object put(Object key, Object value) {
        return null;
    }

    @Override
    public Object remove(Object key) {
        int index = hash(key) % items.length;
        HashMapEntry entry = items[index];
        if(items[index] != null)
            noOfItems -= 1;
        items[index] = null;
        return entry;
    }

    @Override
    public Object get(Object key) {
        int index = hash(key) % items.length;
        HashMapEntry entry = items[index];
        if(entry == null)
            return null;
        if(!entry.key.equals(key))
            return null;
        return entry.value;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public int size() {
        return noOfItems;
    }

    @Override
    public boolean isEmpty() {
        return (noOfItems == 0);
    }
}


