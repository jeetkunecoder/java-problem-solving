package com.educative.concepts;

/**
 * In Computer Science, a Trie, also called digital tree
 * or prefix tree, is a type of search tree used for locating
 * specific keys from within a set.
 *
 * These keys are most often strings, with links between nodes
 * defined not by the entire key, but by individual characters.
 *
 * In order to access a key (to recover its value, change it or
 * remove it), the trie is traversed depth-first, following the
 * links between nodes, which represent each character in the key
 *
 * Representation of a Node:
 *
 * A node in a Trie represents a letter in an alphabet. For example,
 * if we want to insert "hello" in the Trie, we will need to add 5
 * nodes, one for each letter of the string.
 *
 * A typical Node in a Trie consists of two data members:
 *
 * - children[]: An array which consists of the children nodes. The
 * size of this array depends on the number of letters in the alphabet.
 * (26 for English language). By default, all the elements are set to null;
 *
 * - isEndWord: A boolean flag that indicates the end of the word. It is
 * set to false by default and is only updated when an end of the word
 * is observed during insertion
 */

public class Trie {

    private TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    // Method to get the index of a char
    public int getIndex(char t) {
        return t - 'a';
    }

    // Method to insert a key-value pair in the Trie
    public void insert(TrieNode node) {}

    // Function to search a given key in the Trie
    public boolean search(String key) {
        return false;
    }

    // Method to delete given key from Trie
    public boolean delete(String key) {
        return false;
    }

    public static void main(String[] args) {
        TrieNode node = new TrieNode();
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isEndWord;
    static final int ALPHABET_SIZE = 26;

    TrieNode() {
        this.isEndWord = false;
        this.children = new TrieNode[ALPHABET_SIZE];
    }

    // Method to mark the current node as leaf
    public void markAsLeaf() {
        this.isEndWord = true;
    }

    // Method to unmark the current node as leaf
    public void unmarkLeaf() {
        this.isEndWord = false;
    }
}
