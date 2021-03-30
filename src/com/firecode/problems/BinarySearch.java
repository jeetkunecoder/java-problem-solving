package com.firecode.problems;

/**
 * Time Complexity: O(log(n))
 * - At every cycle, the array halves
 *
 * Space Complexity: O(1)
 * - No additional space is utilized
 */

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 2};
        int n = 6;
        System.out.println(binarySearch(arr, n));
    }

    public static Boolean binarySearch(int[] arr, int n) {

        int start = 0, end = arr.length - 1;

        while (start <= end) {
            int pivot = (start + end) / 2;
            if (arr[pivot] == n)
                return true;
            else if (n < arr[pivot]) {
                end = pivot - 1;
            }
            else if (n > arr[pivot] ) {
                start = pivot + 1;
            }
        }
        return false;
    }
}
