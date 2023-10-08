package com.jitin.junit.leetcode;

import java.util.*;

public class GroupAnagram {

  public static void main(String[] args) {

    String[] strings = new String[]{"eat","tea","tan", "ate", "nat", "bat"};
    Collection<List<String>> groups = groupAnagrams(strings);
    System.out.println(groups);
  }

  private static Collection<List<String>> groupAnagrams(String[] strings) {
    Map<String,List<String>> groups = new HashMap<>();

    for (String str: strings) {
      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      String key = new String(chars);
      if (!groups.containsKey(key)) {
        groups.put(key, new ArrayList<>());
      }
      groups.get(key).add(str);
    }
    return groups.values();
  }
}
