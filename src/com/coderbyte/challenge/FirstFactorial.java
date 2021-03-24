package com.coderbyte.challenge;

public class FirstFactorial {

    public static long firstFactorial(int num) {
        long fact = 1;

        for (int i = num; i > 0; i--) {
            fact = fact * i;
        }

        return fact;
    }

    public static long firstFactorial2(int num) {
        return (num == 1) ? 1 : num * firstFactorial(num - 1);
    }

    public static void main(String[] args) {
        System.out.println(firstFactorial2(18));
    }
}
