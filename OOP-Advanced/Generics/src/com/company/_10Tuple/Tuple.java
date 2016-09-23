package com.company._10Tuple;

public interface Tuple<T,E> {
    T getKey();
    E getValue();
    void put(T key,E value);
}
