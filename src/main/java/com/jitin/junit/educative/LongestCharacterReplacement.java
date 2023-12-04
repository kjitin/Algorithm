package com.jitin.junit.educative;

import java.util.HashMap;
import java.util.Map;

public class LongestCharacterReplacement {

  public static void main(String[] args) {
    String first = "aaacbbbaabab";
    System.out.println(longestRepeatingCharacterReplacement(first, 2));
  }
  public static int longestRepeatingCharacterReplacement(String s, int k) {
    int start = 0;
    int window;
    int mostFreqChar = 0;
    Map<Character, Integer> characterMap = new HashMap<>();
    int longestCharacterLength = 0;
    for(int end = 0; end < s.length(); end++) {
      Character character = s.charAt(end);
      characterMap.put(character, characterMap.getOrDefault(character, 0)+1);
      mostFreqChar = Math.max(mostFreqChar, characterMap.get(character));
      window = (end - start + 1);
      if(window - mostFreqChar > k) {
        characterMap.put(s.charAt(start), characterMap.get(s.charAt(start)) -1);
        start = start+1;
      }
      longestCharacterLength = Math.max(longestCharacterLength, end -start+1);
    }

    return longestCharacterLength;
  }
}
