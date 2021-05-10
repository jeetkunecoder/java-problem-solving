package com.educative.challenges;

public class FindTwoNumbersWithSort {

    //Helper Function to sort given Array (Quick Sort)
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is <= to pivot
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    /**
     *  Quicksort: Time Complexity O(NlogN)
     *
     *  Process:
     *  1) Take the start and end indexes of the array
     *  2) Calculate the partition
     *  3) Recursively sort from start to partition - 1
     *  4) Sort from partition + 1 to end
     *
     *  To calculate the partition:
     *
     *  1) Take a pivot = arr[end]
     *  2) Take an int i = start - 1
     *  3) Loop -> for (int j = low; j < high; j++)
     *  4) if (arr[j] <= pivot) => i++ and swap arr[i] and arr[j]
     *  5) Outside of loop => swap arr[i+1] and arr[high] (or pivot)
     *  6) Return i + 1
      */


    public static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    //Return 2 elements of arr that sum to the given value
    public static int[] findSum(int[] arr, int n) {
        int start = 0;
        int end = arr.length - 1;
        int[] result = new int[2];
        int sum = 0;

        sort(arr, 0, arr.length - 1);   //Sort the array in Ascending Order

        while (start != end) {
            sum = arr[start] + arr[end];
            if (sum < n)
                start++;
            else if (sum > n)
                end--;
            else {
                result[0] = arr[start];
                result[1] = arr[end];
                return result;
            }
        }
        return arr;
    }

    public static void main(String args[]) {

        int n = 27;
        int[] arr1 = {1, 21, 3, 14, 5, 60, 7, 6};
        if(arr1.length > 0){
            int[] arr2 = findSum(arr1, n);
            int num1 = arr2[0];
            int num2 = arr2[1];

            if((num1 + num2) != n)
                System.out.println("Not Found");
            else {
                System.out.println("Number 1 = " + num1);
                System.out.println("Number 2 = " + num2);
                System.out.println("Sum = " +  (n) );

            }
        } else {
            System.out.println("Input Array is Empty!");
        }
    }
}
