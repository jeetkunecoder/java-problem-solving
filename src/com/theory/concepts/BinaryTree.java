package com.theory.concepts;

class Node {
  int data;
  Node left;
  Node right;

  public Node (int data) {
    this.data = data;
    left = null;
    right = null;
  }
}

public class BinaryTree {

  protected Node root;
  public BinaryTree() {
    root = null;
  }

  public boolean lookup(int data) {
    return lookup(root, data);
  }

  public boolean lookup(Node node, int data) {
    if (node == null) return false;
    if (node.data == data) return true;
    else if (node.data < data) return lookup(node.left, data);
    else return lookup(node.right, data);
  }

  public void insert(int data) {
    insert(root, data);
  }

  public Node insert(Node node, int data) {
    if (node == null) {
      node = new Node(data);
    }
    else {
      if (data < node.data) insert(node.left, data);
      else insert(node.right, data);
    }
    return node;
  }
}
