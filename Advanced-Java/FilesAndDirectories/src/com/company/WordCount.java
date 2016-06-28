package com.company;


import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) {
        String fileName ="Tests\\04_WordCount\\words1.txt";
        String secondFileName = "Tests\\04_WordCount\\text1.txt";
        String toWrite = "result.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))){
            HashMap<String,Integer> words = new HashMap<>();
            while (true){
                String line = reader.readLine();
                if (line == null){
                    break;
                }

                String[] word = line.split("\\s+");
                for (String s : word) {
                    words.put(s.toLowerCase(),0);
                }
            }

            BufferedReader reader2 = new BufferedReader(new FileReader(new File(secondFileName)));
            StringBuilder builder = new StringBuilder();

            while (true){
                String line = reader2.readLine();
                if (line == null){
                    break;
                }

                builder.append(line.toLowerCase() +" ");

            }
            reader2.close();
            String[] text = builder.toString().split("[\\W+]");

            for (Map.Entry<String, Integer> word : words.entrySet()) {
                for (String s : text) {
                    if (s.equals(word.getKey())){
                        int sum = word.getValue() + 1;
                        words.put(word.getKey(),sum);
                    }
                }
            }

            FileWriter fileWriter = new FileWriter(toWrite);
            PrintWriter writer = new PrintWriter(fileWriter);

            words.entrySet().stream().sorted((a,b) -> Integer.compare(b.getValue(),a.getValue())).forEach(a ->{
                writer.printf("%s - %d%n", a.getKey(),a.getValue());
            });

            writer.close();



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
