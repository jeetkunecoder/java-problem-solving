package com.programming.elements;

public class Palindromic {

    public static void main(String[] args) {
        System.out.println(isPalindromic("racecar"));
    }

    public static boolean isPalindromic(String str) {
        return (new StringBuilder(str).reverse().toString().equals(str));
    }

    public boolean isPalindromic2(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, --j) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }
}
