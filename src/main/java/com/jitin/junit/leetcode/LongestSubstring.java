package com.jitin.junit.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {


  public static void main(String[] args) {
    String sub = "abcdefabsd";// [abcdef, bcdefa, cdefabs, efabsd]
    System.out.println(bruteLongestSubstring(sub));

    System.out.println(lengthOfLongestSubstringArray(sub));

    System.out.println(lengthOfLongestSubstring(sub));
  }

  private static int lengthOfLongestSubstring(String sub) {
    int n = sub.length(), ans = 0;
    Map<Character, Integer> map = new HashMap<>(); // current index of character
    // try to extend the range [i, j]
    for (int right = 0, left = 0; right < n; right++) { // n =10
      if (map.containsKey(sub.charAt(right))) { //sub: "abcdefabsd"
        left = Math.max(map.get(sub.charAt(right)), left); // left = map.getCharAt(6) : 'a' 97 : 1 : Math.max(1, 0): 1 | 'b' 98 :left=2 | 'd' Math.max(4, 2)
      }
      ans = Math.max(ans, right - left + 1); //(a) 0-0+1-ans =1 |(b) 1-0+1 - ans =2 |(c) 2-0+1-ans =3...6|(a)Math.max(6, 6-1+1) : 6 |(b) (7-2+1) |(s) (6, 8-2+1)| (d) (7, 9-4+1)
      map.put(sub.charAt(right), right + 1); //{a: 1 changed to 7, b:2 changed to 8 ,c:3, d:4 changed to 10, e:5,f:6,s:9 }
    }
    return ans;

  }

  private static int lengthOfLongestSubstringArray(String sub) {
    Integer[] chars = new Integer[128];

    int left =0;
    int right = 0;
    int result = 0;

    while (right< sub.length()) {
      char r = sub.charAt(right);

      Integer index = chars[r];

      if (index != null && index >= left && index < right) {
        left = index+1;
      }
      result = Math.max(result, right- left +1);
      chars[r] = right;
      right++;
    }
    return result;
  }

  private static int bruteLongestSubstring(String sub) {
    int n = sub.length();
    int res = 0;

    for (int i=0; i< n ; i++) {
      for (int j=i; j <n; j ++) {
        if(check(sub, i, j)){
          res = Math.max(res, j-i+1);
        }
      }
    }
    return res;
  }

  private static boolean check(String sub, int start, int end) {
    int[] chars = new int[128];

    for (int i = start; i <= end; i++) {
      char c = sub.charAt(i);
      chars[c]++;
      if (chars[c] > 1) return false;
    }
    return true;
  }
}
