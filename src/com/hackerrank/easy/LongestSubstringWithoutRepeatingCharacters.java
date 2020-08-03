package com.hackerrank.easy;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

  public static int longestSubstring(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int start = 0;
    int end = 0;
    int total = 0;

    while (end < s.length()) {
      start = Math.max(start, map.getOrDefault(s.charAt(end), -1));
      map.put(s.charAt(end), end);
      total = Math.max(end - start, total);
      end++;
    }
    return total;
  }

  public static void main(String[] args) {
    System.out.println(longestSubstring("ABCDEFGHABADEC"));
  }
}
