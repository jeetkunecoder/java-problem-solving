package com.theory.concepts;

public class LinkedList {

  public static void main(String[] args) {
    ListNode n0 = new ListNode(1);
    n0.next = new ListNode(2);

    insertAtTail(n0, 3);
    display(n0);

    System.out.println("Deleting value at tail");

    deleteAtTail(n0);
    display(n0);
  }

  public static ListNode insertAtTail(ListNode head, int data) {
    ListNode newNode = new ListNode(data);
    if (head == null) {
      head = newNode;
    }
    else {
      ListNode current = head;
      while (current.next != null) {
        current = current.next;
      }
      current.next = newNode;
    }
    return head;
  }

  public static ListNode deleteAtTail(ListNode head) {
    if (head == null || head.next == null) return null;
    ListNode current = head;
    ListNode previous = current;

    while (current.next != null) {
      previous = current;
      current = current.next;
    }
    previous.next = null;
    return head;
  }

  public static void display(ListNode head) {
    if (head.next != null) {
      System.out.println(head.data);
      display(head.next);
    }
    else {
      System.out.println(head.data);
    }
  }
}

class ListNode {
  int data;
  ListNode next;

  public ListNode(int data) {
    this.data = data;
    this.next = null;
  }
}
