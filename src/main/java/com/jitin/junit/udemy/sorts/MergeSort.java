package com.jitin.junit.udemy.sorts;

import java.util.Arrays;

public class MergeSort {


  public static void main(String[] args) {
    int[] arr = {5,2,6,3,1,4};
    int[] sortedArr = mergeSort(arr);
    String str = "abc";
    System.out.println(str.length());
    System.out.println(Arrays.toString(sortedArr));
  }
  public static int[] mergeSort(int[] arr) {
    if (arr.length == 1)
      return arr;
    int mid = arr.length/2;
    int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
    int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

    return merge(left, right);
  }
  public static int[] merge(int[] arr1, int[] arr2) {
    int[] combined = new int[arr1.length+ arr2.length];
    int index =0;
    int i=0;
    int j =0;

    while (i < arr1.length && j < arr2.length) {
      if (arr1[i] < arr2[j]) {
        combined[index] = arr1[i];
        index++;
        i++;
      } else {
        combined[index] = arr2[j];
        index++;
        j++;
      }
    }
    while (i< arr1.length) {
      combined[index] = arr1[i];
      index++;
      i++;
    }

    while (j < arr2.length) {
      combined[index] = arr2[j];
      index++;
      j++;
    }
    return combined;
  }
}
