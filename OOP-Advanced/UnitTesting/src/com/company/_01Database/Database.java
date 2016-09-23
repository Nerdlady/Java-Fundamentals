package com.company._01Database;

import javax.naming.OperationNotSupportedException;

public class Database {
    private static final int MAX_CAPACITY = 16;
    private Integer[] elements;
    private int elementsCount;
    private int currentIndex;

    public Database(Integer... elements) throws OperationNotSupportedException {
        this.setElements(elements);
        this.elementsCount = elements.length;
        this.currentIndex = this.elementsCount;
    }

    public void addElement(Integer element) throws OperationNotSupportedException {
        if (element == null){
            throw new OperationNotSupportedException();
        }

        this.elements[currentIndex++] = element;
        this.elementsCount++;
    }

    public void removeElement() throws OperationNotSupportedException {
        if (this.elementsCount == 0){
            throw new OperationNotSupportedException();
        }

        this.elements[--currentIndex] = null;
        this.elementsCount--;
    }

    public Integer[] getElements(){
        Integer[] copyToReturn = new Integer[this.elementsCount];
        for (int i = 0; i < this.elementsCount; i++) {
            copyToReturn[i] = this.elements[i];
        }

        return copyToReturn;
    }

    public int getElementsCount() {
        return elementsCount;
    }

    private void setElements(Integer... elements) throws OperationNotSupportedException {
        if (elements.length > MAX_CAPACITY || elements.length < 1){
            throw new OperationNotSupportedException();
        }
        this.elements = new Integer[MAX_CAPACITY];
        for (int i = 0; i < elements.length; i++) {
            this.elements[i] = elements[i];
        }
    }
}
