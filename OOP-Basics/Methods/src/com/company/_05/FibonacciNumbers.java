package com.company._05;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FibonacciNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String numOne= reader.readLine();
        String numTwo = reader.readLine();
        Fibonacci fib = new Fibonacci(Long.parseLong(numOne),Long.parseLong(numTwo));
        fib.fibonacci();

    }
}

class Fibonacci{
    long start;
    long end;


    public Fibonacci(long start, long end) {
        this.start = start;
        this.end = end;
    }

    public void fibonacci(){
        long[] fib = new long[3];
        fib[0] = 0;
        fib[1] = 1;
        fib[2] = 1;

        long current = 0;

        for (int i = 0; i < this.end; i++) {
            if (i <= 2) {
                current = fib[i];
            } else {
                fib[0] = fib[1];
                fib[1] = fib[2];
                fib[2] = fib[0] + fib[1];
                current = fib[2];
            }


            if (i >= start && i < end - 1) {
                System.out.printf("%s, ", current);
            } else if (i == end - 1) {
                System.out.printf("%s", current);
            }
        }
    }


}
