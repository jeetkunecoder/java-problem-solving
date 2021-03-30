package com.theory.concepts;

import java.util.Arrays;

/**
 * Given an mxn 2D image matrix where each integer
 * represents a pixel. Flip it in place along its
 * vertical axis.
 */

public class FlipVerticalAxis {
  public static void main(String[] args) {
    int[][] matrix = new int[][] {{1, 0}, {2, 0}, {3, 0}};
    System.out.println(Arrays.deepToString(matrix));
    flipVertAxis(matrix);
    System.out.println(Arrays.deepToString(matrix));
  }

  /**
   * Time Complexity: O(n^2)
   * Space Complexity: O(1)
   */
  public static void flipItVerticalAxis(int[][] matrix) {
    for (int row = 0; row < matrix.length; row++) {
      int colLimit = matrix[row].length;
      for (int col = 0; col < colLimit; col++) {
        if (colLimit - 1 - col <= col) continue;
        int temp = matrix[row][col];
        matrix[row][col] = matrix[row][colLimit - 1 - col];
        matrix[row][colLimit - 1 - col] = temp;
      }
    }
  }

  public static void flipVertAxis(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length / 2; j++) {
        int end = matrix[i].length - 1;
        int temp = matrix[i][j];
        matrix[i][j] = matrix[i][end - j];
        matrix[i][end - j] = temp;
      }
    }
  }

  public static void flipItVerticalAxis2(int[][] matrix) {
    for (int[] row : matrix) reverseRow(row);
  }

  public static void reverseRow(int[] row) {
    int i = 0, j = row.length - 1;
    while (i < j) {
      int temp = row[i];
      row[i] = row[j];
      row[j] = temp;
      i++;
      j--;
    }
  }
}
