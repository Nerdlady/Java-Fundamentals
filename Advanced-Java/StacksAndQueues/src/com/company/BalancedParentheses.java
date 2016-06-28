package com.company;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        LinkedHashMap<Character, Character> parentheses = new LinkedHashMap<>();
        parentheses.put('(', ')');
        parentheses.put('{', '}');
        parentheses.put('[', ']');


        boolean areBalanced = true;

        if (input.length() == 0) {
            areBalanced = false;
        } else if ((input.length() % 2) != 0) {
            areBalanced = false;
        } else {

            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < input.length(); i++) {

                if (parentheses.containsKey(input.charAt(i))){
                    stack.push(input.charAt(i));
                }else if (stack.empty() || input.charAt(i) != parentheses.get(stack.pop())){
                    areBalanced = false;
                }

            }

        }

        if (areBalanced){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
//        Scanner scanner = new Scanner(System.in);
//        String line = scanner.nextLine();
//        int half = line.length() / 2;
//        Stack<Character> firstHalf = new Stack<>();
//        firstHalf.add(line.charAt(0));
//
//        for (int i = 1; i < line.length(); i++) {
//
//            firstHalf.add(line.charAt(i));
//        }
//
//

//        Queue<Character> secondHalf = new ConcurrentLinkedQueue<>();
//
//        for (int i = 0; i < half; i++) {
//            firstHalf.add(line.charAt(i));
//        }
//
//        for (int i = half; i < line.length(); i++) {
//            secondHalf.add(line.charAt(i));
//        }
//
//        ArrayList<Character> first = new ArrayList<>();
//        first.add('(');
//        first.add('[');
//        first.add('{');
//        first.add(' ');
//        ArrayList<Character> second = new ArrayList<>();
//        second.add(')');
//        second.add(']');
//        second.add('}');
//        second.add(' ');
//        boolean equal = true;
//         while (firstHalf.size() > 0){
//             char one = firstHalf.pop();
//             char two = secondHalf.poll();
//
//             if (first.indexOf(one) != second.indexOf(two)){
//                 equal = false;
//             }
//         }
//
//        if (equal){
//            System.out.println("YES");
//        }else {
//            System.out.println("NO");
//        }
    }
}
