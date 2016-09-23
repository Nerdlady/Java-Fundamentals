package com.company._03StackIterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class MyIterator implements Iterator<Integer> {
    private Collection<Integer> collection;
    private int index;

    public MyIterator(Collection<Integer> collection) {
        this.collection = collection;
        this.index = collection.size() - 1; // TODO: check if thats want they want
    }

    @Override
    public boolean hasNext() {
        return index >=0;
    }

    @Override
    public Integer next() {
            return new ArrayList<Integer>(this.collection).get(index--);


    }
}
