package com.educative.challenges;

import java.util.Arrays;

public class FindSecondMaximum {

    public static void main(String[] args) {
        int[] arr = {9, 2, 3, 5, 2, 7};
        System.out.println(findSecondMaximum(arr));
    }

    public static int findSecondMaximum(int[] arr) {
        if (arr.length < 2) return -1;
        Arrays.sort(arr);
        int max = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < max) {
                return arr[i];
            }
        }
        return -1;
    }

    public static int findSecondMaximum2(int[] arr) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > secondMax && arr[i] < max) {
                secondMax = arr[i];
            }
        }

        return secondMax;
    }

    public static int findSecondMaximum3(int[] arr) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            }
            else if (arr[i] > secondMax && arr[i] != max) {
                secondMax = arr[i];
            }
        }

        return secondMax;
    }
}
