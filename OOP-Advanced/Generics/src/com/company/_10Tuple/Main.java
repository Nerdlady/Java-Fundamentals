package com.company._10Tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Threeuple<String,String,String> stringStringTuple = new ThreeupleImpl<>();
        Threeuple<String,Integer,Boolean> stringIntegerTuple = new ThreeupleImpl<>();
        Threeuple<String,Double,String> integerDoubleTuple = new ThreeupleImpl<>();
        String[] personInfo = reader.readLine().split("\\s+");
        String[] beersInfo = reader.readLine().split("\\s+");
        String[] doubleInfo = reader.readLine().split("\\s+");
        stringStringTuple.put(personInfo[0] +" " +personInfo[1],personInfo[2],personInfo[3]);
        stringIntegerTuple.put(beersInfo[0],Integer.parseInt(beersInfo[1]),beersInfo[2].equals("drunk"));
        integerDoubleTuple.put(doubleInfo[0],Double.parseDouble(doubleInfo[1]),doubleInfo[2]);
        System.out.printf("%s -> %s -> %s%n",stringStringTuple.getKey(),stringStringTuple.getFirstValue(),stringStringTuple.getSecondValue());
        System.out.println(stringIntegerTuple.getKey() + " -> " +stringIntegerTuple.getFirstValue() + " -> " + stringIntegerTuple.getSecondValue());
        System.out.println(integerDoubleTuple.getKey() + " -> " +integerDoubleTuple.getFirstValue() + " -> " + integerDoubleTuple.getSecondValue());
    }
}
