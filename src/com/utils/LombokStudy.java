package com.utils;

import java.util.Objects;

public class LombokStudy {

    public static void main(String[] args) {
        final PersonSimple john = new PersonSimple.Builder()
                .setFirstName("John")
                .setLastName("Doe")
                .setAge(36)
                .build();

        System.out.println(john);
    }
}

class PersonSimple {

    private String lastName;
    private String firstName;
    private Integer age;

    private PersonSimple(String lastName, String firstName, Integer age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Integer getAge() {
        return age;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonSimple that = (PersonSimple) o;
        return Objects.equals(lastName, that.lastName) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(age, that.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName);
    }

    @Override
    public String toString() {
        return "PersonSimple{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                '}';
    }

    public static class Builder {
        private String lastName;
        private String firstName;
        private Integer age;

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setAge(Integer age) {
            this.age = age;
            return this;
        }

        public PersonSimple build() {
            return new PersonSimple(lastName, firstName, age);
        }
    }
}
