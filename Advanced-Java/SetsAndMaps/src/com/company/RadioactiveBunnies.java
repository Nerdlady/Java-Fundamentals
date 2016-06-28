package com.company;

import java.util.Arrays;
import java.util.Scanner;


public class RadioactiveBunnies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);
        char[][] bunnyLair = new char[rows][];
        int playerRow = 0;
        int playerCol = 0;

        for (int i = 0; i < rows; i++) {
            bunnyLair[i] = scanner.nextLine().toCharArray();
            for (int j = 0; j < cols; j++) {
                if (bunnyLair[i][j] == 'P') {
                    playerRow = i;
                    playerCol = j;
                    bunnyLair[playerRow][playerCol] = '.';
                }
            }

        }
        String directions = scanner.nextLine();

        for (char move : directions.toCharArray()) {
            int oldPlayerRow = playerRow;
            int oldPlayerCol = playerCol;
            switch (move) {
                case 'U':
                    playerRow--;
                    break;
                case 'D':
                    playerRow++;
                    break;
                case 'L':
                    playerCol--;
                    break;
                case 'R':
                    playerCol++;
                    break;
            }

            bunnyLair = SpreadBunnies(bunnyLair, rows - 1, cols - 1);

            if (playerRow < 0 || playerRow >= rows ||
                    playerCol < 0 || playerCol >= cols) {
                PrintResult(bunnyLair, oldPlayerRow, oldPlayerCol, "won");
                return;
            }

            if (bunnyLair[playerRow][playerCol] == 'B') {
                PrintResult(bunnyLair, playerRow, playerCol, "dead");
                return;
            }
        }
    }

    private static char[][] SpreadBunnies(char[][] matrix, int rows, int cols) {
        char[][] newLair = new char[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            newLair[i] = matrix[i].clone();
        }

        for (int row = 0; row <= rows; row++) {
            for (int col = 0; col <= cols; col++) {
                if (matrix[row][col] == 'B') {
                    if (row > 0) newLair[row - 1][col] = 'B';
                    if (row < rows) newLair[row + 1][col] = 'B';
                    if (col > 0) newLair[row][col - 1] = 'B';
                    if (col < cols) newLair[row][col + 1] = 'B';
                }
            }
        }

        return newLair;
    }

    private static void PrintResult(char[][] bunnyLair, int row, int col, String outcome) {
        for (char[] bunnyRow : bunnyLair) {
            for (char c : bunnyRow) {
                System.out.printf("%s", c);
            }
            System.out.println();


        }
        System.out.printf("%s: %d %d", outcome, row, col);
    }
}

