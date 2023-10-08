package com.jitin.junit;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {

        int valleys =0;
        int current = 0;

        for(char step: s.toCharArray()) {
            if(step == 'U') {
                current++;
            } else {
                current--;
            }
            if(current==0 && step=='U') {
                valleys++;
            }
        }

        return valleys;
    }

    static void staircase(int n) {

        for(int j=0;j<n;j++){
            for(int i=1;i<=n;i++){
                System.out.print(i<n-j?" ":"#");
            }
            System.out.println("");
        }

    }

  public static int findBestSubarray(int[] nums, int k) {
    int curr = 0;
    for (int i = 0; i < k; i++) {
      curr += nums[i];
    }

    int ans = curr;
    for (int i = k; i < nums.length; i++) {
      curr += nums[i] - nums[i - k];
      ans = Math.max(ans, curr);
    }

    return ans;
  }

  public static double findMaxAverage(int[] nums, int k) {
    double curr = 0;
    for(int i=0; i< k; i++) {
      curr+= nums[i];
    }
    double ans = curr;
    for(int i= k; i< nums.length ; i++) {
      curr+= nums[i] - nums[i-k];
      ans = Math.max(ans, curr);
    }
    return ans/k;
  }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        //int result = countingValleys(12, "DDUUDDUDUUUD");
        //System.out.println(isUnique("ABCDFGH"));

        //System.out.println("Permutations" +permutatios("GOD","ogd"));

      int[] nums = new int[]{ 0, 1, 1, 3, 3};
      int[] ones = new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};

      int[] numsQ = new int[]{3, 6, 2, 8, 1, 4, 1, 5};
      int[][] queries = new int[][]{{0,3}, {2, 6}, {2,4}};
      System.out.println(longestOnes(ones, 2));
      System.out.println(answerQueries(numsQ, queries, 13));
        //System.out.println("---------------");
        //staircase(6);

    }

  public static boolean[] answerQueries(int[] nums, int[][] queries, int limit) {
    int[] prefix = new int[nums.length];
    prefix[0] = nums[0];

    for (int i = 1; i < nums.length; i++) {
      prefix[i] = prefix[i - 1] + nums[i];
    }

    boolean[] ans = new boolean[queries.length];
    for (int i = 0; i < queries.length; i++) {
      int x = queries[i][0], y = queries[i][1];
      int curr = prefix[y] - prefix[x] + nums[x];
      ans[i] = curr < limit;
    }

    return ans;
  }

  public static int longestOnes(int[] nums, int k) {
    int left = 0, right;
    for (right = 0; right < nums.length; right++) {
      // If we included a zero in the window we reduce the value of k.
      // Since k is the maximum zeros allowed in a window.
      if (nums[right] == 0) {
        k--;
      }
      // A negative k denotes we have consumed all allowed flips and window has
      // more than allowed zeros, thus increment left pointer by 1 to keep the window size same.
      if (k < 0) {
        // If the left element to be thrown out is zero we increase k.
        k += 1 - nums[left];
        left++;
      }
    }
    return right - left;
  }

    static String sort(String input, boolean isUpper) {

        if (isUpper) {
            input = input.toUpperCase();
        } else {
            input = input.toLowerCase();
        }
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    static boolean permutatios(String first, String second) {
        if (first.length() != second.length()) {
            return false;
        }

        boolean isUpperCaseEquals = sort(first, true).equals(sort(second, true));

        boolean isLowerCaseEquals = sort(first, false).equals(sort(second, false));

        return isUpperCaseEquals || isLowerCaseEquals;

        //sort the first string based on characters and second string and then compare
    }

    static boolean isUnique(String input){

        if (input.length() > 128) {
            return false;
        }

        // create a boolean array with size of characters 128 i.e the length of ASCII character-set
        // add the value of char as index and mark as t or f [ex. a =59 so array index 59 will be [t]]
        // if during iteration we come across t in the character index it means string is not unique else unique

        boolean[] charPresent = new boolean[128];

        for (int i=0 ; i< input.length(); i++) {
            int val= input.charAt(i);
            if (charPresent[val]) {
                return false;
            }
            charPresent[val] = true;
        }
        return true;


    }
}
