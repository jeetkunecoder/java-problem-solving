package com.leetcode.arrays;

public class DuplicateZeros {

  public static void main(String[] args) {
    // After adding zeroes should be: 1,0,0,2,3,0,0,4
    int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
    duplicateZeros(arr);
  }

  public static void duplicateZeros(int[] arr) {
    int n = arr.length;
    int index = 0;
    int[] shifted = new int[n];

    for (int i = 0; i < n; i++) {
       if (arr[i] == 0 && index < n - 1) {
         shifted[index] = 0;
         shifted[index + 1] = 0;
         index += 2;
       }
       else {
         if (index < n) shifted[index] = arr[i];
         index++;
       }
    }

    for (int j = 0; j < n; j++) {
      arr[j] = shifted[j];
    }
  }

  public void duplicateZeros2(int[] arr) {
    int zeroes = 0;

    // 1. Count the zeroes
    for (int i = 0; i < arr.length; i++){
      if(arr[i] == 0){
        zeroes++;
      }
    }

    // 2. Traverse in reverse
    for (int i = arr.length - 1; i >= 0; i--){
      if (arr[i] == 0){ //
        set(arr,i + zeroes, arr[i]);
        zeroes--;
      }
      set(arr,i + zeroes, arr[i]);
    }
  }

  public void set(int A[], int i, int val){
    if (i >= A.length) return;
    A[i] = val;
  }
}
