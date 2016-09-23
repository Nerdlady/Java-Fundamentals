package com.company._01GenericBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Box<Double>> boxes = new LinkedList<>();


        int numberOfLines = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfLines; i++) {
            String line = reader.readLine();
            Double anInt = Double.parseDouble(line);
            Box<Double> stringBox = new Box<>(anInt);
         boxes.add(stringBox);
        }

        String indexes= reader.readLine();
//        int one = Integer.parseInt(indexes[0]);
//        int two = Integer.parseInt(indexes[1]);

       // swap(boxes,one,two);
        Double parseDouble = Double.parseDouble(indexes);
        Box<Double> toCompare = new Box<>(parseDouble);
        boxes = filer(boxes,toCompare);
        System.out.println(boxes.size());
    }

    public static <T> void swap(List<T> list, int indexOne, int indexTwo){
        T two = list.get(indexTwo);
        T one = list.get(indexOne);

        list.set(indexOne,two);
        list.set(indexTwo,one);
    }

    public static <T  extends Comparable<T>> List<T> filer(List<T> list,T toCompare){
        List<T> filtered = new LinkedList<T>();
        for (T t : list) {
            if (t.compareTo(toCompare) > 0){
                filtered.add(t);
            }
        }
        return filtered;
    }
}
