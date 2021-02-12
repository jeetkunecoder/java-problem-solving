package com.theory.concepts;

import java.util.Map;
import java.util.HashMap;

public class AppearsOnce {
  public static void main(String[] args) {
    int[] arr = new int[]{1, 2, 3, 4, 1, 2, 4, 3, 5};
    System.out.println(singleNumber(arr));
  }

  public static int singleNumber(int[] A) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int key : A) map.merge(key, 1, Integer::sum);
    for (int key : A) {
      if (map.get(key) == 1) return key;
    }
    return -1;
  }
}
