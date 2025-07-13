package com.trie.lower_upper;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean wordEnd;

    public TrieNode() {
        this.wordEnd = false;
    }
}
