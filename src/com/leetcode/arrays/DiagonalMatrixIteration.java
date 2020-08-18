package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.Collections;

public class DiagonalMatrixIteration {

  public int[] findDiagonalOrder(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return new int[0];
    }

    int N = matrix.length;
    int M = matrix[0].length;
    int[] result = new int[N * M];
    int k = 0;
    ArrayList<Integer> intermediate = new ArrayList<>();

    // Find the diagonal head
    for (int d = 0; d < N + M - 1; d++) {
      intermediate.clear();
      int r = d < M ? 0 : d - M + 1;
      int c = d < M ? d : M - 1;

      // Iterate the diagonal until one
      // of the indices goes out of scope
      while (r < N && c > -1) {
        intermediate.add(matrix[r][c]);
        ++r;
        --c;
      }

      // Reverse odd diagonals
      if (d % 2 == 0) {
        Collections.reverse(intermediate);
      }

      // Fill the result array
      for (int i = 0; i < intermediate.size(); i++) {
        result[k++] = intermediate.get(i);
      }
    }
    return result;
  }
}
