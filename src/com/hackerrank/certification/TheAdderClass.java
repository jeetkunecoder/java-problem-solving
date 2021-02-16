package com.hackerrank.certification;

import java.util.Scanner;

abstract class Calculator {
  abstract int add(int a, int b);
}

class Adder extends Calculator {
  int add(int a, int b) {
    return a + b;
  }
}

public class TheAdderClass {
  public static void main(String[] args) {
    int a, b;
    try (Scanner sc = new Scanner(System.in)) {
      a = sc.nextInt();
      b = sc.nextInt();

      Calculator adderObject = new Adder();
      System.out.println(adderObject.add(a, b));
    }
  }
}
