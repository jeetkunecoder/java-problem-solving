package com.educative.concepts;

import java.util.Arrays;

/**
 * Heaps are advanced data structures based on Binary Trees,
 * which is why they are commonly known as Binary Heaps. A
 * Binary Heap is a complete Binary Tree which satisfies the
 * Heap ordering property.
 *
 * Heaps are implemented through arrays, where each element of
 * the array corresponds to a node in the binary tree and the
 * value inside
 */

public class Heap {

    public void buildMaxHeap(int[] arr, int heapSize) {
        // Swap largest child to parent node
        for (int i = (heapSize - 1) / 2; i >= 0; i--) {
            maxHeapify(arr, i, heapSize);
        }
    }

    private void maxHeapify(int[] arr, int index, int heapSize) {
        int largest = index;
        // Check the parent nodes only
        while (largest < heapSize / 2) {
            int left = (2 * index) + 1;
            int right = (2 * index) + 2;

            if (left < heapSize && arr[left] > arr[index]) {
                largest = left;
            }

            if (right < heapSize && arr[right] > arr[largest]) {
                largest = right;
            }

            // Swap parent with largest child
            if (largest != index) {
                int temp = arr[index];
                arr[index] = arr[largest];
                arr[largest] = temp;
                index = largest;
            }
            else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 7, 12, 15, 14, 9, 2, 3, 16};
        System.out.println("Before heapify: " + Arrays.toString(arr));
        new Heap().buildMaxHeap(arr, arr.length);
        System.out.println("After heapify: " + Arrays.toString(arr));
    }
}
