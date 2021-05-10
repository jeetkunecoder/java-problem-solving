package com.educative.challenges;

import java.util.Arrays;

public class RearrangeNumbers {

    public static void main(String[] args) {

        int[] arr = {10, -1, 9, -7, 8, -9};
        reArrange(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void reArrange(int[] arr) {
        int[] tmp = new int[arr.length];
        int start = 0, end = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                tmp[start] = arr[i];
                start++;
            }
            else {
                tmp[end] = arr[i];
                end--;
            }
        }
        for (int i = 0; i < tmp.length; i++) {
            arr[i] = tmp[i];
        }
    }
}

