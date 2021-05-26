package com.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class InOrderBinaryTree {

    Node root;
    List<Integer> res = new ArrayList<>();

    public InOrderBinaryTree () {
        root = null;
    }

    public static void main(String[] args) {
        InOrderBinaryTree tree = new InOrderBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        List<Integer> result = tree.inorderTraversal(tree.root);

        for (Integer item : result) System.out.println(item);
    }

    public List<Integer> inorderTraversal(Node root) {
        helper(root);
        return res;
    }

    public void helper(Node root) {
        if (root == null) return;
        helper(root.left);
        res.add(root.val);
        helper(root.right);
    }
}

class Node {
    int val;
    Node left;
    Node right;
    Node() {}
    Node(int val) { this.val = val; }
    Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
