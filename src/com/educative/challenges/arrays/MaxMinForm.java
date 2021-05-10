package com.educative.challenges;

import java.util.Arrays;

public class MaxMinForm {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        reArrange(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void reArrange(int[] arr) {
        int[] temp = new int[arr.length];
        int start = 0, end = arr.length - 1;
        int counter = 0;

        while(start < end) {
            temp[counter++] = arr[end];
            temp[counter++] = arr[start];
            start++;
            end--;
        }

        if (start == end) temp[counter] = arr[start];
        for (int i = 0; i < temp.length; i++) {
            arr[i] = temp[i];
        }
    }
}
