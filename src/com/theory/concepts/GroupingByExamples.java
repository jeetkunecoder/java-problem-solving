package com.theory.concepts;

import java.util.*;
import java.util.stream.Collectors;

public class GroupingByExamples {
  public static void main(String[] args) {
    // Simple Grouping
    // Result: {1=[a], 2=[bb, cc], 3=[ddd]}
    List<String> strings = Arrays.asList("a", "bb", "cc", "ddd");
    Map<Integer, List<String>> result1 = strings.stream()
        .collect(Collectors.groupingBy(String::length));

    // Single grouping into a custom map implementation
    TreeMap<Integer, List<String>> result2 = strings.stream()
        .collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toList()));

    // Single grouping providing a custom downstream collection
    Map<Integer, TreeSet<String>> result3 = strings.stream()
        .collect(Collectors.groupingBy(String::length, Collectors.toCollection(TreeSet::new)));

    // Grouping and counting items
    Map<Integer, Long> result4 = strings.stream()
        .collect(Collectors.groupingBy(String::length, Collectors.counting()));

    // Grouping and combining items as strings
    Map<Integer, String> result5 = strings.stream()
        .collect(Collectors.groupingBy(String::length, Collectors.joining(",","{", "}")));

  }

}
