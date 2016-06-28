package com.company;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class ReverseAndExclude {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split("\\s+");
        Integer num = Integer.parseInt(scanner.nextLine());

        Integer[] nums = parse(line,m -> Integer.parseInt(m));
        nums = removeDivisible(nums, n -> n % num != 0);


        for (int i = nums.length -1; i >=0; i--) {
            System.out.printf("%d ", nums[i]);
        }
        System.out.println();

    }

    private static Integer[] removeDivisible(Integer[] nums, Predicate<Integer> func){
        ArrayList<Integer> numbers = new ArrayList<>();
        for (Integer num : nums) {
           if (func.test(num)){
               numbers.add(num);
           }
        }
        Integer[] list2 = new Integer[numbers.size()];
        list2 = numbers.toArray(list2);

        return list2;
    }

    private static Integer[] parse(String[] toParse, Function<String,Integer> func){
        Integer[] a= new Integer[toParse.length];
        for (int i = 0; i < toParse.length; i++) {
            a[i] = func.apply(toParse[i]);
        }
       return a;

    }


}
