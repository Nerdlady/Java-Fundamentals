package com.company;


import java.io.*;

public class LineNumbers {
    public static void main(String[] args) {
        String fileName = "ests\\03_LineNumbers\\01_LinesIn.txt";
        String writeFileName = "01_LinesOut.txt";

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)))){
            FileWriter fileWriter = new FileWriter(writeFileName);
            PrintWriter writer = new PrintWriter(fileWriter);
            String line = bufferedReader.readLine();
            int count = 1;
            while (line != null){
                writer.println(count + ". " + line);
               line = bufferedReader.readLine();
                count++;
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
