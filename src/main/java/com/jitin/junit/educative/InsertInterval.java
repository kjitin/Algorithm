package com.jitin.junit.educative;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {


  public static void main(String[] args) {
    int[][] newIntervals = {
      {5, 7},
      {8, 9},
      {10, 12},
      {1, 3},
      {1, 10}
    };

    int[][][] existingIntervals = {
      {{1, 2}, {3, 5}, {6, 8}},
      {{1, 3}, {5, 7}, {10, 12}},
      {{8, 10}, {12, 15}},
      {{5, 7}, {8, 9}},
      {{3, 5}}
    };
    for (int i = 0; i < newIntervals.length; i++) {
      System.out.print((i + 1) + ".\tExisting intervals: ");
      System.out.println(Arrays.deepToString(existingIntervals[i]));
      System.out.println("\tNew interval: [" + newIntervals[i][0] + ", " + newIntervals[i][1] + "]");
      int[][] output = insertInterval(existingIntervals[i], newIntervals[i]);
      System.out.println("\tUpdated intervals: " + Arrays.deepToString(output));
      System.out.println(new String(new char[100]).replace('\0', '-'));
    }
  }
  public static int[][] insertInterval(int[][] existingIntervals, int[] newInterval) {
    List<int[]> results = new ArrayList<>();

    int i= 0 ;
    int newIntervalStart = newInterval[0];
    int newIntervalEnd = newInterval[1];

    while (i < existingIntervals.length && existingIntervals[i][0] < newIntervalStart) {
      results.add(existingIntervals[i]);
      i += 1;
    }

    if(results.size() ==0 || results.get(results.size() -1)[1] < newIntervalStart) {
      results.add(newInterval);
    } else {
      results.get(results.size() -1)[1] = Math.max(results.get(results.size() -1)[1], newIntervalEnd);
    }

    while (i < existingIntervals.length) {
      int[] ei = existingIntervals[i];
      int start  = ei[0];
      int end = ei[1];

      if (results.get(results.size() - 1)[1] < start) {
        results.add(ei);
      } else {
        results.get(results.size() - 1)[1] = Math.max(results.get(results.size() - 1)[1], end);
      }
      i += 1;
    }

    return results.toArray(new int[0][0]);
  }
}
