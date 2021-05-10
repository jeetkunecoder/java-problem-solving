package com.educative.challenges;

public class MaximumSumSubArray {

    public static void main(String[] args) {
        int[] arr = {-7, 6, -2};
        System.out.println(findMaxSumSubArray(arr));
    }

    public static int findMaxSumSubArray(int[] arr) {
        int total = 0;
        int tmp = 0;

        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }

        int max = total;

        for (int i = 0; i < arr.length; i++) {
            tmp += arr[i];
            if (tmp > max) {
                max = tmp;
            }
        }

        int sum = total;

        for (int i = 0; i < arr.length; i++) {
            sum -= arr[i];
            if (sum > max) {
                max = sum;
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }
}
