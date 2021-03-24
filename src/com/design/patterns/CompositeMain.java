package com.design.patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * The Composite pattern is used where we need
 * to treat a group of objects in a similar way
 * as a single object.
 *
 * The Composite pattern composes objects in term
 * of a tree structure to represent part as well as
 * whole hierarchy. This type of design pattern
 * comes under structural pattern as it creates a
 * structure of group objects.
 *
 * This pattern creates a class that contains a group
 * of its own objects. Also, it provides ways to modify
 * its group of same objects.
 */

public class CompositeMain {

    public static void main(String[] args) {
        Employee e1 = new Employee("Sam", "Sheppard", 1500);
        Employee e2 = new Employee("Donna", "Summer", 2200);
        Employee e3 = new Employee("Mike", "Quinn", 3000);
        Employee e4 = new Employee("Simon", "Simmons", 6000);

        e4.add(e1);
        e4.add(e2);
        e4.add(e3);

        List<Employee> subordinates = e4.getSubordinates();

        for (Employee emp : subordinates) {
            System.out.println(emp);
        }
    }

}

/**
 * As we can observe, this class contains a group
 * of elements of its own class.
 */
class Employee {
    private String name;
    private String dept;
    private int salary;
    private List<Employee> subordinates;

    public Employee(String name, String dept, int salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        this.subordinates = new ArrayList<>();
    }

    public void add(Employee e) {
        subordinates.add(e);
    }

    public void remove(Employee e) {
        subordinates.remove(e);
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    public String toString() {
        return ("Employee :[ Name : " + name + ", dept : " + dept + ", salary :" + salary+" ]");
    }
}
