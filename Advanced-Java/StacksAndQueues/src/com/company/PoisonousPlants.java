package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        String[] nums = scanner.nextLine().split("\\s+");
        ArrayList<Integer> numbers = new ArrayList();
        for (int i = 0; i < num; i++) {
            numbers.add(Integer.parseInt(nums[i]));
        }
        int days = 0;

        while (true) {
           boolean no = true;

            for (int i = numbers.size() - 1; i >0; i--) {
                if (numbers.get(i) > numbers.get(i - 1)) {
                    numbers.remove(i);
                  no = false;
                }
            }
            if (no){
                break;
            }
            days++;
        }

       System.out.println(days);

    }
}
