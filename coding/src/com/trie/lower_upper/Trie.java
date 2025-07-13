package com.trie.lower_upper;

import java.util.ArrayList;
import java.util.List;

public class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert a word into the Trie
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node = node.children.computeIfAbsent(ch, c -> new TrieNode());
        }
        node.wordEnd = true;
    }

    // Search for an exact word
    public boolean search(String word) {
        TrieNode node = searchNode(word);
        return node != null && node.wordEnd;
    }

    // Check if a prefix exists
    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }

    // Get list of words that start with a given prefix
    public List<String> getWordsWithPrefix(String prefix) {
        List<String> results = new ArrayList<>();
        TrieNode node = searchNode(prefix);
        if (node == null) {
            return results;
        }
        dfs(node, prefix, results);
        return results;
    }

    // Helper to find a node representing the last character of a word/prefix
    private TrieNode searchNode(String input) {
        TrieNode node = root;
        for (char ch : input.toCharArray()) {
            node = node.children.get(ch);
            if (node == null) return null;
        }
        return node;
    }

    // DFS to collect all words from a given node
    private void dfs(TrieNode node, String prefix, List<String> result) {
        if (node.wordEnd) {
            result.add(prefix);
        }
        for (char ch : node.children.keySet()) {
            dfs(node.children.get(ch), prefix + ch, result);
        }
    }
}
