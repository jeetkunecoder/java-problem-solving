package com.theory.concepts;

import java.util.ArrayList;
import java.util.List;

/**
 * The List is an ordered collection composed
 * of nodes. Every node has a value and references
 * to other nodes, depending of the implementation.
 *
 * In Java, the most common implementations
 * are the ArrayList and the LinkedList.
 *
 * Time Complexities of operations on lists:
 *
 * - ArrayList:
 *  * appending an element: O(1)
 *  * adding on a specific position: O(n)
 *    because we need to shift the elements
 *    at the right of the item to be inserted
 *    to make space
 *  * deleting on a specific position: O(n)
 *    same case as previous scenario but
 *    shifting elements to the left
 *  * get: O(1) - because ArrayList implementation
 *    uses regular indexed arrays.
 *  * indexOf: O(n)
 *  * contains: O(n)
 *
 *  - LinkedList:
 *   * add: O(1) - we just need to change the references
 *   * remove: O(1)
 *   * contains: O(n)
 *   * get: O(n)
 */


public class CollectionComplexities {

    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l1.get(1);
        l1.add(3);

        List<Integer> l2 = new java.util.LinkedList<>();
        l2.add(1);
        l2.get(1);
        l2.remove(1);
    }
}
