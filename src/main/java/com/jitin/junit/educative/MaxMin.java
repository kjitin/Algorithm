package com.jitin.junit.educative;

public class MaxMin {

  public static void main(String[] args) {
    int[] arr = {1,2,3,4,5,6,7,8,9};
   //maxMin(arr);
   maxMin2(arr);
  }

  public static void maxMin(int[] arr) {
    //Create a result array to hold re-arranged version of given arr
    int[] result = new int[arr.length];

    int pointerSmall = 0;     //PointerSmall => Start of arr
    int pointerLarge = arr.length - 1;   //PointerLarge => End of arr

    //Flag which will help in switching between two pointers
    boolean switchPointer = true;

    for (int i = 0; i < arr.length; i++) {
      if (switchPointer)
        result[i] = arr[pointerLarge--]; // copy large values
      else
        result[i] = arr[pointerSmall++]; // copy small values

      switchPointer = !switchPointer;   // switching between samll and large
    }

    for (int j = 0; j < arr.length; j++) {
      arr[j] = result[j];    // copying to original array
    }
  }

  public static void maxMin2(int[] arr) {
    int maxIdx = arr.length - 1;
    int minIdx = 0;
    int maxElem = arr[maxIdx] + 1; // store any element that is greater than the maximum element in the array
    for( int i = 0; i < arr.length; i++) {
      // at even indices we will store maximum elements
      if (i % 2 == 0){
        arr[i] += (arr[maxIdx] % maxElem ) * maxElem; //1. arr[0] = 1 + (5%6)*6: 31|
        maxIdx -= 1;
      }
      else { // at odd indices we will store minimum elements
        arr[i] += (arr[minIdx] % maxElem ) * maxElem; // arr[1,2,3,4,5] 2. arr[1] = 2+(31%6)*6 = 2+ 1*6 = 8|
        minIdx += 1;
      }
    }
    // dividing with maxElem to get original values.
    for( int i = 0; i < arr.length; i++) {
      arr[i] = arr[i] / maxElem;
    }
  }
}
