package com.company._03StackIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        MyStack myStack = new MyStackImpl();
        while (true){
            String line = reader.readLine();
            if (line.equals("END")){
                break;
            }

            String[] params = line.split("[,\\s]+");
            switch (params[0]){
                case "Push":
                    Integer[] ints = new Integer[params.length -1];
                    for (int i = 0; i < ints.length; i++) {
                        ints[i] = Integer.parseInt(params[i+1]);
                    }
                    myStack.push(ints);
                    break;
                case "Pop":
                    try {
                        myStack.pop();
                    } catch (IndexOutOfBoundsException e){
                        System.out.println(e.getMessage());
                    }

                    break;
            }
        }

        try {
            for (Integer integer : myStack) {
                System.out.println(integer);
            }
        } catch (ArrayIndexOutOfBoundsException  e){
            System.out.println("No elements");
        }

        try {
            for (Integer integer : myStack) {
                System.out.println(integer);
            }
        } catch (ArrayIndexOutOfBoundsException  e){
            System.out.println("No elements");
        }


    }
}
