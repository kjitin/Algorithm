package com.jitin.junit.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaximumSum {

  public static void main(String[] args) {
    int[] nums = new int[] {18,43,36,13,7};
    System.out.println(maximumSum(nums));
  }

  // 9
  private static int maximumSum(int[] nums) {
    Map<Integer, Integer> sum = new HashMap<>();
    int answer = -1;
    for (int value : nums) {
      int digitSum = getDigitSum(value); // 9 7 9 4 7
      if (sum.containsKey(digitSum)) {
        // Math.max(-1, 36+ 18) answer = 54
        // Math.max(54, 7+43) answer = 54
        answer = Math.max(answer, value+ sum.get(digitSum));
      }
      // first time digitSum 9, Math.mx(0, 18) sum 9 - 18
      // second time digitSum 7 , Math.max(0, 43) sum 9-18, 7 -43
      // third time digitSum 9, Math.max(18, 36) sum 9-36, 7-43
      // fourth time digitSum 4 , Math.max(0, 13) sum 9-36, 7-43, 4-13
      sum.put(digitSum, Math.max(sum.getOrDefault(digitSum, 0), value));
    }
    return answer;
  }

  private static int getDigitSum(int value) {
    int sum =0;
    while (value>0) {
      sum = sum+ value%10;
      value = value/10;
    }
    return sum;
  }
}
