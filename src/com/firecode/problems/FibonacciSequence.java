package com.firecode.problems;

import java.util.HashMap;
import java.util.Map;

public class FibonacciSequence {

    public static void main(String[] args) {
        System.out.println(fib(7));
        System.out.println(fib1(8));
        System.out.println(fib2(8));
    }

    /**
     * Approach 1: Recursion
     * Time Complexity: O(2^n)
     *
     * Inefficient, repetitive work
     */

    public static int fib(int n) {
        return (n <= 1) ? n : fib(n - 1) + fib(n - 2);
    }

    /**
     * Approach 2: Dynamic Programming
     *
     * Store the Fibonacci numbers calculated so far
     * and use them to calculate the next one in a single pass.
     *
     * Time & Space complexity: O(n)
     */

    public static int fib1(int n) {
        long start = System.nanoTime();
        Map<Integer, Integer> cache = new HashMap<>();

        cache.put(0, 0);
        cache.put(1, 1);

        for (int i = 2; i <= n; i++) {
            int value = cache.get(i - 1) + cache.get(i - 2);
            cache.put(i, value);
        }

        long end = System.nanoTime();
        System.out.println(end - start);

        return cache.get(n);
    }

    /**
     * Approach 3: Store the last 2 numbers
     *
     * In the previous solution we have used a
     * map to store the output at every step,
     * which increases the space complexity of
     * the solution. Let's avoid that by storing
     * only the previous 2 fibonacci numbers.
     *
     * After all, we only need the previous 2 numbers
     * to calculate the next numbers of the fibonacci sequence;
     */

    public static int fib2(int n) {
        long start = System.nanoTime();
        int firstNum = 0, secondNum = 1, temp = 0;

        for (int i = 2; i <= n; i++) {
            temp = firstNum + secondNum;
            firstNum = secondNum;
            secondNum = temp;
        }

        long end = System.nanoTime();
        System.out.println(end - start);

        return temp;
    }
}
