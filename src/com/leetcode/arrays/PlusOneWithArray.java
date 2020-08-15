package com.leetcode.arrays;

public class PlusOneWithArray {

  public static int[] plusOne(int[] digits) {
    int n = digits.length;

    int remainder = (digits[n - 1] + 1) % 10;
    int carry = (digits[n - 1] + 1) / 10;
    digits[n - 1] = remainder;

    for (int i = n - 2; i >= 0; i--) {
      remainder = (digits[i] + carry) % 10;
      carry = (digits[i] + carry) / 10;
      digits[i] = remainder;
    }

    if (carry == 1) {
      int[] result = new int[n + 1];
      result[0] = 1;
      for (int i = 1; i < result.length; i ++) {
        result[i] = digits[i - 1];
      }
      return result;
    }
    return digits;
  }

  public static void main(String[] args) {
    int[] arr = {9, 9};
    int[] result = plusOne(arr);
    for (int i = 0; i < result.length; i++) {
      System.out.println(result[i]);
    }
  }
}
