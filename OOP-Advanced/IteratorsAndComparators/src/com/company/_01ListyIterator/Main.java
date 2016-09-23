package com.company._01ListyIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ListyIterator<String> listyIterator = null;

        while(true){
            String line = reader.readLine();
            if (line.equals("END")){
                break;
            }
            String[] parameters = line.split(" ");

            switch (parameters[0]) {
                case "Create":
                    if(parameters.length > 1){
                        listyIterator = new ListyIteratorImpl<>(Arrays.copyOfRange(parameters,1,parameters.length));
                    } else{
                      listyIterator = new ListyIteratorImpl<>();
                    }
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "Print":
                    try {
                        listyIterator.print();
                    } catch (IllegalStateException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "PrintAll":
                    listyIterator.printAll();
                    break;
            }
        }
    }
}
