package com.hackerrank.easy;

import java.util.Arrays;
import java.util.List;

public class CompareTriplets {

  static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
    int totalA = 0, totalB = 0;

    for (int i = 0; i < a.size(); i++) {
      int pointsA = a.get(i), pointsB = b.get(i);
      if (pointsA > pointsB) totalA++; else if (pointsB > pointsA) totalB++;
    }

    return Arrays.asList(totalA, totalB);
  }

  public static void main(String[] args) {
    List<Integer> a = Arrays.asList(5, 6, 7);
    List<Integer> b = Arrays.asList(3, 6, 10);
    List<Integer> result = compareTriplets(a, b);
    System.out.println(result);
  }
}
