package com.leetcode.arrays;

import java.util.Vector;

public class PlusOne {

  /**
   * Problem: Sum 1 to a number represented in a vector
   * For Example: {1, 2, 3} -> {1, 2, 4}
   *              {9, 9, 9} -> {1, 0, 0, 0}
   */

  static void plusOne(Vector<Integer> a) {
    int n = a.size();

    // Add 1 to the last digit and find carry
    a.set(n - 1, a.get(n - 1) + 1);
    int carry = a.get(n - 1) / 10;
    a.set(n - 1, a.get(n - 1) % 10);

    // Traverse from the second last digit
    for (int i = n - 2; i >= 0; i--) {
      if (carry == 1) {
        a.set(i, a.get(i) + 1);
        carry = a.get(i) / 10;
        a.set(i, a.get(i) % 10);
      }
    }

    if (carry == 1) a.add(0, 1);
  }
}
