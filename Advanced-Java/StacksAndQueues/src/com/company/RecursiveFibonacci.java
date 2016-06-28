package com.company;


import java.util.HashMap;
import java.util.Scanner;

public class RecursiveFibonacci {
    static HashMap<Long,Long> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextLong();
        System.out.println(getFibonaci(num));

    }

    static Long getFibonaci(long num){
        long sum = 0;
        if (num <= 1){
            return 1L;
        }
        if (!map.containsKey(num)){
            sum += getFibonaci(num -1) + getFibonaci(num - 2);
            map.put(num, sum);
        } else {
            return map.get(num);
        }


        return sum;
    }
}
