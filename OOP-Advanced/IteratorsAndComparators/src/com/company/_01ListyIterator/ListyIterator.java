package com.company._01ListyIterator;

public interface ListyIterator<T> extends Iterable<T>{
    boolean move();
    boolean hasNext();
    void print();
    void printAll();
}
