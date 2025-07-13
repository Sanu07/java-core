package com.leetcode.sanu;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("maxRepeating :: --> " + solution.maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));
    }

    public int maxRepeating(String sequence, String word) {
        int count = 0;
        int j = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < sequence.length();) {
            if (i + word.length() <= sequence.length()) {
                if (word.equals(sequence.substring(i, i + word.length()))) {
                    ++count;
                    i += word.length();
                } else {
                    count = 0;
                    i = j++;
                }
            } else {
                break;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
