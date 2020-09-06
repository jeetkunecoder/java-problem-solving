package com.theory.concepts;

/**
 * Anonymous classes enable us to make our code more concise.
 * They enable us to declare and instantiate a class at the same time.
 * They are like local classes, except that they don't have a name.
 * We use them when we need to use a local class only once.
 *
 * While local classes are class declarations, anonymous classes
 * are expressions, which means that we define the class in another
 * local expression. The following code, uses anonymous classes in the
 * initialization statements of the local variable frenchGreeting,
 * but uses a local class for the initialization of englishGreeting.
 */

public class AnonymousClasses {

  interface HelloWorld {
    public void greet();
    public void greetSomeone(String someone);
  }

  public void sayHello() {

    class EnglishGreeting implements HelloWorld {
      public void greet() {
        System.out.println("Hello World");
      }

      public void greetSomeone(String someone) {
        System.out.println("Hello " + someone + "!");
      }
    }

    HelloWorld englishGreeting = new EnglishGreeting();

    HelloWorld spanishGreeting = new HelloWorld() {
      public void greet() {
        System.out.println("Hola carnales!");
      }

      public void greetSomeone(String someone) {
        System.out.println("Habla claro " + someone + "!");
      }
    };

    englishGreeting.greet();
    spanishGreeting.greetSomeone("Turing");
  }
}
