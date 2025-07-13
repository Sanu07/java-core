package com.trie.lower_upper;

public class TrieTest {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");
        trie.insert("apricot");
        trie.insert("banana");
        trie.insert("bat");
        trie.insert("batch");

        System.out.println("Search apple: " + trie.search("apple")); // true
        System.out.println("Search apricot: " + trie.search("apricot")); // true
        System.out.println("Search apr: " + trie.search("apr")); // false

        System.out.println("StartsWith 'ba': " + trie.startsWith("ba")); // true
        System.out.println("Words with prefix 'app': " + trie.getWordsWithPrefix("app")); // ["app", "apple"]
        System.out.println("Words with prefix 'bat': " + trie.getWordsWithPrefix("bat")); // ["bat", "batch"]
        System.out.println("Words with prefix 'b': " + trie.getWordsWithPrefix("b")); // []
    }
}
