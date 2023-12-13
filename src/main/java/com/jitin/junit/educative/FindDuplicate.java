package com.jitin.junit.educative;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicate {

  public static void main(String[] args) {
    int[] nums = {2, 3, 4, 2, 5, 1};
    System.out.println(findDuplicate(nums));
  }

  public static int findDuplicate(int[] nums) {
    int slow =nums[0];
    int fast = nums[0];


    while(true) {
      slow = nums[slow];
      fast = nums[nums[fast]];
      if (slow == fast)
        break;
    }
    slow = nums[0];
    while (slow != fast) {
      slow = nums[slow];
      fast = nums[fast];
    }
    return fast;
  }

  public static int findDuplicateEasy(int[] nums) {
    int length = nums.length;

    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < length; i++) {
      if(!set.add(nums[i]))
        return nums[i];
    }
    return 0;
  }
}
