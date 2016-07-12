package com.company._10Mood3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = reader.readLine().split("\\s+\\|\\s+");
        switch (line[1]){
            case "Demon":
                String password = (line[0].length() *217) + "";
                GameObject<Double> demon = new Demon(line[0],password,Integer.parseInt(line[3]),Double.parseDouble(line[2]));
                System.out.println(demon.toString());
                break;
            case "Archangel":
                String archangelPassword = new StringBuilder(line[0]).reverse().toString() + (line[0].length() *21);
                GameObject<Integer> archangel = new Archangel(line[0],archangelPassword,Integer.parseInt(line[3]),Integer.parseInt(line[2]));
                System.out.println(archangel.toString());
                break;

        }

    }
}
