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

    void insertAtEnd(T data) {
        if (isEmpty()) {
            insertAtHead(data);
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(data);
        size++;
    }

    void insertAfter(T data, T previous) {
        Node current = head;
        Node newNode = new Node(data);

        while (current != null && !current.data.equals(previous)) {
            current = current.next;
        }

        if (current != null) {
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }

    boolean isEmpty() {
        return head == null;
    }

    public void print() {
        Node temp = head;
        while (temp.next != null) {
            System.out.println(temp.data.toString());
            temp = temp.next;
        }

        System.out.println(temp.data.toString());
    }

    public static void main (String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtHead(1);
        list.insertAtHead(2);
        list.insertAtHead(3);
        list.print();

        System.out.println("Inserting 4th value");
        list.insertAtHead(4);
        list.print();

        System.out.println("Inserting at the end");
        list.insertAtEnd(9);
        list.insertAtEnd(8);
        list.print();

        System.out.println("The size of the list is: " + list.size);
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