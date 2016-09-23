package com.company.test;

import com.company.main.contracts.SimpleOrderedBag;
import com.company.main.dataStructures.SimpleSortedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class SimpleOrderedBagTests {

    private SimpleOrderedBag<String> names;

    @Before
    public void setUp(){
        this.names = new SimpleSortedList<String>(String.class);
    }

    @Test
    public void testEmptyConstructor(){
        this.names = new SimpleSortedList<String>(String.class);
        Assert.assertEquals(16,this.names.capacity());
        Assert.assertEquals(0,this.names.size());
    }


    @Test
    public void testConstructorWithInnitialCapacity(){
        this.names = new SimpleSortedList<String>(String.class,20);
        Assert.assertEquals(20,this.names.capacity());
        Assert.assertEquals(0,this.names.size());
    }


    @Test
    public void testConstructorWithInnitialComparer(){
        this.names = new SimpleSortedList<String>(String.class,String.CASE_INSENSITIVE_ORDER);
        Assert.assertEquals(16,this.names.capacity());
        Assert.assertEquals(0,this.names.size());
    }



    @Test
    public void testConstructorWithAllParameters(){
        this.names = new SimpleSortedList<String>(String.class,String.CASE_INSENSITIVE_ORDER,30);
        Assert.assertEquals(30,this.names.capacity());
        Assert.assertEquals(0,this.names.size());
    }

    @Test
    public void testAddIncreasesSize(){
        this.names.add("Nasko");
        Assert.assertEquals(1,this.names.size());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddNullThrowsExeption(){
        this.names.add(null);
    }

    @Test
    public void testAddUnsortedDataIsHeldSorted(){
        this.names.add("Rosen");
        this.names.add("Georgi");
        this.names.add("Angel");

        String expected = "Angel Georgi Rosen ";

        String real = "";

        for (String name : names) {
            real += name + " ";
        }

        Assert.assertEquals(expected,real);
    }

    @Test
    public void testAddingMoreThanInitialCapacity(){
        for (int i = 0; i < 17; i++) {
            this.names.add("Ivan");
        }

        Assert.assertEquals(17,this.names.size());
        Assert.assertFalse(this.names.capacity() == 16);
    }

    @Test
    public void testAddingAllFromCollectionIncreasesSize(){
        List<String> namesToAdd = new ArrayList<>();
        namesToAdd.add("Ivan");
        namesToAdd.add("Mosho");

        this.names.addAll(namesToAdd);

        Assert.assertEquals(2,this.names.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddingAllFromNullThrowsException(){
        this.names.addAll(null);
    }

    @Test
    public void testAddAllKeepsSorted(){
        List<String> namesToAdd = new ArrayList<>();
        namesToAdd.add("Misho");
        namesToAdd.add("Ivan");
        namesToAdd.add("Asen");

        this.names.addAll(namesToAdd);

        String expected = "Asen Ivan Misho ";
        String real = "";
        for (String name : this.names) {
            real += name + " ";
        }

        Assert.assertEquals(expected,real);
    }


    @Test
    public void testRemoveValidElementDecreasesSize(){
        this.names.add("Ivan");
        this.names.add("Gosho");
        int expectedSize = this.names.size() - 1;

        this.names.remove("Ivan");

        int realSize = this.names.size();

        Assert.assertEquals(expectedSize,realSize);
    }

    @Test
    public void testRemoveValidElementRemovesSelectedOne(){
        this.names.add("Ivan");
        this.names.add("Gosho");

        this.names.remove("Ivan");

        String expected = "Gosho";
        String real = "";
        for (String name : names) {
            real += name;
        }

        Assert.assertEquals(expected,real);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemovingNullThrowsException(){
        this.names.remove(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testJoinWithNull(){
        this.names.add("Gosho");
        this.names.add("Pehso");

        this.names.joinWith(null);
    }


    @Test
    public void testJoinWorksFine(){
        this.names.add("Gosho");
        this.names.add("Pesho");
        this.names.add("Stoqn");

        String expected= "Gosho, Pesho, Stoqn";

        String real = this.names.joinWith(", ");

        Assert.assertEquals(expected,real);
    }
}
