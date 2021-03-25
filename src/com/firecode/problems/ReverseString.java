package com.firecode.problems;

public class ReverseString {

    public static void main(String[] args) {
        String str = "abcde";
        System.out.println(reverseString(str));
        System.out.println(reverseString2(str));
    }

    public static String reverseString(String str) {
        char[] chars = str.toCharArray();
        int start = 0, end = chars.length - 1;
        while (start <= end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(chars);
    }

    public static String reverseString2(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
}
