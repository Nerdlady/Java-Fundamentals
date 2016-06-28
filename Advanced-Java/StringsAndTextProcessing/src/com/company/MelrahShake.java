package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Nerd_lady on 20-May-16.
 */
public class MelrahShake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if (line.equals("")){
            System.out.println("No shake.");
            return;
        }
        String patter = scanner.nextLine();
        if (patter.contains(")")){
            int index = patter.indexOf(")");

            patter = patter.substring(0,index ) + "\\" + patter.substring(index,patter.length());


        }
        if (patter.contains("(")){
            int index = patter.indexOf("(");
            patter = patter.substring(0,index ) + "\\" + patter.substring(index,patter.length());

        }

        shake(line, patter);
    }

    private static void shake(String line, String patter) {
        int length = patter.length();
        int indexOff = -1;
        int indexOfr = -1;


        Pattern pattern = Pattern.compile("(.*?)" + patter + "(.*)" + patter + "(.*)");
        Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {
            line = matcher.group(1) + matcher.group(2) + matcher.group(3);
            System.out.println("Shaked it.");


            if (length > 1) {
                int toRemove = length / 2;
                int toRemPrev = -1;
                char[] patt = patter.toCharArray();
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < length; i++) {
                    if ('(' == patt[toRemove]){
                        toRemPrev = toRemove-1;
                    }
                    if (')' == patt[toRemove]){
                        toRemPrev = toRemove-1;
                    }
                    if (i != toRemove) {
                        builder.append(patt[i]);
                    }
                }

                patter = builder.toString();
                 length =0;
                shake(line, patter);
            } else {

                System.out.println("No shake.");
                System.out.println(line);
            }

        } else {
            System.out.println("No shake.");
            System.out.println(line);
        }
    }

}
