package com.educative.concepts;

import java.util.Arrays;

public class Sums {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(sum1(arr));
        System.out.println(sum2(arr));

    }

    public static int sum1(int[] arr) {
        int total = 0;
        for (int i : arr) {
            total += i * 2;
        }
        return total;
    }

    public static int sum2(int[] arr) {
        return Arrays.stream(arr).map(i -> i * 2).reduce(0, Integer::sum);
    }
}
