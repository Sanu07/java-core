package com.leetcode.problems;

import java.util.*;

public class CountPalindromeAndSubsequence1930 {

    public static void main(String[] args) {
        String s = "tlpjzdmtwderpkpmgoyrcxttiheassztncqvnfjeyxxp";
        int countedPalindromicSubsequence = new CountPalindromeAndSubsequence1930().countPalindromicSubsequence(s);
        System.out.println(countedPalindromicSubsequence);
    }

    private Set<String> set = new HashSet<>();


    public int countPalindromicSubsequence(String s) {
        String[] split = s.split("");
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < split.length; i++) {
            if (map.containsKey(split[i])) {
                map.get(split[i]).add(i);
            } else {
                map.put(split[i], new ArrayList<>());
                map.get(split[i]).add(i);
            }
        }
        map.forEach((k, v) -> {
            if (v.size() > 1) {
                int start = v.get(0);
                int end = v.get(v.size() - 1);
                int j = start + 1;
                while (j < end) {
                    String temp = split[start] + split[j] + split[end];
                    set.add(temp);
                    j++;
                }
            }
        });
        return set.size();
    }
}
