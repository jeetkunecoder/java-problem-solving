package com.theory.concepts;

import java.util.*;

/**
 * HashMap
 * - Maintains key/value associations
 * - Uses a technique called hashing. This technique
 * converts
 */

public class TypesOfMap {

  public static void main(String[] args) {
    Map<String, Integer> empSal = new HashMap<>(10, 0.5f);

    empSal.put("Juan", 10000);
    empSal.put("Simon", 7000);
    empSal.put("Maria", 3000);

    // Print keys
    System.out.println(empSal.keySet());

    System.out.println(empSal.values());

    Map<Character, Integer> myMap = new LinkedHashMap<>();

    myMap.put('a', 2);
    myMap.put('b', 3);
    myMap.put('d', 1);

    for (Character c : myMap.keySet()) {
      System.out.println(c);
    }
  }
}
