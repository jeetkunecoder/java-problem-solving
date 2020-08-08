package com.leetcode.arrays;

public class MergeSortedArrays {

  public static void main(String[] args) {
    int[] nums1 = {1, 2, 3, 0, 0, 0};
    int[] nums2 = {2, 5, 6};

    int m = 3, n = 3;

    merge(nums1, m, nums2, n);
  }

  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = 0, j = 0, k = 0;

    int[] nums3 = new int[m + n];

    while (i < m && j < n) {
      if (nums1[i] < nums2[j]) {
        nums3[k++] = nums1[i];
        i++;
      }
      else {
        nums3[k++] = nums2[j];
        j++;
      }
    }

    // Store remaining values
    while (i < m) {
      nums3[k++] = nums1[i++];
    }

    while (j < n) {
      nums3[k++] = nums2[j++];
    }

    // Copy values to initial array
    for (int l = 0; l < m + n; l++) {
      nums1[l] = nums3[l];
    }
  }
}
