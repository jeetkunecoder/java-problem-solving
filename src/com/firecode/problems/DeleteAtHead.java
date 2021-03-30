package com.firecode.problems;

public class DeleteAtHead {

    public static void main(String[] args) {
        ListNode node = new ListNode(5);
        ListNode head = insertAtHead(insertAtHead(node, 4), 3);
        System.out.println("Before: ");
        print(head);
        System.out.println("After: ");
        print(deleteAtHead(head));
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

    public static ListNode deleteAtHead(ListNode head) {
        if (head == null) return null;
        ListNode temp = head.next;
        head.next = null;
        head = temp;
        return head;
    }

    public static ListNode insertAtHead(ListNode head, int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) return newNode;
        newNode.next = head;
        return newNode;
    }
}
