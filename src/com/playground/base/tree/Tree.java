package com.playground.base.tree;

public class Tree {

    private Node root;

    public Node getRoot() {
        return this.root;
    }

    public void setRoot(Node node) {
        this.root = node;
    }

    /**
     * Iterative Insertion
     * Time complexity: O(h) where h is the height of the tree
     * In the worst case scenario we may have to traverse
     * the tree from root until the deepest leaf node.
     *
     * The height of a skewed tree may become n, therefore,
     * the worst case time complexity is linear time O(n)
     */
    public boolean insert(int data) {

        if (isEmpty()) {
            root = new Node(data);
            return true;
        }

        Node current = root;

        while(current != null) {

            if (current.getData() > data) {
                if (current.getLeft() == null) {
                    current.setLeft(new Node(data));
                    return true;
                }
                current = current.getLeft();
            }
            else {
                if (current.getRight() == null) {
                    current.setRight(new Node(data));
                    return true;
                }
                current = current.getRight();
            }
        }

        return false;
    }

    /**
     * Recursive Insert
     * @return
     */
    public boolean add(int data) {
        root = recursiveInsert(this.root, data);
        return true;
    }

    public Node recursiveInsert(Node current, int data) {
        if (isEmpty()) {
            return new Node(data);
        }

        if (current.getData() > data) {
            current.setLeft(recursiveInsert(current.getLeft(), data));
        }
        else if (current.getData() < data) {
            current.setRight(recursiveInsert(current.getRight(), data));
        }

        return current;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void printTree(Node current) {
        if (current == null) return;
        System.out.println(current.getData());
        printTree(current.getLeft());
        printTree(current.getRight());
    }
}

class Node {
    private int data;
    private Node left;
    private Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public Node getLeft() {
        return this.left;
    }

    public Node getRight() {
        return this.right;
    }

    public int getData() {
        return this.data;
    }

    public void setLeft(Node node) {
        this.left = node;
    }

    public void setRight(Node node) {
        this.right = node;
    }

    public void setData(int data) {
        this.data = data;
    }
}