package com.utils;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TextFileReader {

  public static void main(String[] args) {
    File file = new File("input.txt");

    try {
      Scanner sc = new Scanner(file);
      int counter = 1;
      while (sc.hasNext()) {
        String body = sc.nextLine();
        String s = "{ \"id\": \"" + counter + "\", \"language\": \"en\", \"text\": " + body + " },";
        System.out.println(s);
        counter++;
      }
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }
}
