package com.jitin.junit.educative;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class LongestSubstring {


  public static void main(String[] args) {
    System.out.println(findLongestSubstring("abcdbea"));
  }
  public static int findLongestSubstring(String str) {

    Map<Character, Integer> charIndex = new HashMap<>();

    int start;
    int longestSubstring = 0;
    int windowStart = 0;
    for(start = 0; start < str.length(); start++) {
      char ch = str.charAt(start);
      if(charIndex.containsKey(ch)) {
        if(charIndex.get(ch) >= windowStart) {
          longestSubstring = Math.max(longestSubstring, start - windowStart);
          windowStart = charIndex.get(ch) +1;
        }
        charIndex.put(ch, start);
      } else {
        charIndex.put(ch, start);
      }
    }
    longestSubstring = Math.max(longestSubstring, start - windowStart);
    return longestSubstring;
  }

  public static int findLongestSubstring1(String str) {

    // Check the length of input str
    if (str.length() == 0) {
      return 0;
    }

    int n = str.length();
    int windowStart = 0, longest = 0, windowLength = 0, i = 0;

    Hashtable<Character, Integer> lastSeenAt = new Hashtable <Character, Integer> ();

    // Traverse input str to find the longest substring
    // without repeating characters.
    for (i = 0; i < n; i++) {
      // If the current element is not present in the hash map,
      // then store it in the hash map with the current index as the value.
      if (!lastSeenAt.containsKey(str.charAt(i))) {
        lastSeenAt.put(str.charAt(i), i);
      } else {

        // If the current element is present in the hash map,
        // it means that this element may have appeared before.
        // Check if the current element occurs before or after `windowStart`.
        if (lastSeenAt.get(str.charAt(i)) >= windowStart) {
          windowLength = i - windowStart;
          if (longest < windowLength) {
            longest = windowLength;
          }


          windowStart = lastSeenAt.get(str.charAt(i)) + 1;
        }

        // Update the last occurence of
        // the element in the hash table
        lastSeenAt.replace(str.charAt(i), i);
      }
    }

    // Update the longest substring's
    // length and starting index.
    if (longest < i - windowStart) {
      longest = i - windowStart;
    }

    return longest;
  }
}
