package com.jitin.junit.educative;

import java.util.HashSet;
import java.util.Set;

public class CheckSum {


  public static void main(String[] args) {
    int[] arr = {2,-4,6,7,-8,9};
    int[] result = findSum(arr, 16);
    for (int i = 0; i < 2; i++) {
      System.out.println(result[i]);
    }
  }


  public static int[] findSum(int[] arr, int n) {
    int[] result = new int[2];
    Set<Integer> set = new HashSet<>();
    for(int i=0; i<= arr.length -1; i++) {
      int complement = n -arr[i];
      if(set.contains(complement)) {
        result[0] = complement;
        result[1] = arr[i];
      } else {
        set.add(arr[i]);
      }
    }
    // write your code here
    return result; // return the elements in the array whose sum is equal to the value passed as parameter
  }
}
