package com.firecode.problems;

public class Palindromes {

    public static void main(String[] args) {
        String str1 = "madam";
        String str2 = "race car";

        System.out.println(isPalindrome(str1));
        System.out.println(isPalindrome2(str2));
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static boolean isPalindrome(String str) {
        if (str == null) return true;
        int start = 0, end = str.length() - 1;
        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    /**
     * Time and Space Complexity: O(n)
     */
    public static boolean isPalindrome2(String str) {
        StringBuilder sb = new StringBuilder(str).reverse();
        return str.equals(sb.toString());
    }
}
