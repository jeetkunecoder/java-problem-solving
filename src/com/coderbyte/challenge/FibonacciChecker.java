package com.coderbyte.challenge;

import java.util.ArrayList;
import java.util.List;

public class FibonacciChecker {
    public static String FibonacciChecker(int num) {
        boolean res =  perfSq(4 + 5 * num * num) || perfSq(-4 + 5 * num * num);
        return res ? "yes" : "no";
    }

    public static boolean perfSq(int num) {
        int sq = (int) Math.sqrt(num);
        boolean result = (sq * sq == num);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(FibonacciChecker(54));
    }
}
