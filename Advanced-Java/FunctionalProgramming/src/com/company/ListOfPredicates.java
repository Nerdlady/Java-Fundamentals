package com.company;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer start = 1;
        Integer end = Integer.parseInt(scanner.nextLine());
        if (end < 1){
            return;
        }
        String[] numbers=  scanner.nextLine().split("\\s+");
        Integer[] nums = new Integer[end];
        List<Predicate> predicates = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
           int num = Integer.parseInt(numbers[i]);
            Predicate<Integer> predicate = new Predicate<Integer>() {
                @Override
                public boolean test(Integer integer) {
                  if (integer % num == 0){
                      return true;
                  }
                    return false;
                }
            };
            predicates.add(predicate);
        }
        int index = 0;

        for (int i = start; i <= end; i++) {
            nums[index] = i;
            index++;
        }

        nums = allDivisible(nums,predicates);

        for (Integer num : nums) {
            System.out.printf("%s ", num);
        }




    }

    private static Integer[] allDivisible(Integer[] nums,List<Predicate> predicates){
        ArrayList<Integer> all = new ArrayList<>();
        for (Integer num : nums) {
            boolean isDicisible =  true;
            for (Predicate predicate : predicates) {
                if (!predicate.test(num)){
                    isDicisible= false;
                }
            }
            if (isDicisible){
                all.add(num);
            }

        }

        Integer[] toReturn = new Integer[all.size()];
        toReturn = all.toArray(toReturn);
        return toReturn;
    }
}
