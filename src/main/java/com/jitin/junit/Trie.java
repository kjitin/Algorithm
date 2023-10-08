package com.jitin.junit;

import java.util.TreeMap;

public class Trie {

    private TrieNode root;

    private TreeMap<String, Integer> topWords;

    Trie(TreeMap<String, Integer> topWords){
        root = new TrieNode();
        this.topWords = topWords;
    }


    public TreeMap<String, Integer> getTopWords() {
        return topWords;
    }
    public void insert(String word) {

        TrieNode current = root;

        for (int i =0; i< word.length(); i++) {

            current = current.getChildren().computeIfAbsent(word.charAt(i), c -> new TrieNode());
        }
        current.setEndOfWord(true);
        current.setKey(word);

        topWords.put(word, current.getCount());
    }


    public int getCountOfWords(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.getChildren().get(ch);
            if (node == null) {
                return -1;
            }
            current = node;
        }
        return current.getCount();
    }


    public boolean delete(String word) {
        return delete(root, word, 0);
    }

    boolean containsNode(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.getChildren().get(ch);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.isEndOfWord();
    }

    boolean isEmpty() {
        return root == null;
    }

    public boolean delete(TrieNode current, String word, int index) {

        if (index == word.length()) {

            if (!current.isEndOfWord()) {
                return false;
            }
            current.setEndOfWord(false);

            return current.getChildren().isEmpty();
        }

        char ch = word.charAt(index);
        TrieNode node = current.getChildren().get(ch);

        if (node == null) {
            return  false;
        }

        boolean shouldDeleteCurrentNode = delete(node, word, index+1 ) && !node.isEndOfWord();

        if (shouldDeleteCurrentNode) {
            current.getChildren().remove(ch);
            return current.getChildren().isEmpty();
        }

        return false;

    }

}