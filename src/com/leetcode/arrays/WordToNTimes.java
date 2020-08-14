package com.leetcode.arrays;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordToNTimes
{
  public static void main (String[] q)
  {
    Scanner in = new Scanner(System.in);
    String s = in.nextLine();
    Pattern p = Pattern.compile("(\\w)\\1+|[A-Za-z]");
    Matcher m = p.matcher(s);
    while (m.find()) System.out.print((m.end() - m.start()) + m.group());
    in.close();
  }
}
