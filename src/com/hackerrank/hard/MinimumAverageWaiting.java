package com.hackerrank.hard;

import java.util.*;

/**
 * Tieu owns a Pizza restaurant and he manages it in his own way.
 * While in a normal restaurant a customer is served by following the
 * First Come First Served rule, Tieu simply minimizes the average
 * waiting time of his customers. So he gets to decide who is served
 * first, regardless of how sooner or later a person comes
 *
 * Different kinds of Pizza take different amounts of time to cook.
 * Also, once he starts cooking a pizza, he cannot cook another
 * pizza until the first pizza is completely cooked.
 *
 * Let's say we have three customers who come at time t = 0, t = 1 & t = 2
 * respectively, and the time needed to cook their pizzas is 3, 9 & 6
 * respectively.
 *
 * If Tieu, applies first come first served rule, then the waiting time
 * of three customers is 3, 11 & 16
 *
 * Base Case:
 *
 * - The first pizza will always be made and cooked first, finishing at time of 3
 * - At time of 3, customer 1 and 2 have arrived
 * - At this point, since 3 > 1 and 3 > 2, this is where the decision is made
 * - We choose customer 2, since 6 < 9
 * - Once customer 2 is finished, the current time is now 3 + (3 - 2 + 6) = 3 + 7
 *  3 is the current time and we subtract 2 from it since customer 2 arrived at 2,
 *  so rather than adding just 6 (the time to cook customer 2's pizza)
 *  - Then add the last value since it is the last customer 3 + 7 + (9 + 9 - 1)
 */


public class MinimumAverageWaiting {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int numOfCustomers = in.nextInt();
    Customer[] customers = new Customer[numOfCustomers];

    for (int i = 0; i < numOfCustomers; i++) {
      int orderTime = in.nextInt();
      int cookTime = in.nextInt();
      customers[i] = new Customer(orderTime, cookTime);
    }
    in.close();

    Arrays.sort(customers, Comparator.comparingInt(o -> o.orderTime));

    Queue<Customer> waitTime = new PriorityQueue<>();
    long currentTime = 0L;
    long totalWaitTime = 0L;
    int index = 0;

    while (!waitTime.isEmpty() || index < customers.length) {
      while (index < customers.length && customers[index].orderTime <= currentTime) {
        waitTime.add(customers[index]);
        index++;
      }

      if (waitTime.isEmpty()) {
        currentTime = customers[index].orderTime;
        continue;
      }

      Customer served = waitTime.poll();
      currentTime += served.cookTime;
      totalWaitTime += currentTime - served.orderTime;
    }
    System.out.println(totalWaitTime / customers.length);
  }

  static class Customer implements Comparable<Customer> {
    int orderTime;
    int cookTime;

    public Customer(int orderTime, int cookTime) {
      this.orderTime = orderTime;
      this.cookTime = cookTime;
    }

    @Override
    public int compareTo(Customer o) {
      if (this.cookTime > o.cookTime) {
        return this.orderTime;
      }
      else return -1;
    }
  }
}
