package com.educative.challenges;

import java.util.Arrays;

public class FindTwoNumbers {

    public static int[] findSum(int[] arr, int n) {
        if (arr.length < 2) return arr;
        int[] result = new int[2];
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == n) {
                    result[0] = arr[i];
                    result[1] = arr[j];
                    return result;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 21, 3, 14, 5, 60, 7, 6};
        int num = 27;
        System.out.println(Arrays.toString(findSum(arr, num)));
    }
}
