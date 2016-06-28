package com.company;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Problem02 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int dimensions = Integer.parseInt(reader.readLine());
        long all = dimensions * dimensions * dimensions;
        BigInteger sum = BigInteger.ZERO;
         while (true){
             String line = reader.readLine();
             if (line.equals("Analyze")){
                 break;
             }

             String[] info = line.split("\\s+");
             long numOne = Integer.parseInt(info[0]);
             long numTwo = Integer.parseInt(info[1]);
             long numThree = Integer.parseInt(info[2]);
             if (checkIsItIn(dimensions,numOne) && checkIsItIn(dimensions,numTwo) && checkIsItIn(dimensions,numThree)){
                 long numToSum = Long.parseLong(info[3]);
                sum = sum.add(new BigInteger(info[3]));
                if (numToSum != 0){
                    all--;
                }

             }


         }

        System.out.println(sum);
        System.out.println(all);
    }

    private static boolean checkIsItIn(int dimension,long num){
        if (num >= 0 && num < dimension){
            return true;
        }
        return false;
    }
}
