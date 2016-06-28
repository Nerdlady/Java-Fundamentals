package com.company;

import java.util.*;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        scanner = new Scanner(line);


        List<Integer> nums = new ArrayList<>();
        while (scanner.hasNextInt()) {
            Integer n = scanner.nextInt();
            nums.add(n);
        }
        Integer[] result = new Integer[nums.size()];
        result = nums.toArray(result);


        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int result = 0;
                if ((o1 % 2 == 0 && o2 % 2 == 0) || (o1 % 2 != 0 && o2 % 2 != 0)) {
                    result = Integer.compare(o1, o2);
                    return  result;
                }

                if (o1 % 2 == 0) {
                    result = -1;
                } else if (o2 % 2 == 0) {
                    result = 1;
                }
                return result;
            }
        };

        Arrays.sort(result,comparator);
        for (int i = 0; i < nums.size(); i++) {
            if (i < nums.size() - 1){
                System.out.printf("%d ",result[i]);
            } else {
                System.out.printf("%d ",result[i]);
            }

        }
    }
}
