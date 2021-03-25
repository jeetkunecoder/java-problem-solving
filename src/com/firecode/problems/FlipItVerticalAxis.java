package com.firecode.problems;

public class FlipItVerticalAxis {

    public static void main(String[] args) {
        int[][] arr = {{1, 0}, {1, 0}};
        printArr(arr);
        flipItVerticalAxis(arr);
        System.out.println();
        printArr(arr);
    }

    public static void flipItVerticalAxis(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int end = matrix[i].length - 1;
            for (int j = 0; j <= end; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][end];
                matrix[i][end] = temp;
                end--;
            }
        }
    }

    public static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println(arr[i][j]);
            }
        }
    }
}
