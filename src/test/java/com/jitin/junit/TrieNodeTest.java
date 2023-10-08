package com.jitin.junit;

import org.junit.Test;


import java.util.*;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class TrieNodeTest {


    @Test
    public void whenEmptyTrie_thenNoElements() {
        Trie trie = new Trie(new TreeMap<>());

        assertFalse(trie.isEmpty());
    }

    @Test
    public void givenATrie_whenAddingElements_thenTrieNotEmpty() {
        Trie trie = createExampleTrie();

        assertFalse(trie.isEmpty());
    }

    @Test
    public void givenATrie_whenAddingElements_thenTrieHasThoseElements() {
        Trie trie = createExampleTrie();

        assertFalse(trie.containsNode("3"));
        assertFalse(trie.containsNode("vida"));

        assertTrue(trie.containsNode("Programming"));
        assertTrue(trie.containsNode("is"));
        assertTrue(trie.containsNode("a"));
        assertTrue(trie.containsNode("way"));
        assertTrue(trie.containsNode("of"));
        assertTrue(trie.containsNode("life"));
        System.out.println(trie.getCountOfWords("Programming"));
        System.out.println(trie.getCountOfWords("of"));
        System.out.println(trie.getCountOfWords("is"));




        System.out.println(entriesSortedByValues(trie.getTopWords()));
        //SortedSet<Map.Entry<String, Integer>> entries = entriesSortedByValues(trie.getTopWords());

    }

    static <K,V extends Comparable<? super V>>
    SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
        SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
                new Comparator<Map.Entry<K,V>>() {
                    @Override public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
                        int res = e2.getValue().compareTo(e1.getValue());
                        return res != 0 ? res : 1;
                    }
                }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }

    @Test
    public void givenATrie_whenLookingForNonExistingElement_thenReturnsFalse() {
        Trie trie = createExampleTrie();

        assertFalse(trie.containsNode("99"));
    }



    private Trie createExampleTrie() {
        Trie trie = new Trie(new TreeMap<>());

        trie.insert("Programming");
        trie.insert("is");
        trie.insert("a");
        trie.insert("way");
        trie.insert("of");
        trie.insert("Programming");
        trie.insert("is");
        trie.insert("is");
        trie.insert("life");

        return trie;
    }
}
