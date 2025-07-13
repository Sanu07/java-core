package com.trie.test;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class TrieNode {

    private Map<Character, TrieNode> children = new HashMap<>();
    private boolean wordEnd;

}
