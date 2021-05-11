package com.educative.challenges.lists;

public class SinglyLinkedList<T> {

    Node head;
    int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    void insertAtHead(T data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    boolean isEmpty() {
        return head == null;
    }

}

class Node<T> {
    T data;
    Node next;

    public Node (T data) {
        this.data = data;
        next = null;
    }
}