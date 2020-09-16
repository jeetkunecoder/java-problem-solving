package com.theory.concepts;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamOperations {

  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(10, 9, 8 , 4, 5, 1, 3, 6);
    List<Integer> squaredNumbers = map(numbers);
    multiLevelGrouping();
  }

  /**
   * Standard higher order functions: map, filter, reduce, forEach
   * @param numbers
   * @return
   */
  private static List<Integer> map(List<Integer> numbers) {
    return numbers.stream().map(x -> x * x).collect(Collectors.toList());
  }

  private static List<Integer> filter(List<Integer> numbers) {
    return numbers.stream().filter(x -> x < 6).collect(Collectors.toList());
  }

  private static List<Integer> sorted(List<Integer> numbers) {
    return numbers.stream().sorted().collect(Collectors.toList());
  }

  private static Set<Integer> collect(List<Integer> numbers) {
    return numbers.stream().map(x -> x + 2).collect(Collectors.toSet());
  }

  private static void forEach(List<Integer> numbers) {
    numbers.forEach(System.out::println);
  }

  private static Integer sumOfEvens(List<Integer> numbers) {
    return numbers.stream().filter(x -> x % 2 == 0)
      .reduce(0, Integer::sum);
  }

  private static void printNumbers(List<Integer> numbers) {
    for (Integer number : numbers) {
      System.out.println(number);
    }
  }

  /**
   * groupingBy Collector
   */
  private static void demonstrateGrouping() {
    List<BlogPost> posts = Arrays.asList(
      new BlogPost("Title 1", "Pedro", BlogPostType.GUIDE, 1),
      new BlogPost("Title 2", "Rosa", BlogPostType.NEWS, 5),
      new BlogPost("Title 3", "June", BlogPostType.REVIEW, 59)
    );

    // Simple grouping by a single column
    Map<BlogPostType, List<BlogPost>> postsPerType =
        posts.stream().collect(Collectors.groupingBy(BlogPost::getType));

    postsPerType.forEach((x, y) -> System.out.println("Key: " + x + " Value: " + y));
  }

  private static void multiLevelGrouping() {
    Person person1 = new Person("John", "USA", "NYC", new Pet("Max", 5));
    Person person2 = new Person("Steve", "UK", "London", new Pet("Lucy", 8));
    Person person3 = new Person("Anna", "USA", "NYC", new Pet("Buddy", 12));
    Person person4 = new Person("Mike", "USA", "Chicago", new Pet("Duke", 10));

    List<Person> persons = Arrays.asList(person1, person2, person3, person4);

    final Map<String, Map<String, Map<String, List<Person>>>>
        personsByCountryCityAndPetName = persons.stream().collect(
            Collectors.groupingBy(Person::getCountry, groupByCityAndPetName()));

    System.out.println(personsByCountryCityAndPetName.toString());
  }

  private static Collector<Person, ?, Map<String, Map<String, List<Person>>>> groupByCityAndPetName() {
    return Collectors.groupingBy(Person::getCity, Collectors.groupingBy(p -> p.getPet().getName()));
  }
}

class Person {
  private final String name;
  private final String country;
  private final String city;
  private final Pet pet;

  public Person(String name, String country, String city, Pet pet) {
    this.name = name;
    this.country = country;
    this.city = city;
    this.pet = pet;
  }

  public String getName() {
    return name;
  }

  public String getCountry() {
    return country;
  }

  public String getCity() {
    return city;
  }

  public Pet getPet() {
    return pet;
  }

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", country='" + country + '\'' +
        ", city='" + city + '\'' +
        '}';
  }
}

class Pet {
  private final String name;
  private final int age;

  public Pet(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  @Override
  public String toString() {
    return "Pet{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }
}

class BlogPost {
  String title;
  String author;
  BlogPostType type;
  int likes;

  public BlogPost(String title, String author, BlogPostType type, int likes) {
    this.title = title;
    this.author = author;
    this.type = type;
    this.likes = likes;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public BlogPostType getType() {
    return type;
  }

  public int getLikes() {
    return likes;
  }
}

enum BlogPostType {
  NEWS, REVIEW, GUIDE
}

class Tuple {
  BlogPostType type;
  String author;
}
