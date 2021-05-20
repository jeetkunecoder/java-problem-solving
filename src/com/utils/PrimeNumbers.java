package com.utils;

public class PrimeNumbers {

    public static void main(String[] args) {
        int num = 7;
        System.out.println(isPrime(num));
    }

    public static boolean isPrime(int n) {
        if (n < 3) return true;

        for (int i = 2; i <= (n / 2); i++) {
            if (n % i == 0) return false;
        }

        return true;
    }
}
