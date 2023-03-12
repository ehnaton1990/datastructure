package com.antonenko.list;

public interface HashMap {
    Object put(Object key, Object value);

    Object remove(Object key);

    Object get(Object key);

    boolean containsKey(Object key);

    int size();

    boolean isEmpty();
}
