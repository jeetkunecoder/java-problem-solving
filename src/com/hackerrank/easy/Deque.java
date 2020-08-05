package com.hackerrank.easy;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Deque {

  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    ArrayDeque<Integer> deque = new ArrayDeque<>();
    Set<Integer> s = new HashSet<>();

    int n = in.nextInt();
    int m = in.nextInt();
    int max = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {
      int val = in.nextInt();
      deque.add(val);
      s.add(val);

      if(deque.size() == m){
        if(s.size() > max) max = s.size();
        int first = deque.remove();
        if(!deque.contains(first)) s.remove(first);
      }
    }

    System.out.println(max);
    in.close();
  }
}
