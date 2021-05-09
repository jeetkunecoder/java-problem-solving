package com.theory.concepts;

public class CompositionVsInheritance {
}

// Inheritance

class Animal {
    String name;

    public Animal() {}

    public Animal(String name) {
        this.name = name;
    }
}

class Dog extends Animal {
    String type;

    public Dog() {}

    public Dog(String name, String type) {
        this.name = name;
        this.type = type;
    }
}

// Composition

class Student {}

class College {
    private Student student;
    public College() {
        this.student = new Student();
    }
}
