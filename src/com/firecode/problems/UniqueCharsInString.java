package com.firecode.problems;

import java.util.Arrays;

public class UniqueCharsInString {

    public static void main(String[] args) {
        String str = "edcba"; // true
        String str1 = "aa"; // false
        String str2 = ""; // true
        String str3 = null; //true
        System.out.println(areAllCharactersUnique2(str));
    }

    public static boolean areAllCharactersUnique(String str) {
        if (str == null) return true;
        char[] chars = str.toCharArray();
        Arrays.sort(chars);

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) return false;
        }
        return true;
    }

    public static boolean areAllCharactersUnique2(String str) {
        if (str == null ) return true;
        boolean[] checker = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            if (checker[str.charAt(i)]) return false;
            checker[str.charAt(i)] = true;
        }
        return true;
    }
}
