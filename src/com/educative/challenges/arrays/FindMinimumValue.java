package com.educative.challenges;

public class FindMinimumValue {

    public static void main(String[] args) {
        int[] arr = {9, 2, 3, 6};
        System.out.println(findMinimum(arr));
    }

    public static int findMinimum(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}
