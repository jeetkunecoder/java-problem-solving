package com.programming.elements.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {9, 5, 6, 7, 4, 3, 2, 5};
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int begin, int end) {
        if (end <= begin) return;
        int pivot = partition(arr, begin, end);
        quickSort(arr, begin, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    static int partition(int[] arr, int begin, int end) {
        int counter = begin;

        for (int i = begin; i < end; i++) {
            if (arr[i] < arr[end]) {
                swap(arr, counter, i);
                counter++;
            }
        }
        swap(arr, end, counter);
        return counter;
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
