package com.company._10Tuple;

public class ThreeupleImpl<T,E,R> implements Threeuple<T,E,R> {
    private T key;
    private E valueOne;
    private R valueTwo;

    public ThreeupleImpl() {
    }

    private void setKey(T key) {
        this.key = key;
    }

    private void setValueOne(E valueOne) {
        this.valueOne = valueOne;
    }

    private void setValueTwo(R valueTwo) {
        this.valueTwo = valueTwo;
    }

    @Override
    public T getKey() {
        return this.key;
    }

    @Override
    public E getFirstValue() {
        return this.valueOne;
    }

    @Override
    public R getSecondValue() {
        return this.valueTwo;
    }

    @Override
    public void put(T key, E firstValue, R secondValue) {
        this.setKey(key);
        this.setValueOne(firstValue);
        this.setValueTwo(secondValue);
    }
}
