package com.coderbyte.challenge;

import java.util.*;

public class FindIntersection {

    public static String findIntersection(String[] strArr) {
        if (strArr[0].equals("") || strArr[1].equals("")) return "false";

        String[] arr1 = strArr[0].split(",");
        String[] arr2 = strArr[1].split(",");
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i].equals(arr2[j])) result.add(String.valueOf(arr1[i]));
            }
        }

        for (String s : result) sb.append(s).append(",");

        if (sb.length() > 0) {
            return sb.substring(0, sb.length() - 1).replaceAll(" ", "");
        }
        else {
            return "false";
        }
    }

    public static void main (String[] args) {
        String[] strArr = new String[] {"1,2", "2"};
        System.out.print(findIntersection(strArr));
    }
}
