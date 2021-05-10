package com.educative.challenges;

import java.util.Arrays;

public class ArrayOfProducts {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(findProduct(arr)));
    }

    public static int[] calculateProducts(int[] arr) {
        if (arr.length < 1) return arr;
        int product = 1;
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (j != i) {
                    product *= arr[j];
                }
            }
            result[i] = product;
            product = 1;
        }
        return result;
    }

    public static int[] findProduct(int[] arr) {
        int n = arr.length;
        int i, temp = 1;
        int[] result = new int[n];

        for (i = 0; i < n; i++) {
            result[i] = temp;
            temp *= arr[i];
        }

        temp = 1;

        for (i = n - 1; i >= 0; i--) {
            result[i] *= temp;
            temp *= arr[i];
        }

        return result;
    }
}
