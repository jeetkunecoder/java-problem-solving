package com.firecode.problems;

public class InsertInListHead {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode result = insertAtHead(n1, 3);
        System.out.println("Data " + result.data + " value" +result.next.data);
    }

    public static ListNode insertAtHead(ListNode head, int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) return newNode;
        newNode.next = head;
        return newNode;
    }
}

class ListNode {
    int data;
    ListNode next;
    ListNode(int data) {
        this.data = data;
    }
}
