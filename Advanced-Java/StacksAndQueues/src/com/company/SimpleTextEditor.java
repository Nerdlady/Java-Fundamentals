package com.company;


import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        Integer lines = Integer.parseInt(scanner.nextLine());
        StringBuilder stringBuilder = new StringBuilder();
        Stack<String> strings = new Stack<>();

        for (int i = 0; i < lines; i++) {

            Integer command = scanner.nextInt();
           int size = stringBuilder.length();
            switch (command){
                case 1:
                    strings.add(stringBuilder.toString());
                    stringBuilder.append(scanner.next().trim());
                    break;
                case 2:
                    strings.add(stringBuilder.toString());
                    stringBuilder.delete(size -scanner.nextInt(), size);
                    break;
                case 3:
                    System.out.println(stringBuilder.toString().charAt(scanner.nextInt()- 1));
                    break;
                case 4:
                    stringBuilder.replace(0, size,strings.pop());
            }
        }
    }
}
