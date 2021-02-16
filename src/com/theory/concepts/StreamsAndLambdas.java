package com.theory.concepts;

import java.util.List;

public class StreamsAndLambdas {

  public static void main(String[] args) {
    List<String> alphaList = List.of("C", "A", "B", "D");
    synchronized (alphaList) {
      String s = alphaList
          .parallelStream()
          .sorted()
          .findAny()
          .get();

      System.out.println("s is " + s);
    }
  }
}
