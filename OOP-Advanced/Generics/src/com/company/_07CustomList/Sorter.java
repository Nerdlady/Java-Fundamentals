package com.company._07CustomList;

public interface Sorter {
    <T extends Comparable<T>> void sort(MyList<T> myList);
}
