package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        String fileName = "Tests\\02_OddLines\\03_OddLinesIn.txt";
        String writeFileName = "01_OddLinesOut.txt";
        boolean ood = false;
        LinkedList<String> odds = new LinkedList<>();

        try( BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))) {
            FileWriter fileWriter = new FileWriter(writeFileName);
            PrintWriter writer = new PrintWriter(fileWriter);
            String line = reader.readLine();
            while (line != null){
                if (ood){
                    writer.println(line);
                }
                line = reader.readLine();
                ood = !ood;
            }
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
