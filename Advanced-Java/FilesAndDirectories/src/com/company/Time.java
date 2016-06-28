package com.company;


import java.io.*;

public class Time {
    public static void main(String[] args) {

        String[] paths = {"text1.txt","01_LinesIn.txt"};
        long[] times = {0,0};

        try {
            for (int i = 0; i < 2; i++) {
                long start =System.nanoTime();
                BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(paths[i])));
                while (true){
                    String line = bufferedReader.readLine();
                    if (line == null){
                        break;
                    }
                }
                bufferedReader.close();
                long end = System.nanoTime();
                System.out.println(end -start);

                times[i] = end -start;
            }

            if (times[0] < times[1]){
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
