package com.theory.concepts;

import java.util.ArrayList;
import java.util.List;

/**
 * The List interface provides a way to store
 * elements in an ordered or sequential collection.
 * It is an ordered collection of objects in which
 * duplicate elements can be stored.
 *
 * Since List preserves the insertion order, it allows
 * positional access and insertion of elements.
 */

public class ListInterface {

    public static void main(String[] args) {
        List<Integer> ls1 = new ArrayList<>();

        ls1.add(0, 1);
        ls1.add(1, 2);

        List<Integer> ls2 = new ArrayList<>();

        ls2.add(1);
        ls2.add(2);
        ls2.add(3);

        ls1.addAll(1, ls2);
        System.out.println(ls1);

        ls1.remove(1);
        System.out.println(ls1.get(3));

        ls1.set(0, 5);
        System.out.println(ls1);

        /**
         * Since list is an interface, objects cannot
         * be created of the type List, we always need a class
         * which implements the interface in order to
         * create an object.
         *
         * Classes which implement the List interface:
         * - ArrayList: Provides the use of dynamic arrays.
         *  Although it may be slower than standard arrays it
         *  can be helpful in programs where lots of array manipulation
         *  is needed
         *
         * - Vector: Implements a growable array of objects. The
         * Vector implements a dynamic array that can grow or shrink
         * as required. Also, it's synchronized, this means if one
         * thread is working on a Vector, no other thread can get a hold of it.
         * Only one thread can perform an operation on Vector at a given time,
         * this means its performance tends to be slower than the ArrayList.
         *
         * - LinkedList
         * - Stack
         */
    }
}
