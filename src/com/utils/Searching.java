package com.utils;

import java.util.regex.Pattern;

public class Searching {

    private static int countStringInString(String phrase, String strToFind) {
        String quote = Pattern.quote(strToFind);
        return phrase.split(quote, -1).length - 1;
    }

    public static void main(String[] args) {
        String phrase = "Hello, how are you guys today?";
        String strToFind = "today";
        countStringInString(phrase, strToFind);
    }
}
