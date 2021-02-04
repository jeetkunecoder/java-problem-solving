package com.theory.concepts;

import java.util.Hashtable;

public class Fibonacci {
  public static void main(String[] args) {
    System.out.println(fib(15));
  }

  /**
   * Time Complexity:
   * -  O(2^n)
   * Space Complexity:
   * - O(1)
   */
  public static int fib(int n) {
    if (n == 0 || n == 1) return n;
    return fib(n - 1) + fib(n - 2);
  }

  /**
   * Short and concise
   */
  public static int fib2(int n) {
    return (n < 2) ? n : fib(n - 1) + fib(n -2);
  }

  /**
   * Dynamic programming
   * - Performance improvement in space by caching
   *   values and avoiding additional calculations
   *   if they were done before already.
   */
  static Hashtable<Integer, Integer> memo = new Hashtable<>();
  public static int fib3(int n) {
    if (n < 2) return n;
    memo.putIfAbsent(n, fib(n -1) + fib(n - 2));
    return memo.get(n);
  }
}
