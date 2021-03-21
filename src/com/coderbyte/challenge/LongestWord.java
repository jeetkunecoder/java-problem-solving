package com.coderbyte.challenge;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class LongestWord {

    public static String LongestWord(String sen) {
        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(sen);
        String longest = "";

        while (m.find()) {
            String match = m.group();
            if (match.length() > longest.length()) {
                longest = match;
            }
        }
        return longest;
    }

    public static void main (String[] args) {
        String word = "a confusing /:sentence:/[ this is not!!!!!!!~";
        System.out.print(LongestWord(word));
    }
}

