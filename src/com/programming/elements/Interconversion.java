package com.programming.elements;

public class Interconversion {

    public static void main(String[] args) {
        System.out.println(stringToInt("200"));
        System.out.println(intToString(2500));
    }

    public static String intToString(int n) {
        boolean isNegative = false;
        if (n < 0) {
            isNegative = true;
        }

        StringBuilder sb = new StringBuilder();
        do {
            sb.append((char)('0' + Math.abs(n % 10)));
            n /= 10;
        } while(n != 0);

        if (isNegative) sb.append('-');
        return sb.reverse().toString();
    }

    public static int stringToInt(String s) {
        int result = 0;
        for (int i = s.charAt(0) == '-' ? 1 : 0; i < s.length(); ++i) {
            final int digit = s.charAt(i) - '0';
            result = result * 10 + digit;
        }
        return s.charAt(0) == '-' ? -result : result;
    }
}
