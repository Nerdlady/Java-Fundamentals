package com.company._06;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeChecher {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        Number number1 = new Number(number);
        System.out.printf("%d, %s",number1.nextPrime(),number1.isPrime );
    }
}

class Number{
    int num;
    boolean isPrime;

    public Number(int num) {
        this.num = num;
        cuurentIsPrime();
    }

    private void cuurentIsPrime(){

        for (int i = 2; i <= num; i++) {
            if (num % i == 0 && i != num){
                isPrime = false;
                return;
            }
        }

        isPrime= true;
    }
    
    public int nextPrime(){
       while (true){
           Number number = new Number(++num);
           if (number.isPrime == true){
               return num;
           }
       }

    }
}
