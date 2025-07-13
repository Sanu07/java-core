package com.trie.test;

import java.util.ArrayList;
import java.util.List;

public class Trie {

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char ch: word.toCharArray()) {
            node.getChildren().putIfAbsent(ch, new TrieNode());
            node = node.getChildren().get(ch);
        }
        node.setWordEnd(true);
    }

    public boolean search(String word) {
        TrieNode node = searchNode(word);
        return node != null && node.isWordEnd();
    }

    public boolean prefix(String prefix) {
        TrieNode node = searchNode(prefix);
        return node != null;
    }

    public TrieNode searchNode(String input) {
        TrieNode node = root;
        for (char ch: input.toCharArray()) {
            node = node.getChildren().get(ch);
            if (node == null) {
                return null;
            }
        }
        return node;
    }

    public List<String> getWordsWithPrefix(String prefix) {
        List<String> results = new ArrayList<>();
        TrieNode node = searchNode(prefix);
        if (node == null) {
            return results;
        }
        collectWords(node, prefix, results);
        return results;
    }

    public void collectWords(TrieNode node, String prefix, List<String> results) {
        if (node.isWordEnd()) {
            results.add(prefix);
        }
        for (char ch: node.getChildren().keySet()) {
            collectWords(node.getChildren().get(ch), prefix + ch, results);
        }
    }
}
