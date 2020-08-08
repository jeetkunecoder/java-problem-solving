package com.leetcode.arrays;

public class EvenNumberDigits {

  public static void main(String[] args) {
    int[] nums = {252, 134, 12};
    int total = findNumbers(nums);
    System.out.println(total);
  }

  public static int findNumbers(int[] nums) {
    int total = 0;
    for (int i = 0; i < nums.length; i++) {
      if (hasEvenAmountOfNumbers(nums[i])) total++;
    }
    return total;
  }

  public static boolean hasEvenAmountOfNumbers(int num) {
    int counter = 0;
    while (num > 0) {
      int current = num / 10;
      counter++;
      num = current;
    }
    return counter % 2 == 0;
  }
}
