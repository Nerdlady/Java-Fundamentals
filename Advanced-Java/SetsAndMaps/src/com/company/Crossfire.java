package com.company;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Crossfire {
    static int rows;
    static int cols;

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            String[] demantions = scanner.nextLine().split(" ");
            rows = Integer.parseInt(demantions[0]);
            cols = Integer.parseInt(demantions[1]);
            ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

            int nums = 1;
            for (int i = 0; i < rows; i++) {
                ArrayList<Integer> add = new ArrayList<>();
                for (int j = 0; j < cols; j++) {

                    add.add(nums);
                    nums++;


                }
                matrix.add(add);
            }

            while (true) {
                String command = scanner.nextLine();
                if (command.equals("Nuke it from orbit")) {
                    break;
                }
                String[] s = command.split(" ");

                bomb(matrix, s, rows, cols);
                //  newMatrix(matrix);
                filterMatrix(matrix);

            }

            printMatrix(matrix);
        }catch (Exception e){

        }

    }

    static void bomb( ArrayList<ArrayList<Integer>>  matrix, String[] bomb, int matrixRow, int matrixCol) {
        int rowBomb = Integer.parseInt(bomb[0]);
        int colBomb = Integer.parseInt(bomb[1]);
        int radius = Integer.parseInt(bomb[2]);

        for (Integer currentRow = rowBomb - radius; currentRow <= rowBomb + radius; currentRow++) {

            if(isInsideRadius(currentRow, colBomb, matrix)){

                matrix.get(currentRow).set(colBomb, -1);
            }
        }

        for (Integer currentCol = colBomb - radius; currentCol <= colBomb + radius; currentCol++) {

            if(isInsideRadius(rowBomb, currentCol, matrix)){

                matrix.get(rowBomb).set(currentCol, -1);
            }
        }
    }
    private static void filterMatrix(ArrayList<ArrayList<Integer>> matrix){
        for (int row = 0; row < matrix.size(); row++) {
            matrix.get(row).removeAll(Arrays.asList((new Integer[] {-1})));
        }
        matrix.removeAll(Arrays.asList(new ArrayList<>()));
    }

    private static boolean isInsideRadius(Integer currentRow, Integer currentCol, ArrayList<ArrayList<Integer>> numberMatrix){
        return currentRow >= 0 && currentRow < numberMatrix.size() && currentCol >= 0 && currentCol < numberMatrix.get(currentRow).size();
    }

    private static void printMatrix( ArrayList<ArrayList<Integer>>  matrix) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <  matrix.get(i).size(); j++) {
                if (matrix.get(i).get(j) != 0 && j != cols - 1) {
                    System.out.printf(matrix.get(i).get(j).toString() + " ");
                } else if (matrix.get(i).get(j) != 0) {
                    System.out.printf(matrix.get(i).get(j).toString());
                }
            }
            System.out.println();
        }
    }


}
