package com.misc;

import java.util.*;

public class WordBreak139 {

    public static void main(String[] args) {
        String s = "aaaaaaaaaaaab";
        List<String> leet = List.of("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
        boolean b = new WordBreak139().wordBreak(s, leet);
        System.out.println(b);
    }



    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        int maxLen = 0;
        for (String word: wordDict) {
            maxLen = Math.max(maxLen, word.length());
        }

        queue.offer(0); // start from index 0

        while (!queue.isEmpty()) {
            int start = queue.poll();

            if (visited.contains(start)) continue;
            visited.add(start);

            for (int end = start + 1; end <= Math.min(start + maxLen, s.length()); end++) {
                if (wordSet.contains(s.substring(start, end))) {
                    if (end == s.length()) return true;
                    queue.offer(end);
                }
            }
        }

        return false;
    }
}
