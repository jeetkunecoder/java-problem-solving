package com.educative.challenges;

import java.util.Arrays;

public class MergeSortedArrays {

    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        int i = 0, j = 0;
        int len = arr1.length + arr2.length;
        int[] result = new int[len];

        while (i < arr1.length || j < arr2.length) {
            if (i == arr1.length) {
                result[i + j] = arr2[j];
                j++;
            }
            else if (j == arr2.length) {
                result[i + j] = arr2[i];
                i++;
            }
            else {
                if (arr1[i] <= arr2[j]) {
                    result[i + j] = arr1[i];
                    i++;
                }
                else {
                    result[i + j] = arr2[j];
                    j++;
                }
            }
        }
        return result;
    }

    public static int[] mergeArrays2(int[] arr1, int[] arr2) {
        int SIZE = arr1.length + arr2.length;
        int[] result = new int[SIZE];

        for (int i = 0, j = 0; i < arr1.length || j < arr2.length; ) {
            if (i >= arr1.length) {
                result[i + j] = arr2[j];
                j++;
            }
            else if (j >= arr2.length) {
                result[i + j] = arr1[i];
                i++;
            }
            else {
                if (arr1[i] < arr2[j]) {
                    result[i + j] = arr1[i];
                    i++;
                }
                else {
                    result[i + j] = arr2[j];
                    j++;
                }
            }
        }
        return result;
    }

    public static int[] mergeArrays3(int[] arr1, int[] arr2) {
        int s1 = arr1.length;
        int s2 = arr2.length;
        int[] resultantArray = new int[s1+s2];
        int i = 0, j = 0, k = 0;

        while (i < s1 && j < s2) {
            if (arr1[i] < arr2[j])
                resultantArray[k++] = arr1[i++];
            else
                resultantArray[k++] = arr2[j++];
        }

        while (i < s1)
            resultantArray[k++] = arr1[i++];

        while (j < s2)
            resultantArray[k++] = arr2[j++];

        return resultantArray;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 4, 5};
        int[] b = new int[]{2, 6, 7, 8};
        System.out.println(Arrays.toString(mergeArrays3(a, b)));
    }
}
