package com.company;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class TruckTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer lines = Integer.parseInt(scanner.nextLine());
        ArrayList<BigDecimal> petrol = new ArrayList<>();
        ArrayList<BigDecimal> dictance = new ArrayList<>();
        for (int i = 0; i < lines; i++) {
            String[] info = scanner.nextLine().split("\\s+");
            petrol.add(new BigDecimal(info[0]));
            dictance.add(new BigDecimal(info[1]));
        }


        for (int i = 0; i <lines; i++) {
             boolean place = true;
            BigDecimal petrolCaring = new BigDecimal(0);

            for (int j = 0; j < lines; j++) {
                int index = (i+j) % lines;
               petrolCaring= petrolCaring.add(petrol.get(index));
              petrolCaring=  petrolCaring.subtract(dictance.get(index));
                if (petrolCaring.compareTo(BigDecimal.ZERO) == -1){
                    place = false;
                    break;
                }
            }

            if (place){
                System.out.println(i);
                break;
            }
        }
    }
}
