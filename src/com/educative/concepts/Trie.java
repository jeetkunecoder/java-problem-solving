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

    /**
     * Inserting a word in a Trie
     *
     * Insertion is simple for individual characters
     * in the trie. If the character is already present,
     * we follow the path; if that character is not present,
     * then we insert the corresponding nodes. While inserting
     * the last node, we must set the value of isEndWord to true.
     *
     * - Case 1: The word has no common subsequence. i.e.
     * No Common Prefix
     *
     * For example, if we want to insert the word "any" in a Trie
     * that only contains the word "the", then we need to insert all
     * of the characters (a, n, y) as there are no common character
     * subsequences between "any" and "the".
     *
     * - Case 2: The word has a common subsequence. i.e.
     * Common Prefix Found
     *
     * For example, if we want to insert the word "there" into a Trie
     * that contains the word "their", then the path to "the" already exists.
     * After that, we need to insert the nodes for 'r' and 'e.
     *
     * - Case 3: The word is already present. i.e.
     * Common Prefix Found
     *
     * If we want to insert the word "the" into a trie that consists the
     * word "their", then the path for the word "the" already exists
     *
     */

    // Method to insert a key-value pair in the Trie
    public void insert(String key) {
        if (key == null) {
            System.out.println("Null keys are not allowed");
            return;
        }

        key = key.toLowerCase();
        TrieNode currentNode = this.root;
        int index = 0; // to store character index

        for (int level = 0; level < key.length(); level++) {
            index = getIndex(key.charAt(level));
            if (currentNode.children[index] == null) {
                currentNode.children[index] = new TrieNode();
            }
            currentNode = currentNode.children[index];
        }

        // Mark the end character as leaf node
        currentNode.markAsLeaf();
    }

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
