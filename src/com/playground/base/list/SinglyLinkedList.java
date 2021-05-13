package com.playground.base.list;

public class SinglyLinkedList<T> {
    Node head;
    int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    boolean isEmpty() {
        return head == null;
    }

    void insertAtHead(T data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = head;
        head = newNode;
        size++;
    }

    void insertAtEnd(T data) {
        if (isEmpty()) {
            insertAtHead(data);
            return;
        }

        Node newNode = new Node();
        newNode.data = data;

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        size++;
    }
}

class Node<T> {
    T data;
    Node next;
}