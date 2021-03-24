package com.hackerrank.easy;

import java.util.*;

/**
 * Given two arrays, find their common elements.
 *
 * For example:
 * - Input: arr1 -> {"I", "love", "playing", "soccer"}
 *          arr2 -> {"love", "soccer", "soccer"}
 *
 * - Output: {"love", "soccer"}
 */

public class CommonElementsInArray {

    public static void main(String[] args) {
        String[] arr1 = {"I", "love", "playing", "soccer"};
        String[] arr2 = {"love", "soccer", "soccer"};
        String[] result = findCommonElements(arr1, arr2);

        for (String word : result) {
            System.out.println(word);
        }

        System.out.println(Arrays.toString(result));
    }

    public static String[] findCommonElements(String[] arr1, String[] arr2) {
        List<String> commonItems = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            for(int j = 0; j < arr2.length; j++) {
                if (arr1[i].equals(arr2[j]) && !commonItems.contains(arr1[i])) {
                    commonItems.add(arr1[i]);
                }
            }
        }
        return commonItems.toArray(new String[0]);
    }
}
