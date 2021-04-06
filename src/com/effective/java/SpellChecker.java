package com.effective.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Below, we have an example of Inappropriate use of static utility
 * due to being inflexible & untestable.
 */

class SpellChecker1 {
    private static final Map<String, Integer> dictionary = new HashMap<>();

    private SpellChecker1() { } // Non-instantiable

    public static boolean isValid(String word) {
        return dictionary.get("word") > 0;
    }

    public static void suggestions(String typo) {

    }
}

/**
 * Similarly, it's not uncommon to see them implemented as singletons.
 * Below, we have an example of an inappropriate use of an inflexible
 * and untestable singleton.
 */

class SpellChecker2 {
    private final Map<String, Integer> dictionary = new HashMap<>();

    private SpellChecker2() {}
    public static SpellChecker2 INSTANCE = new SpellChecker2();

    public boolean isValid(String word) {
        return dictionary.get(word) > 0;
    }
}

/**
 * Neither of these approaches is satisfactory, because they assume
 * that there is only one dictionary worth using. In practice, each
 * language has its own dictionary, and special dictionaries are
 * used for special vocabularies.
 *
 * Also, it may be desirable to use a special dictionary for testing.
 * It is wishful thinking to assume that a single dictionary will
 * suffice for all time.
 *
 * The solution is to pass the resource into the constructor
 * when creating a new instance. This is one form of dependency
 * injection: the dictionary is a dependency of the spell checker
 * and is injected into the spell checker when its created.
 *
 * Summary:
 * Do not use a singleton or static utility class to implement
 * a class that depends on one or more underlying resources
 * whose behavior affects that of the class, and do not have
 * the class create these resources directly. Instead, pass
 * the resources, or factories to create them into the constructor
 * (or static factory or builder). this practice, known as
 * dependency injection, will greatly enhance the flexibility,
 * reusability, and testability of a class.
 */

public class SpellChecker {
    private final Map<String, Integer> dictionary;

    public SpellChecker(Map<String, Integer> dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }
}
