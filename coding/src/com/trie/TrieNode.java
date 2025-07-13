package com.trie;

public class TrieNode {

    TrieNode[] child;
    boolean wordEnd;

    public TrieNode() {
        this.child = new TrieNode[26];
    }
}
