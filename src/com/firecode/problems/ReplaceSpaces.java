package com.firecode.problems;

public class ReplaceSpaces {

    public static void main(String[] args) {
        String a = "This is a test";
        String b = "/";
        System.out.println(replace(a, b));
    }

    public static String replace(String a, String b) {
        String[] words = a.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
            if (i < words.length - 1) sb.append(b);
        }
        return sb.toString();
    }
}
