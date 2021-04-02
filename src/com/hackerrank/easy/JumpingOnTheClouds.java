package com.hackerrank.easy;

import java.util.Arrays;

public class JumpingOnTheClouds {

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 0, 0, 1, 0};
        System.out.println(Arrays.toString(arr));
        System.out.println(jumpingOnClouds(arr));
    }

    static int jumpingOnClouds(int[] c) {
        int counter = 0;
        for (int i = 0; i < c.length - 1; ) {
            // Check the number of steps for the latest item
            int step = (i + 2 <= c.length - 1) ? i + 2 : i + 1;
            i = (c[step] == 0) ? i + 2 : i + 1;
            counter++;
        }
        return counter;
    }

}
