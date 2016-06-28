package com.company;

import java.io.*;
import java.util.Scanner;

public class ReadFromSpecifiedLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String path = "01_LinesOut.txt";
         try (BufferedReader reader = new BufferedReader(new FileReader(new File(path)))){
             for (int i = 0; i < num; i++) {
                 reader.readLine();
             }
             while (true){
                 String line = reader.readLine();
                 if ( line == null){
                     break;
                 }
                 System.out.println(line);
             }


         } catch (FileNotFoundException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
    }
}
