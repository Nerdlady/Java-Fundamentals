package com.company.trafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] values = reader.readLine().split("\\s+");

        Light[] lights = new Light[values.length];

        for (int i = 0; i < values.length; i++) {
            lights[i] = Light.valueOf(values[i]);
        }

        int times = Integer.parseInt(reader.readLine());
        for (int l = 0; l < times ; l++) {
            StringBuilder output = new StringBuilder();
            for (int i = 0; i < lights.length; i++) {
                lights[i] = lights[i].next();
                output.append(lights[i]).append(" ");
            }
            System.out.println(output.toString());
        }


    }
}

