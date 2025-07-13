package com.neetcode150.trie;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary211 {

    TrieNode root;

    public WordDictionary211() {
        this.root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for (char ch: word.toCharArray()) {
            if (curr.children.get(ch) == null) {
                curr.children.put(ch, new TrieNode());
            }
            curr = curr.children.get(ch);
        }
        curr.wordEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        return searchNode(word, node);
    }

    private boolean searchNode(String word, TrieNode curr) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!curr.children.containsKey(ch)) {
                if (ch == '.') {
                    for (char c: curr.children.keySet()) {
                        TrieNode child = curr.children.get(c);
                        if (searchNode(word.substring(i + 1), child)) {
                            return true;
                        }
                    }
                } else {
                    return false;
                }
            } else {
                curr = curr.children.get(ch);
            }
        }
        return curr.wordEnd;
    }

    public static class TrieNode {
        Map<Character, TrieNode> children;
        boolean wordEnd;

        public TrieNode() {
            this.children = new HashMap<>();
            this.wordEnd = false;
        }
    }

    public static void main(String[] args) {
        WordDictionary211 wordDictionary211 = new WordDictionary211();
        wordDictionary211.addWord("bad");
        wordDictionary211.addWord("dad");
        wordDictionary211.addWord("mad");
        System.out.println(wordDictionary211.search("pad"));
        System.out.println(wordDictionary211.search("bad"));
        System.out.println(wordDictionary211.search(".ad"));
        System.out.println(wordDictionary211.search("b.."));
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */