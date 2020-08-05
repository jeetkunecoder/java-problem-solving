package com.leetcode.arrays;

public class MaxConsecutiveOnes {

  public static void main(String[] args) {
    int[] nums = {1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 2, 4, 5};
    int total = findMaxConsecutiveOnes(nums);
    System.out.println(total);
  }

  public static int findMaxConsecutiveOnes(int[] nums) {
    if (nums.length == 0) return 0;

    int start = 0;
    int end = 0;
    int total = 0;

    while (end < nums.length) {
      if (nums[end] == 1) {
        end++;
      }
      else {
        total = Math.max(total, end - start);
        end++;
        start = end;
      }
    }

    return Math.max(total, end - start);
  }
}
