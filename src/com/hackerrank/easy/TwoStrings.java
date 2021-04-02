package com.hackerrank.easy;

import java.util.*;

/**
 * Time Complexity: O(n)
 * - A couple of loops through the length of the strings
 *   means O(s1.length() + s2.length())
 *
 * Space Complexity: Approx O(n)
 * - In the worst case scenario we store all the
 *   characters of s1 in the set
 */

public class TwoStrings {

    public static void main(String[] args) {
        String s1 = "wouldyoulikefries", s2 = "abcabcabcabcabcabc";
        String s3 = "writetoyourparents", s4 = "fghmqzldbc";
        System.out.println(shareSubstring(s1, s2));
        System.out.println(shareSubstring(s3, s4));
    }

    static String shareSubstring(String s1, String s2) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
            set.add(s1.charAt(i));
        }
        for (int j = 0; j < s2.length(); j++) {
            if (set.contains(s2.charAt(j))) {
                return "YES";
            }
        }
        return "NO";
    }
}
