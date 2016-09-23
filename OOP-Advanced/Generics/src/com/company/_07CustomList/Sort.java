package com.company._07CustomList;

public class Sort implements Sorter {
    @Override
    public <T extends Comparable<T>> void sort(MyList<T> myList) {
        for (int i = 0; i < myList.getSize(); i++) {
            T element = myList.get(i);
            for (int j = i +1; j < myList.getSize(); j++) {
                if (element.compareTo(myList.get(j)) > 0){
                    myList.swap(i,j);
                }
            }
        }
    }
}
