package com.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrieOperations {
    public static void main(String[] args) {
        TrieNode root = new TrieNode();
        List<String> arr = Arrays.asList(
                "and", "ant", "do", "geek", "dad", "ball");
        for (String s : arr) {
            insertKey(root, s);
        }

        // One by one search strings
        List<String> searchKeys =
                Arrays.asList("do", "gee", "bat");
        for (String s : searchKeys) {
            System.out.println("Key : " + s);
            if (searchKey(root, s))
                System.out.println("Present");
            else
                System.out.println("Not Present");
        }
    }

    private static void insertKey(TrieNode root, String s) {
        TrieNode curr = root;
        for (char c: s.toCharArray()) {
            if (curr.child[c - 'a'] == null) {
                TrieNode newNode = new TrieNode();
                curr.child[c - 'a'] = newNode;
            }
            curr = curr.child[c - 'a'];
        }
        curr.wordEnd = true;
    }

    private static boolean searchKey(TrieNode root, String s) {
        TrieNode curr = root;
        for (char c: s.toCharArray()) {
            if (curr.child[c - 'a'] == null) {
                return false;
            }
            curr = curr.child[c - 'a'];
        }
        return curr.wordEnd;
    }

    private static boolean startsWith(TrieNode root, String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            if (curr.child[c - 'a'] == null) {
                return false;
            }
            curr = curr.child[c - 'a'];
        }
        return true;
    }


    private static List<String> getWordsWithPrefix(TrieNode root, String prefix) {
        List<String> results = new ArrayList<>();
        TrieNode curr = root;

        for (char c : prefix.toCharArray()) {
            if (curr.child[c - 'a'] == null) {
                return results;
            }
            curr = curr.child[c - 'a'];
        }

        collectWords(curr, prefix, results);
        return results;
    }

    private static void collectWords(TrieNode node, String prefix, List<String> results) {
        if (node.wordEnd) {
            results.add(prefix);
        }
        for (char c = 'a'; c <= 'z'; c++) {
            TrieNode childNode = node.child[c - 'a'];
            if (childNode != null) {
                collectWords(childNode, prefix + c, results);
            }
        }
    }
}
