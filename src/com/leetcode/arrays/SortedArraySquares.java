package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class SortedArraySquares {

  public static void main(String[] args) {
    int[] arr = {-7, -3, 2, 3, 11};
    int[] squares = sortSquares(arr);

    for (int i = 0; i < squares.length; i++) {
      System.out.println(squares[i]);
    }
  }

  public static int[] sortSquares(int[] A) {

    int n = A.length;
    int k;

    // Divide the array in positives and negatives
    for (k = 0; k < n; k++) {
      if (A[k] >= 0) break;
    }

    // Last index of first half
    int i = k - 1;

    // Initial index of second half
    int j = k;

    // Initial index of temporary array
    int ind = 0;

    int[] temp = new int[n];

    while(i >= 0 && j < n) {
      if (A[i] * A[i] < A[j] * A[j]) {
        temp[ind] = A[i] * A[i];
        i--;
      }
      else {
        temp[ind] = A[j] * A[j];
        j++;
      }

      ind++;
    }

    while(i >= 0) {
      temp[ind++] = A[i] * A[i];
      i--;
    }

    while(j < n) {
      temp[ind++] = A[j] * A[j];
      j++;
    }

    return temp;
  }

  public static int[] sortSquares2(int[] A) {
    ArrayList<Integer> temp = new ArrayList<>();
    for (int i = 0; i < A.length; i++) {
      temp.add(i, (int)Math.pow(A[i], 2));
    }
    int[] totals = temp.stream().mapToInt(i -> i).toArray();
    Arrays.sort(totals);
    return totals;
  }

  public static int[] sortSquares3(int[] A) {
    for (int i = 0; i < A.length; i++) {
      A[i] = A[i] * A[i];
    }
    Arrays.sort(A);
    return A;
  }
}
