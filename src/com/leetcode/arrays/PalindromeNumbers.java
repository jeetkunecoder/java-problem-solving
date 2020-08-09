package com.leetcode.arrays;

public class PalindromeNumbers {

  public boolean isPalindrome(int x)
  {
    if (x < 0) return false;
    double log = Math.log10(x);
    int totalDigits = (int) Math.floor(log) + 1;
    int mask = (int) Math.pow(10, totalDigits - 1);

    for (int i = 0; i < totalDigits / 2; i++) {
      int start = x / mask;
      int end = x % 10;
      if (start != end) {
        return false;
      }
      x %= mask;
      x /= 10;
      mask /= 100;
    }

    return true;
  }
}
