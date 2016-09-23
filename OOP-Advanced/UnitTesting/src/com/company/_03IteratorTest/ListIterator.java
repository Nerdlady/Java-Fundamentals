package com.company._03IteratorTest;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListIterator<T> implements Iterable<T> {
    private List<T> items;
    private int index;

    public ListIterator(T... items) throws OperationNotSupportedException {
        this.setItems(items);
        this.index =0;
    }

    public void setItems(T... items) throws OperationNotSupportedException {
        if (items == null){
            throw new OperationNotSupportedException();
        }
        this.items = Arrays.asList(items);
    }

    public boolean move() {
        if(hasNext()){
            this.index++;
            return true;
        }

        return false;
    }

    public boolean hasNext() {
        if(index < this.items.size() - 1){
            return true;
        }

        return false;
    }

    public T print() {
        if(this.items.size() == 0){
            throw new IllegalStateException("Invalid Operation!");
        }

       return this.items.get(this.index);
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
