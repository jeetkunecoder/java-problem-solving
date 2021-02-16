package com.theory.concepts;

import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

public class BalancedParenthesis {

  public static void main(String[] args) {
    System.out.println(isBalanced("[{()}]"));
  }

  static String isBalanced(String s) {
    Map<Character, Character> myMap = new HashMap<>();

    myMap.put(')', '(');
    myMap.put(']', '[');
    myMap.put('}', '{');
    boolean balanced = true;
    char[] items = s.toCharArray();
    Stack<Character> st = new Stack<>();

    for (int i = 0; i < items.length && balanced; i++) {
      if (myMap.containsValue(items[i])) {
        st.push(items[i]);
      }
      if (myMap.containsKey(items[i])) {
        if (st.isEmpty()) return "NO";
        balanced = st.pop().equals(myMap.get(items[i]));
      }
    }

    if (!st.isEmpty()) return "NO";
    return balanced ? "YES" : "NO";
  }
}
