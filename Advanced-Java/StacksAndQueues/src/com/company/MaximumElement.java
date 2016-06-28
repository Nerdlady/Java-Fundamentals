package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class MaximumElement {

    public static void main(String[] args) {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        String n = null;
        try {
            n = scanner.readLine();
            int lines = Integer.parseInt(n);
            Stack<Integer> numbers = new Stack<>();
            Stack<Integer> max = new Stack<>();
            max.add(Integer.MIN_VALUE);
            for (int i = 0; i < lines; i++) {
                String[] line = scanner.readLine().split("\\s+");
                int command = Integer.parseInt(line[0]);
                switch (command){
                    case 1:
                        int toAdd =Integer.parseInt(line[1]);
                        numbers.add(toAdd);
                        if (toAdd > max.peek()){
                            max.add(toAdd);
                        }
                        break;
                    case 2:
                        int b = numbers.pop();
                        if (max.peek()==b){
                            max.pop();
                        }
                        break;
                    case 3:
                        System.out.println(max.peek());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
