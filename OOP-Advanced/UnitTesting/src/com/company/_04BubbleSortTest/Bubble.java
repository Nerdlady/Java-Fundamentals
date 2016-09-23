package com.company._04BubbleSortTest;

public class Bubble {

    public static <T extends Comparable> void sort(T[] elements){
//        int lenght = elements.length;
//        boolean swaped = true;
//        while (swaped){
//            swaped = false;
//            for (int i = 0; i < lenght -1; i++) {
//                if (elements[i].compareTo(elements[i + 1]) > 0){
//                    T temp = elements[i];
//                    elements[i]  =elements[i + 1];
//                    elements[i + 1] = temp;
//                    swaped = true;
//                }
//            }
//        }


        for (int i = 0; i < elements.length; i++) {
            boolean swaped =  false;

            for (int j = 0; j < elements.length- i - 1; j++) {
                if (elements[j].compareTo(elements[j + 1]) > 0) {
                    T temp = elements[j];
                    elements[j] = elements[j +1];
                    elements[j+1] = temp;
                    swaped = true;
                }
            }

            if (!swaped){
                break;
            }
        }
    }




}



