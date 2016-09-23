package com.company._10Tuple;

public class TupleImpl<T,E> implements Tuple<T,E> {
    private T key;
    private E value;

    public TupleImpl() {

    }
    @Override
    public void put(T key,E value){
        this.setKey(key);
        this.setValue(value);
    }

   private void setKey(T key){
        this.key = key;
    }

    private void setValue(E value){
        this.value = value;
    }

    @Override
    public T getKey() {
        return this.key;
    }

    @Override
    public E getValue() {
        return this.value;
    }
}
