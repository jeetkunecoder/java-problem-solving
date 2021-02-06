package com.theory.concepts;
import java.util.Arrays;

public class BinarySearch {

  public static void main(String[] args) {

    int[] arr = new int[]{3, 6, 2, 8, 1, 9, 4};
    int n = 4;
    Arrays.sort(arr);
    BinarySearch myObj = new BinarySearch();
    System.out.println(Arrays.toString(arr));
    boolean numberExists = myObj.binarySearch(arr, n);
    System.out.println("Number " + n + " exists in the array? - Answer: " + numberExists);
  }

  /**
   *
   * Time Complexity: O(logN)
   * - Every time we loop the length of the input
   *   array is halved, du eto this we can see a
   *   logarithmic pattern of execution
   *
   * Space Complexity: O(1)
   * - As we're not using any additional space
   *   besides the already existing array, the
   *   space complexity is constant.
   */
  public boolean binarySearch(int[] arr, int n) {

    int start = 0, end = arr.length - 1;

    while (start <= end) {
      int pivot = (start + end) / 2;
      if (n == arr[pivot])
        return true;
      else if (n < arr[pivot])
        end = pivot - 1;
      else
        start = pivot + 1;
    }

    return false;
  }
}
