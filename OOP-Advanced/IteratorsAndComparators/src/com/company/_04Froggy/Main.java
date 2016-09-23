package com.company._04Froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("[,\\s]+");
        int[] numbers = Arrays.asList(input).stream().mapToInt(Integer::parseInt).toArray();
        Lake lake= new Lake(numbers);
        StringBuilder builder = new StringBuilder();
        for (int i : lake) {
            builder.append(i + ", ");
        }
        builder.replace(builder.length()-2,builder.length(),"");
        System.out.println(builder.toString());
    }
}
