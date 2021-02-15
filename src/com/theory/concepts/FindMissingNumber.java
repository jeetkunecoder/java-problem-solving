package com.theory.concepts;

import java.util.Arrays;

public class FindMissingNumber {
  public static void main(String[] args) {
    int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    System.out.println(findMissingNumber2(arr));
  }

  public static int findMissingNumber(int[] arr) {
    int result = -1;
    Arrays.sort(arr);
    for (int i = 1; i <= 10; i++) {
      if (i == 10) return i;
      if (arr[i - 1] != i) {
        result = i;
        break;
      }
    }
    return result;
  }

  public static int findMissingNumber2(int[] arr) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
    }
    return (55 - sum);
  }
}
