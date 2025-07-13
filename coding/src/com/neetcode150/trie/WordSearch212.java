package com.neetcode150.trie;

import com.trie.test.Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSearch212 {

    char[][] fullBoard = null;
    List<String> ans = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();

        // create the trie
        for (String word: words) {
            TrieNode curr = root;
            for (char ch: word.toCharArray()) {
                if (!curr.children.containsKey(ch)) {
                    curr.children.putIfAbsent(ch, new TrieNode());
                }
                curr = curr.children.get(ch);
            }
            curr.wordEnd = true;
            curr.actualWord = word;
        }

        this.fullBoard = board;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (root.children.containsKey(fullBoard[i][j])) {
                    backtracking(i, j, root);
                }
            }
        }

        System.out.println(ans);
        return ans;
    }

    public void backtracking(int row, int col, TrieNode root) {
        char letter = fullBoard[row][col];
        TrieNode curr = root.children.get(letter);

        if (curr.wordEnd && curr.actualWord != null) {
            ans.add(curr.actualWord);
            curr.actualWord = null;
        }
        fullBoard[row][col] = '#';

        int[] rowOffset = {-1, 0, 1, 0};
        int[] colOffset = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int newRow = row + rowOffset[i];
            int newCol = col + colOffset[i];

            if (newRow < 0 || newRow >= fullBoard.length || newCol < 0 || newCol >= fullBoard[0].length) {
                continue;
            }

            if (curr.children.containsKey(fullBoard[newRow][newCol])) {
                backtracking(newRow, newCol, curr);
            }
        }
        fullBoard[row][col] = letter;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'o', 'a', 'a', 'n'},
            {'e', 't', 'a', 'e'},
            {'i', 'h', 'k', 'r'},
            {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath","pea","eat","rain"};
        new WordSearch212().findWords(board, words);
    }

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean wordEnd;
        String actualWord;
    }
}
