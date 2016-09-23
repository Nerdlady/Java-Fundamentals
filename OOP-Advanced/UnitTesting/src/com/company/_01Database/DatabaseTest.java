package com.company._01Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private Database database;

    @Before
    public void initialize() throws OperationNotSupportedException {
        this.database = new Database(1,2,3,4,5);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorToAddMoreThenMaxCapasityShouldThrowExeption() throws OperationNotSupportedException {
        this.database = new Database(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithoutParametersShouldThrowExeption() throws OperationNotSupportedException {
        this.database = new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addingNullElementShouldThrowException() throws OperationNotSupportedException {
        this.database.addElement(null);
    }

    @Test
    public void addedElementShouldBeLast() throws OperationNotSupportedException {
        int elementToAdd = 15;
        int expectedIndex = 5;

        this.database.addElement(elementToAdd);
        Assert.assertTrue(this.database.getElements()[expectedIndex] == elementToAdd);
    }

    @Test
    public void removeElementsLenghtShouldBeLesser() throws OperationNotSupportedException {
        int expectedLenght = this.database.getElementsCount() - 1;

        this.database.removeElement();

        Assert.assertTrue(this.database.getElementsCount() == expectedLenght);
    }

    @Test
    public void removedElementShouldNotExist() throws OperationNotSupportedException {
        Integer[] expectedElementsAfterRemoving = {1,2,3,4};

        this.database.removeElement();

        Assert.assertArrayEquals(expectedElementsAfterRemoving,this.database.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removingAllElemntAndTryToRemoveEmpryColectionSholudThrowExeption() throws OperationNotSupportedException {
        int startElementsCount = this.database.getElementsCount();
        for (int i = 0; i <= startElementsCount; i++) {
            this.database.removeElement();
        }
    }

    @Test
    public void getElements(){
        Integer[] expectedElementsAfterRemoving = {1,2,3,4,5};
        Assert.assertArrayEquals(expectedElementsAfterRemoving,this.database.getElements());
    }

}
