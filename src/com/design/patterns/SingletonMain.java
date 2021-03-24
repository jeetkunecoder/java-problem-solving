package com.design.patterns;

/**
 * The Singleton pattern is one of the most simple
 * design patterns that exist. This type of design
 * pattern comes under creational pattern as it
 * provides one of the best ways to create an object.
 *
 * This pattern involves a single class which is responsible
 * to create an object while making sure that only that
 * single object gets created. Also, it provides a way to
 * access its only object which can be accessed without
 * need to instantiate it
 *
 * Pros:
 * - You can be sure that a class has only a single instance.
 * - You gain a global access point to that instance.
 * - The singleton object is initialized only when it's requested
 *   for the first time.
 *
 * Cons:
 * - Violates the Single-Reponsibility Principle
 *   as it solves two problems at a time.
 * - It may be difficult to unit test the client
 *   code of the singleton because many test frameworks
 *   rely on inheritance when producing mock objects.
 *   Since the constructor of the singleton class is private
 *   and overriding static methods is impossible in most
 *   languages, you will need to think of a creative way
 *   to mock the singleton. Or just don't write tests or
 *   don't use the Singleton pattern.
 */

class Singleton {

    // Create an object
    private static Singleton instance = new Singleton();

    // Make the constructor private so that the
    // class cannot be instantiated
    private Singleton() {}

    // Get the only object available
    public static Singleton getInstance() {
        return instance;
    }

    public void displayMessage() {
        System.out.println("This is the Singleton design pattern");
    }
}

public class SingletonMain {

    public static void main(String[] args) {
        // As the constructor is private, we cannot
        // create additional instances.
        // Singleton s = new Singleton(); -> does not compile

        Singleton singleton = Singleton.getInstance();
        singleton.displayMessage();
    }
}
