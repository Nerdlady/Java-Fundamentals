package com.company._01ListyIterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListyIteratorImpl<T> implements ListyIterator<T> {
    private List<T> items;
    private int index;

    public ListyIteratorImpl(T... items) {
        this.items = Arrays.asList(items);
        this.index =0;
    }

    @Override
    public boolean move() {
        if(hasNext()){
            this.index++;
            return true;
        }

        return false;
    }

    @Override
    public boolean hasNext() {
        if(index < this.items.size() - 1){
            return true;
        }

        return false;
    }

    @Override
    public void print() {
        if(this.items.size() == 0){
            throw new IllegalStateException("Invalid Operation!");
        }

        System.out.println(this.items.get(this.index));
    }

    @Override
    public void printAll() {
        this.items.forEach(x -> System.out.print(x + " "));
        System.out.println();
    }


    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new Iterator<T>() {
            @Override
            public boolean hasNext() {
                if (items.size() > index){
                    return true;
                }
                return false;
            }

            @Override
            public T next() {
                return items.get(index);
            }
        };
        return iterator;
    }
}
