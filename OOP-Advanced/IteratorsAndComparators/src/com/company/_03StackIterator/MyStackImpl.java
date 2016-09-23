package com.company._03StackIterator;

import jdk.nashorn.internal.runtime.regexp.joni.constants.StackType;

import java.util.*;

public class MyStackImpl implements MyStack, StackType {
    private List<Integer> myList;

    public MyStackImpl() {
        this.myList = new ArrayList<>();
    }

    @Override
    public void push(Integer... elements) {

            this.myList.addAll(Arrays.asList(elements));

    }

    @Override
    public void pop() {
        if (this.myList.size() <= 0){
            throw new IndexOutOfBoundsException("No elements");
        }
        this.myList.remove(this.myList.size() -1);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MyIterator(this.myList);
    }
}
