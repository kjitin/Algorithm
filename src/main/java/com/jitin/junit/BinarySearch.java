package com.jitin.junit;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BinarySearch {


    int[] searchArea = {5, 9 , 23 , 45, 56, 58};
    public void findNumberUsingBinarySearch(int number) {
        int low =0;
        int high = searchArea.length -1;
        int mid = 0;
        boolean isFound = false;

        while (!isFound) {

            if (number > searchArea[high]) {
                System.out.println("Number not found");
                break;
            }
            if (low > high) {
                System.out.println("Number not found");
                break;
            }

            mid = (low + (high - low)/2);

            if (number == searchArea[mid]) {
                System.out.println("Number found" + searchArea[mid]);
                isFound = true;
            }

            if (searchArea[mid] < number) {
                low = mid+1;
            }
            if (searchArea[mid] > number) {
                high = mid -1;
            }
        }







    }
    public static void main(String[] args) {

        BinarySearch binarySearch = new BinarySearch();
        binarySearch.findNumberUsingBinarySearch(57);

    }


    public void readFile(String fileName) throws URISyntaxException, IOException {


        Path path = Paths.get(fileName);

        Stream<String> lines = Files.lines(path);
        TreeMap<String, Integer> topWords = new TreeMap<>();
        Trie trie = new Trie(topWords);
        List<String> data = lines.collect(Collectors.toList());
        for (String text: data) {
            System.out.println(text);
            String[] strings = text.split(" ");
            List<String> stringList = Arrays.asList(strings);
            for (String word: stringList) {
                trie.insert(word);
            }

        }
        System.out.println("Writing count is "+ trie.getCountOfWords("A"));

        System.out.println("Top 10 words are ");
        int i= 0;
        System.out.println(entriesSortedByValues(topWords));
        lines.close();
    }

    static <K,V extends Comparable<? super V>>
    SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
        SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
                new Comparator<Map.Entry<K,V>>() {
                    @Override public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
                        int res = e1.getValue().compareTo(e2.getValue());
                        return res != 0 ? res : 1;
                    }
                }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }




}
