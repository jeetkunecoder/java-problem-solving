package com.utils;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A demo of equals() and hashCode()
 *
 * Summary
 * 1. If two objects are equal then they MUST have the same hashcode
 * 2. If two objects have the same hashCode, they might or
 *    might not be equal.
 */

public class EqualsAndHashCode {

    private static class Person {
        private String firstName;
        private String lastName;
        private int ssn;

        public Person(String firstName, String lastName, int ssn) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.ssn = ssn;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getSsn() {
            return ssn;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;
            if (!(obj instanceof Person)) return false;
            Person p = (Person) obj;
            return firstName.equalsIgnoreCase(p.getFirstName()) &&
                    lastName.equalsIgnoreCase(p.getLastName()) &&
                    ssn == p.getSsn();
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstName, lastName, ssn);
        }
    }

    public static void main(String[] args) {
        Person p1 = new Person("John", "Smith", 333);
        Person p2 = new Person("John", "Smith", 333);
        Person p3 = new Person("Bob", "Smith", 333);

        /**
         The default equals method will return false because
         p1 and p2 are pointing to different object references
         in memory. The equals method basically performs a reference check only.
         To obtain the result that we actually want, we need to
         override the equals method with the behavior we need

         We also need to override the hashCode function because
         the contract states that if two objects are equal, then they
         must have the same hashcode as they represent the same
         */
        System.out.println(p1.equals(p2));
        System.out.printf("p1.equals(p2) ? %s%n", p1.equals(p2));
        System.out.printf("p1.equals(p3) ? %s%n", p1.equals(p3));

        Set<Person> set = new HashSet<>();
        set.add(p1);
        set.add(p1); // no-op
        set.add(p2); // no-op
        set.add(p3);

        System.out.printf("The Set has %d elements%n", set.size());
    }
}
