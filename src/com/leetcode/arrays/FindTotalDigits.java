package com.leetcode.arrays;

public class FindTotalDigits {

  public static void main(String[] args) {
    int number = 93752;
    System.out.println(getAmountOfDigits(number));
  }

  public static int getAmountOfDigits(int number) {
    double log = Math.log10(number);
    return (int)(Math.floor(log) + 1);
  }
}
