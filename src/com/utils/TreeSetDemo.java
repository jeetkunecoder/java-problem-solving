package com.utils;

import java.util.Set;
import java.util.TreeSet;

/**
 * TreeSet maintains ascending order in elements
 */

public class TreeSetDemo {

  public static void main(String[] args) {
    Set<Book> set = new TreeSet<>();

    // Create books
    Book b1 = new Book(121, "Algorithms in Java", "Robert Sedgewick", "BPB", 8);
    Book b2 = new Book(233, "Operating Systems", "Tanenbaum", "ABC", 9);
    Book b3 = new Book(101, "Compilers", "E. Novich", "USB", 1);

    set.add(b1);
    set.add(b2);
    set.add(b3);

    for (Book b : set) {
      System.out.println(b.id + " " + b.name + " " + b.author + " " + b.publisher + " " + b.quantity);
    }
  }
}

class Book implements Comparable<Book> {
  int id;
  String name;
  String author;
  String publisher;
  int quantity;

  public Book(int id, String name, String author, String publisher, int quantity) {
    this.id = id;
    this.name = name;
    this.author = author;
    this.publisher = publisher;
    this.quantity = quantity;
  }

  public int compareTo(Book b) {
    if(id > b.id) {
      return 1;
    } else if(id < b.id) {
      return -1;
    } else {
      return 0;
    }
  }
}
