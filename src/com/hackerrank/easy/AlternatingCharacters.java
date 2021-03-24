package com.hackerrank.easy;

public class AlternatingCharacters {

    public static void main(String[] args) {
        System.out.println(alternatingCharacters("AAABBB"));
    }

    public static int alternatingCharacters(String s) {
        int itemsToDelete = 0;
        if (s.length() > 1) {
            for (int i = 0; i < s.length() - 1; i++) {
                char a = s.charAt(i);
                char b = s.charAt(i + 1);
                if (a == b) itemsToDelete++;
            }
        }
        return itemsToDelete;
    }
}
