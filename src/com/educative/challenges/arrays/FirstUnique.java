package com.educative.challenges;

import java.util.*;

public class FirstUnique {

    public static void main(String[] args) {
        int[] arr = {9, 2, 3, 2, 6, 6};
        System.out.println(findFirstUnique(arr));
    }

    public static int findFirstUnique(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int val = map.getOrDefault(arr[i], 0);
            map.put(arr[i], val + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == 1) {
                return arr[i];
            }
        }

        return -1;
    }

}


