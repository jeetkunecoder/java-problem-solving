package com.educative.concepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array {

    public static int[] removeEven(int[] arr) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                result.add(arr[i]);
            }
        }
        int[] temp = new int[result.size()];
        int index = 0;
        for (Integer i : result) {
            temp[index] = i;
            index++;
        }
        return temp;
    }

    public static int[] removeEven2(int[] arr) {
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                arr[index] = arr[i];
                index++;
            }
        }
        return Arrays.copyOf(arr, index);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 10, 6, 3};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(removeEven(arr)));
    }
}
