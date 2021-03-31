package com.programming.elements.sorting;

import java.util.Arrays;

/**
 * Time Complexity: O(n^2)
 * - As we have two nested loops
 *
 * Space Complexity: O(1)
 * - No additional space is utilized
 *   besides a temporary variable
 */

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {5, 7, 4, 9, 10, 2, 6, 1};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        boolean needsIteration = true;
        while(needsIteration) {
            needsIteration = false;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < arr[i - 1]) {
                    swap(i, i - 1, arr);
                    needsIteration = true;
                }
            }
        }
    }

    public static void swap(int a, int b, int[] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
