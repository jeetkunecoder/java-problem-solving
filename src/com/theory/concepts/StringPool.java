package com.theory.concepts;

/**
 * The Java String pool is a special memory region
 * where Strings are stored by the JVM.
 *
 * Thanks to the immutability of strings in Java, the JVM can optimize
 * the amount of memory located for them by storing only one copy of each
 * literal String in the pool. This process is called interning.
 *
 * When we create a String variable and assign a value to it, the JVM
 * searches the pool for a String of equal value.
 *
 * If found, the Java compiler will simply return a reference to its memory
 * address without allocating additional memory.
 *
 * If not found, it will be added to the pool (interned) and its reference
 * will be returned.
 */

public class StringPool {

    public static void main(String[] args) {
        String str1 = "I like soccer";
        String str2 = "I like soccer";

        System.out.println(str1.equals(str2));

        /**
         * When we create a String via the new operator
         * the java compiler will create a new object and store
         * it in the heap space reserved for the JVM. Every
         * string created like this will point to a different
         * memory region with its own address.
         */

        String str3 = "Coding";
        String str4 = new String("Coding");
        System.out.println(str3.equals(str4));

        /**
         * When we create a String object using the new operator
         * it always creates a new object in heap memory. On
         * the other hand, if we create an object using String literal
         * syntax, it may return an existing object from the String pool
         * if it already exists. Otherwise, it will create a new String
         * object and put it in the String pool for future use.
         *
         * At high level, both are String objects, but the main difference
         * comes from the point that the new operator always creates a
         * new String object. Also, when we create a string using a literal
         * it is interned.
         */


    }
}
