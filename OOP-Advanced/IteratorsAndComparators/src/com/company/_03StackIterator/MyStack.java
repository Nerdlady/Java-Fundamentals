package com.company._03StackIterator;

public interface MyStack extends Iterable<Integer> {
    void push(Integer... elements);
    void pop();
}
