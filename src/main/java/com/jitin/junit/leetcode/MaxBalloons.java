package com.jitin.junit.leetcode;

public class MaxBalloons {


  public static void main(String[] args) {

    String text = "balloonballon";
    int maxNumber = maxNumberOfBalloons(text);

    System.out.println(maxNumber);
  }

  private static int maxNumberOfBalloons(String text) {
    String pattern = "balloon";
    return findMaxNumberOfPattern(text, pattern);
  }

  private static int findMaxNumberOfPattern(String text, String pattern) {
    int n = text.length(), m = pattern.length(), answer = Integer.MAX_VALUE;
    int freqInText[] = new int[26];
    int freqInPattern[] = new int[26];

    // Frequency of characters in text.
    for (int i = 0; i < n; i++) {
      freqInText[text.charAt(i) - 'a']++;
    }
    // Frequency of characters in pattern.
    for (int i = 0; i < m; i++) {
      freqInPattern[pattern.charAt(i) - 'a']++;
    }

    // Compare the maximum string that can be produced
    // considering one character at a time.
    for (int i = 0; i < 26; i++) {
      // Do not divide by zero.
      if (freqInPattern[i] > 0) {
        answer = Math.min(answer, freqInText[i] / freqInPattern[i]);
      }
    }

    return answer;
  }
}
