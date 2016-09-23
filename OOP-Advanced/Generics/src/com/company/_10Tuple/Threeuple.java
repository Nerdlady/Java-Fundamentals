package com.company._10Tuple;

public interface Threeuple<T,E,R> {
    T getKey();
    E getFirstValue();
    R getSecondValue();
    void put(T key,E firstValue,R secondValue);
}
