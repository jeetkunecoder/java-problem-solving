package com.firecode.problems;

public class FindMiddleInList {

    public static void main(String[] args) {
        ListNode node = new ListNode(5);
        ListNode head = insert(insert(node, 4), 3);
        System.out.println("Size: " + getSize(head));
        ListNode middleNode = findMiddleNode(head);

        System.out.println("The node at the middle is: " + middleNode.data);

        ListNode even = insert(head, 2);
        System.out.println("Size: " + getSize(even));
        ListNode middleNode2 = findMiddleNode(even);
        System.out.println("The node at the middle is: " + middleNode2.data);
    }

    public static ListNode findMiddleNode(ListNode head) {
        int listSize = 0;
        ListNode tempNode = head, middleNode = head;

        while (tempNode != null) {
            listSize++;
            tempNode = tempNode.next;
        }

        for (int i = 1; i <= (int)Math.ceil(listSize / 2D); i++) {
            middleNode = head;
            head = head.next;
        }

        return middleNode;
    }

    public static int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    public static ListNode insert(ListNode head, int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) return newNode;
        newNode.next = head;
        return newNode;
    }
}
