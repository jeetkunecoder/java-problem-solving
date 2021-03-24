package com.hackerrank.easy;

import java.util.HashMap;
import java.util.Map;

public class MakingAnagrams {

    public static void main(String[] args) {
        String a = "cde";
        String b = "dcf";
        System.out.println(makeAnagrams(a, b));
    }

    public static int makeAnagrams(String s1, String s2) {
        Map<Character, Integer> count = new HashMap<>();
        int totalDeletions = 0;

        for (char ch : s1.toCharArray()) {
            int ct = count.getOrDefault(ch, 0);
            count.put(ch, ct + 1);
        }

        for (char ch : s2.toCharArray()) {
            int ct = count.getOrDefault(ch, 0);
            count.put(ch, ct - 1);
        }

        for (int val : count.values()) {
            totalDeletions += Math.abs(val);
        }

        return totalDeletions;
    }
}
