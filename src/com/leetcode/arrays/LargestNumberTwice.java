package com.leetcode.arrays;

public class LargestNumberTwice {

  public static void main(String[] args) {
    int[] a = {3, 6, 1, 0};
    int[] b = {1, 2, 3, 4};

    System.out.println(dominantIndex(a));
  }

  public static int dominantIndex(int[] nums) {
    // 1. Find the max element and its index
    int max = -1, maxIndex = -1;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > max) {
        max = nums[i];
        maxIndex = i;
      }
    }

    // 2. Loop and check if there's an x => 2*x > max
    for (int j = 0; j < nums.length; j++) {
      if (max < 2 * nums[j] && j != maxIndex) {
        max = -1;
        maxIndex = -1;
      }
    }

    return maxIndex;
  }
}
