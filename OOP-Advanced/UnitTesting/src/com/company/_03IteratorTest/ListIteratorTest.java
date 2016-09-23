package com.company._03IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedList;

public class ListIteratorTest {
    private ListIterator<String> listIterator;

    @Before
    public void initialize() throws OperationNotSupportedException {
        this.listIterator = new ListIterator<>("Testing","my","listiterator");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithNullParameterShouldThrowExeption() throws OperationNotSupportedException {
        this.listIterator = new ListIterator<>(null);
    }

    @Test
    public void testEmptyConstructorShouldNotHaveNext() throws OperationNotSupportedException {
        this.listIterator = new ListIterator<>();

        Assert.assertFalse(listIterator.hasNext());
    }

    @Test
    public void testHasNextShouldReturnTrue(){
        Assert.assertTrue(this.listIterator.hasNext());
    }

    @Test
    public void testHasNextWhereThereIsNoElementsShouldReturnFalse() throws OperationNotSupportedException {
        this.listIterator = new ListIterator<>();

        Assert.assertTrue(!this.listIterator.hasNext());
    }

    @Test
    public void testMoveShouldReturnTrue(){
        Assert.assertTrue(this.listIterator.move());
    }

    @Test
    public void testMoveWhereThereIsNoMoreElementsShouldReturnFalse() throws OperationNotSupportedException {
        this.listIterator = new ListIterator<>();

        Assert.assertTrue(!this.listIterator.move());
    }

    @Test
    public void printFirstElement(){
        String expected = "Testing";

        Assert.assertEquals(expected,this.listIterator.print());
    }

    @Test
    public void printNextElement(){
        String expected = "my";

        this.listIterator.move();

        Assert.assertEquals(expected,this.listIterator.print());
    }

    @Test(expected = IllegalStateException.class)
    public void printWhereThereIsNoElementShouldThrowExeption() throws OperationNotSupportedException {
       this.listIterator = new ListIterator<>();
        this.listIterator.print();
    }

    @Mock
    private LinkedList<Integer> mockedList;
    @Test
    public void testMockig(){

        Mockito.verify(mockedList).add(5);
    }
}
