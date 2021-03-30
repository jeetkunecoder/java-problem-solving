package com.firecode.problems;

import java.util.*;

public class FindDuplicates {

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 2, 1};
        System.out.println(duplicate(arr));
        System.out.println(duplicate2(arr));
    }

    public static String duplicate(int[] numbers){

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            int key = numbers[i];
            int count = map.getOrDefault(key, 0);
            if (count < 2) {
                map.put(key, count + 1);
                count += 1;
            }
            if (count == 2) result.add(key);
        }

        return Arrays.toString((result.stream().sorted().toArray()));
    }

    public static String duplicate2(int[] numbers) {
        TreeSet<Integer> result = new TreeSet<>();
        Arrays.sort(numbers);

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == numbers[i - 1]) result.add(numbers[i]);
        }
        return result.toString();
    }
}
