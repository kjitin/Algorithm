package com.jitin.junit.educative;

public class MergeArrays {

  public static void main(String[] args) {
    int[] arr1 = {1,3,5,7};
    int[] arr2 = {2,4,6,8};
    System.out.println(mergeArrays(arr1, arr2));
  }

  public static int[] mergeArrays(int[] arr1, int[] arr2) {
    int totalLength = arr1.length + arr2.length;
    int[] mergedArray = new int[totalLength];
    // O(n2) solution
    int k = 0;
    int firstPointer = 0;
    int secondPointer = 0;
    while (firstPointer < arr1.length && secondPointer < arr2.length) {
      if (arr1[firstPointer] < arr2[secondPointer]) {
        mergedArray[k++] = arr1[firstPointer++];
      } else {
        mergedArray[k++] = arr2[secondPointer++];
      }
    }
    while (firstPointer < arr1.length) {
      mergedArray[k++] = arr1[firstPointer++];
    }
    while (secondPointer < arr2.length) {
      mergedArray[k++] = arr2[secondPointer++];
    }


    return mergedArray; //
  }
}
