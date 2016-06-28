package com.company;


import java.io.*;

public class MergingFiles {
    public static void main(String[] args) {
        String fileName = "Tests\\05_MergingFiles\\01_FileOne.txt";
        String secondFileName = "Tests\\05_MergingFiles\\01_FileTwo.txt";
        String result = "mergingResult.txt";
        StringBuilder builder = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))) {
            BufferedReader reader2 = new BufferedReader(new FileReader(new File(secondFileName)));
            while (true){
                String line = reader.readLine();
                String line2 = reader2.readLine();
                if (line == null && line2 == null){
                    break;
                }

                if (line != null ){
                    builder.append(line).append(System.getProperty("line.separator"));
                }
                if (line2 != null){
                    builder.append(line2).append(System.getProperty("line.separator"));
                }


            }




            reader2.close();

            FileWriter fileWriter = new FileWriter(result);
            PrintWriter writer = new PrintWriter(result);

            writer.println(builder.toString());
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
