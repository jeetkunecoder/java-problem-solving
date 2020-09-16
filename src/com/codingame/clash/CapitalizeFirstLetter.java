package com.codingame.clash;

public class CapitalizeFirstLetter {

  public static String capitalizeFirstLetter(String s) {
    return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
  }

  public static void main(String[] args) {
    System.out.println(capitalizeFirstLetter("hello"));
  }
}
