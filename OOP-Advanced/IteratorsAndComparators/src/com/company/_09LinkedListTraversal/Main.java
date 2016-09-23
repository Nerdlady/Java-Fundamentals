package com.company._09LinkedListTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(reader.readLine());

        for (int i = 0; i < lines; i++) {
            String line = reader.readLine();
            String[] parameters = line.split(" ");
            String command = parameters[0];
            int number = Integer.parseInt(parameters[1]);
            if(command.equals("Add")){
                myLinkedList.add(number);
            }else if(command.equals("Remove")){
                myLinkedList.remove(number);
            }
        }

        System.out.println(myLinkedList.getSize());
        for (Integer number : myLinkedList){
            System.out.print(number + " ");
        }

        System.out.println();
    }
}
