package com.company._07CustomList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CustomList<T extends Comparable<T>> implements MyList<T> {
    private List<T> list;
    private int index;

    public CustomList() {
        this.list = new LinkedList<T>();
        this.index = 0;
    }

    @Override
    public void add(T element) {
        this.list.add(element);
    }

    @Override
    public void remove(int index) {
this.list.remove(index);
    }

    @Override
    public boolean contains(T element) {
        return this.list.contains(element);
    }

    @Override
    public void swap(int indexOne, int indexTwo) {
        T two = this.list.get(indexTwo);
        T one = this.list.get(indexOne);

        this.list.set(indexOne,two);
        this.list.set(indexTwo,one);
    }

    @Override
    public int countGreaterThat(T element) {
      int count =0;
        for (T t : list) {
            if (t.compareTo(element) > 0){
               count++;
            }
        }
        return count;
    }

    @Override
    public T getMax() {
        T element = this.list.get(0);
        for (int i = 1; i < this.list.size(); i++) {
            if (element.compareTo(this.list.get(i)) < 0){
                element = this.list.get(i);
            }
        }
        return element ;
    }

    @Override
    public T getMin() {
        T element = this.list.get(0);
        for (int i = 1; i < this.list.size(); i++) {
            if (element.compareTo(this.list.get(i)) > 0){
                element = this.list.get(i);
            }
        }
        return element ;
    }

    @Override
    public int getSize() {
        return this.list.size();
    }

    @Override
    public T get(int index) {
        return this.list.get(index);
    }


    @Override
    public Iterator<T> iterator() {
        index = 0;
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return index < list.size();
            }

            @Override
            public T next() {
                return list.get(index++);
            }
        };
    }
}
