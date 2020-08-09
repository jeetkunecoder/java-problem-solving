package com.leetcode.arrays;

public class FindPivotIndex {

  public static void main(String[] args) {
    int[] a = {1, 7, 3, 6, 5, 6}; // answer 3
    int[] b = {1, 2, 3}; // answer -1
    int[] c = {-1, -1, -1, 0, 1, 1}; // answer 0

    int result = pivotIndex(b);
    System.out.println(result);
   }

  public static int pivotIndex(int[] nums) {
    if (nums.length < 3) return -1;
    int[] sums = new int[nums.length];
    int accumulator = 0;
    int pivot = -1;

    // 1. Pre-compute sums
    for (int i = 0; i < nums.length; i ++) {
      accumulator += nums[i];
      sums[i] = accumulator;
    }

    // 2. Get left side and right side sums
    //    and compare if they're equal.
    for (int i = 0; i < sums.length; i++) {
      int leftSum = 0, rightSum = 0;
      if (i > 0) leftSum = sums[i - 1];
      if (i < sums.length - 1) rightSum = sums[sums.length - 1] - leftSum - nums[i];
      if (leftSum == rightSum) {
        pivot = i;
        break;
      }
    }

    return pivot;
  }
}
