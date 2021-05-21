package com.educative.concepts;

public class Fibonacci {

    public static void main(String[] args) {
        int num = 12;
        System.out.println(fib(num));
    }

    public static int fib(int n) {
        return (n == 0 || n == 1) ? n : fib(n - 1) + fib(n - 2);
    }
}
