package com.company;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer,Integer[]> places = new HashMap<>();
         String[] dimentions = scanner.nextLine().split("\\s+");
        int row = Integer.parseInt(dimentions[0]);
        int col = Integer.parseInt((dimentions[1]));

        for (int i = 0; i < row; i++) {
            places.put(i,new Integer[col]);
            places.get(i)[0] = 1;
            for (int j = 1; j < col; j++) {
                places.get(i)[j] = 0;
            }
        }

        while (true){
            String input = scanner.nextLine();
            if (input.equals("stop")){
                break;
            }

            String[] car = input.split("\\s+");
            Integer entryRow = Integer.parseInt(car[0]);
            Integer wantedRow = Integer.parseInt(car[1]);
            Integer wantedCol = Integer.parseInt(car[2]);

            if (places.get(wantedRow)[wantedCol] != 1){
                places.get(wantedRow)[wantedCol] = 1;
                System.out.println(countSpots(wantedRow,wantedCol,entryRow));
            } else {
               int place = findPlaceToPark(wantedCol,places.get(wantedRow),col);
                if (place == -1){
                    System.out.printf("Row %d full%n",wantedRow);
                } else {
                    System.out.println(countSpots(wantedRow,place,entryRow));
                }
            }


        }

    }

    private static Integer countSpots(Integer wantedRow, Integer wantedCol, Integer entryRow){
        if (wantedRow == entryRow){
            return wantedCol+1;
        }

       return Math.abs(entryRow - wantedCol) +wantedCol +1;
    }

    private static Integer findPlaceToPark(Integer wantedCol, Integer[] integers,Integer cols) {
        int colLeft = wantedCol - 1;
        int colRight = wantedCol +1;

        while (true){
            if (colLeft > 0){
                boolean foundLeft = isItFree(integers,colLeft,cols);
                if (foundLeft){
                    integers[colLeft] = 1;
                    return colLeft;
                }
            }


            if (colRight < cols){

                boolean foundRight = isItFree(integers,colRight,cols);

                if (foundRight){
                    integers[colRight] = 1;
                    return colRight;
                }
            }


            if (colLeft - 1 <= 0 && colRight +1 > cols){
                break;
            }

            colLeft--;
            colRight++;
        }
        return -1;

    }

    private static Boolean isItFree(Integer[] parkPlaces,Integer place, Integer finalPlace){
        if (parkPlaces[place] != 1 && (place > 0 || place < finalPlace)){
            return true;
        }
        return false;
    }
}
