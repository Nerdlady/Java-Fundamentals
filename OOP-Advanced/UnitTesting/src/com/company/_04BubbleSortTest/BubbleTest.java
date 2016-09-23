package com.company._04BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class BubbleTest {

    @Test
    public void sortingIntegersShouldSortCorrectly() {
        Integer[] arrayToSort = {3, 7, 4, 1, 6, 5};
        Integer[] expected = {1, 3, 4, 5, 6, 7};

        Bubble.sort(arrayToSort);

        Assert.assertArrayEquals(expected, arrayToSort);
    }

    @Test
    public void sortingStringShouldSortCorrectly() {
        String[] arrayToSort = {"cc", "bb", "dd", "aa"};
        String[] expected = {"aa", "bb", "cc", "dd"};

        Bubble.sort(arrayToSort);

        Assert.assertArrayEquals(expected, arrayToSort);
    }


    @Test
    public void sortingDoublesShouldSortCorrectrly() {
        Double[] arrayToSort = {3.2, 8.4, 10.25, 0.32, 0.35};
        Double[] expected = {0.32, 0.35, 3.2, 8.4, 10.25};

        Bubble.sort(arrayToSort);

        Assert.assertArrayEquals(expected, arrayToSort);
    }

    @Test
    public void sortingZerosShouldSortCorrectly() {
        Integer[] arrayToSort = {0, 0, 0};
        Integer[] expected = {0, 0, 0};

        Bubble.sort(arrayToSort);

        Assert.assertArrayEquals(expected, arrayToSort);
    }

    @Test
    public void sortingWithDublicatedValuesShouldSordCorrectly() {
        Integer[] arrayToSort = {7, 3, 22, 3, 5, 7, 15, 7};
        Integer[] exoected = {3, 3, 5, 7, 7, 7, 15, 22};

        Bubble.sort(arrayToSort);

        Assert.assertArrayEquals(exoected, arrayToSort);
    }

    @Test
    public void sortingWithCustomObject() {
        Person pesho = Mockito.mock(Person.class);
        Person ivan = Mockito.mock(Person.class);

        Mockito.when(pesho.getName()).thenReturn("Pesho");
        Mockito.when(ivan.getName()).thenReturn("Ivan");

        Person[] people = {pesho, ivan};
        String rea = "Ivan Pesho ";
        Bubble.sort(people);
        String ex = "";
        for (Person person : people) {
            ex += person.getName() + " ";
        }

        Assert.assertEquals(ex, rea);

    }

}
