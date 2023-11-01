package com.jitin.junit.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {


  public static void main(String[] args) {
    int[] nums = new int[]{1,1,1,2,2,3};
    int k=2;
    System.out.println(topKfrequent(nums, k));
  }

  private static int[] topKfrequent(int[] nums, int k) {
    Map<Integer, Integer> counts = new HashMap<>();
    for (int num : nums) {
      counts.put(num, counts.getOrDefault(num, 0) + 1);
    }
    PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(k, Comparator.comparingInt(Map.Entry::getValue));
    for (Map.Entry<Integer, Integer> entry: counts.entrySet()){
      minHeap.offer(entry);
      if (minHeap.size() > k) {
        minHeap.poll();
      }
    }
    int[] result = new int[k];
    for (int i = 0; i < k; i++) {
      result[i] = minHeap.poll().getKey();
      System.out.println(result[i]);
    }
    return result;

  }
}
