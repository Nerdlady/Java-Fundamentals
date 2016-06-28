package com.company;

import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

public class Palindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] text = scanner.nextLine().split("[\\s+,\\.\\?'\"!]");
        ArrayList<String> polindromes = new ArrayList<>();

        for (int i = 0; i < text.length; i++) {
            if (text[i].equals("")){
                continue;
            }
            int half = text[i].length() / 2;
            String textt = text[i];
            if (textt.length() % 2 !=0){
                textt = new StringBuilder(text[i]).delete(half,half+1).toString();
            }

            String first = textt.substring(0, half);
            String second = textt.substring(half, textt.length());
            if (new StringBuilder(second).reverse().toString().equals(first)) {
                if (!polindromes.contains(text[i])){
                    polindromes.add(text[i]);
                }

            }
        }

        Collections.sort(polindromes,
                new Comparator<String>() {

                    @Override
                    public int compare(String o1, String o2) {
                        if(o1.equalsIgnoreCase(o2)){
                            return o1.compareTo(o2);
                        }
                        return o1.toUpperCase().compareTo(o2.toUpperCase());
                    }

                });
        System.out.println(polindromes);

//
//        Collator collator = Collator.getInstance();
//
//        List<String> out = polindromes.stream().sorted((a,b) -> collator.compare(a,b)).collect(Collectors.toList());
//        System.out.println(out);
    }


}
