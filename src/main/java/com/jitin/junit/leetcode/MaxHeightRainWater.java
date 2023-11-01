package com.jitin.junit.leetcode;

public class MaxHeightRainWater {


  public static void main(String[] args) {
    int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

    System.out.println(trap(height));
  }

  private static int trap(int[] height) {
    int total =0;
    int currentWater =0;


    for(int i=0; i<= height.length -1; i++) {
      int leftP =i;
      int rightP =i;
      int maxLeft =0;
      int maxRight =0;

      while(leftP >=0) {
        maxLeft = Math.max(maxLeft, height[leftP]);
        leftP--;
      }
      while(rightP < height.length) {
        maxRight = Math.max(maxRight, height[rightP]);
        rightP++;
      }
      currentWater = Math.min(maxLeft, maxRight) - height[i];
      if(currentWater > 0) {
        total += currentWater;
      }

    }
    return total;
  }
}
