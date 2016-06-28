package com.company;


import java.math.BigInteger;
import java.util.Scanner;

public class ConvertFromNTo10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nums = scanner.nextLine().split("\\s+");
        int base = Integer.parseInt(nums[0]);
        System.out.println(convert(new BigInteger(nums[1]),nums[0]));
    }

    private static BigInteger convert(BigInteger number, String outBase) {
        BigInteger outNumber = BigInteger.ZERO;
        BigInteger base2 = new BigInteger(outBase);
        BigInteger base =new BigInteger(outBase);


        while (number.compareTo(BigInteger.ZERO) > 0) {
            BigInteger digit = number.remainder(new BigInteger("10"));
            number = number.divide(new BigInteger("10"));

            outNumber = outNumber.add(base.divide(base2).multiply(digit));
            base = base.multiply(base2);

        }

        return outNumber;

    }
}
