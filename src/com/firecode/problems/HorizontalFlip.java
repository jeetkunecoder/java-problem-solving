package com.firecode.problems;

import java.util.Arrays;

public class HorizontalFlip {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        System.out.println(Arrays.deepToString(matrix));
        flipHorizontalAxis(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void flipHorizontalAxis(int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = matrix[j][i];
                int end = matrix.length - j - 1;
                matrix[j][i] = matrix[end][i];
                matrix[end][i] = temp;
            }
        }
    }
}
