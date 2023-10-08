package com.jitin.junit.leetcode;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {

  public static void main(String[] args) {
    int[] nums1 = {4,1,2};
    int[] nums2 = {1,3,4,2};
    System.out.println(nextGreaterElement1(nums1, nums2));
  }

  private static int[] nextGreaterElement(int[] nums1, int[] nums2) {

      Stack<Integer> stack = new Stack<>();
      HashMap<Integer, Integer> map = new HashMap<>();

      for (int i = 0; i < nums2.length; i++) {
        while (!stack.empty() && nums2[i] > stack.peek())// 1 --condition false| 3>1 true | 4 >3 true | 2 condition false
          map.put(stack.pop(), nums2[i]); // {1, 3}|{1,3 : 3, 4}
        stack.push(nums2[i]); // stack {1}| stack{3} | stack{4}| {4, 2}
      }

      while (!stack.empty())
        map.put(stack.pop(), -1);//{1, 3: 3,4 : 2, -1: 4, -1}

      int[] res = new int[nums1.length];
      for (int i = 0; i < nums1.length; i++) {
        res[i] = map.get(nums1[i]);
      }

      return res;
    }

  public static int[] nextGreaterElement1(int[] nums1, int[] nums2) {
    int[] res = new int[nums1.length];
    int j;

    for (int i = 0; i < nums1.length; i++) {
      boolean found = false;
      for (j = 0; j < nums2.length; j++) {
        if (found && nums2[j] > nums1[i]) {
          res[i] = nums2[j];
          break;
        }

        if (nums2[j] == nums1[i]) {
          found = true;
        }
      }
      if (j == nums2.length) {
        res[i] = -1;
      }
    }

    return res;
  }
}
