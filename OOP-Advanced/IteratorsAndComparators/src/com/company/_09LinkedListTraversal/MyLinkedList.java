package com.company._09LinkedListTraversal;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {
    private class ListNode<T>{
        private T value;
        private ListNode<T> nextNode;
        private ListNode<T> prevNode;
        public T getValue() {
            return this.value;
        }

        public ListNode(T value) {
           this.setValue(value);
        }

        private void setValue(T value){
            this.value = value;
        }

        public ListNode<T> getNextNode() {
            return nextNode;
        }

        public void setNextNode(ListNode<T> nextNode) {
            this.nextNode = nextNode;
        }

        public ListNode<T> getPrevNode() {
            return prevNode;
        }

        public void setPrevNode(ListNode<T> prevNode) {
            this.prevNode = prevNode;
        }
    }

    private ListNode<T> head;
    private ListNode<T> tail;
    private int size;

    public void add(T element){
        if (this.size == 0){
            this.head =this.tail = new ListNode<T>(element);
        } else {
            ListNode<T> newTail = new ListNode<T>(element);
            newTail.prevNode = this.tail;
            this.tail.nextNode = newTail;
            this.tail = newTail;
        }
        this.size++;
    }

    public boolean remove(T element){
        ListNode<T> prev = null;
        ListNode<T> current = this.head;
        while(current != null){
            if(current.getValue() == element){
                if(current == this.tail && current == this.head){
                    this.head = this.tail = null;
                }
                else if(current == this.tail){
                    this.tail = prev;
                    this.tail.setNextNode(null);
                }
                else if(current == this.head){
                    this.head = current.getNextNode();
                }
                else {
                    prev.setNextNode(current.getNextNode());
                }

                this.size--;
                return true;
            }

            prev = current;
            current = current.getNextNode();
        }
        return false;
    }

    public int getSize(){
        return this.size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private ListNode<T> current = null;
            @Override
            public boolean hasNext() {
                return current != tail;
            }

            @Override
            public T next() {
                if (current == null){
                    current = head;
                } else {
                    current = current.getNextNode();
                }
                return current.getValue();
            }
        };
    }
}
