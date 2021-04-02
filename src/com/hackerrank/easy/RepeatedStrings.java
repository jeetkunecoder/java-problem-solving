package com.hackerrank.easy;

public class RepeatedStrings {

    public static void main(String[] args) {
        String s = "aba";
        long n = 10;
        System.out.println(repeatedString(s, n));
    }

    static long repeatedString(String s, long n) {
        int factor = 0;

        // Loop through the string once to
        // find the multiplication factor
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                factor++;
            }
        }

        long counter = n / s.length();
        long result = counter * factor;
        long remainder = n % s.length();

        // Add the remaining a's
        for (int j = 0; j < remainder; j++) {
            if(s.charAt(j) == 'a') {
                result++;
            }
        }
        return result;
    }
}
