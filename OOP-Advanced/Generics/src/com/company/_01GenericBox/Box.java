package com.company._01GenericBox;

public class Box<T extends Comparable<T>> implements Comparable<Box<T>> {
    private T object;

    public Box(T object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return String.format("%s: %s",this.object.getClass().getName(),this.object.toString());
    }

    @Override
    public int compareTo(Box<T> o) {
        return this.object.compareTo(o.object);
    }
}
