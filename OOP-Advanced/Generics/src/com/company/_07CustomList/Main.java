package com.company._07CustomList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        MyList<String> myList = new CustomList<>();
        while (true){
            String command = reader.readLine();
            if (command.equals("END")){
                break;
            }
            String[] commands = command.split("\\s+");
            switch (commands[0]){
                case "Add":
                    myList.add(commands[1]);
                    break;
                case "Remove":
                    myList.remove(Integer.parseInt(commands[1]));
                    break;
                case "Contains":
                    System.out.println(myList.contains(commands[1]));
                    break;
                case "Swap":
                    myList.swap(Integer.parseInt(commands[1]),Integer.parseInt(commands[2]));
                    break;
                case "Greater":
                    System.out.println(myList.countGreaterThat(commands[1]));
                    break;
                case "Max":
                    System.out.println(myList.getMax());
                    break;
                case "Min":
                    System.out.println(myList.getMin());
                    break;
                case "Print":
                    for (String element : myList) {
                        System.out.println(element);
                    }
                    break;
                case "Sort":
                    Sorter sorter = new Sort();
                    sorter.sort(myList);

            }
        }
    }

   
}
