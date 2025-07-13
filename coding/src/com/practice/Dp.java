package com.practice;

import java.util.Arrays;

public class Dp {

    static int[][] memo;
    public static void main(String[] args) {
        Dp dp = new Dp();
        String s1 = "Geek";
        String s2 = "eke";
        memo = new int[s1.length()][s2.length()];
        for (int[] row: memo) {
            Arrays.fill(row, -1);
        }
        int longestCommonSubsequence = dp.longestCommonSubsequence(s1, s2);
        System.out.println(longestCommonSubsequence);


        int lcs3 = dp.lcs3("ABCD", "BACDBDCD", "ABCD".length(), "BACDBDCD".length());
        System.out.println(lcs3);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        return lcs(text1, text2, 0, 0);
        // return lcs2(text1, text2, text1.length(), text2.length());
    }

    private int lcs(String s1, String s2, int m, int n) {
        if (m == s1.length() || n == s2.length()) {
            return 0;
        }

        if (memo[m][n] != -1) {
            return memo[m][n];
        }

        if (s1.charAt(m) == s2.charAt(n)) {
            return memo[m][n] = 1 + lcs(s1, s2, m + 1, n + 1);
        }

        return memo[m][n] = Math.max(
                lcs(s1, s2, m + 1, n),
                lcs(s1, s2, m, n + 1)
        );
    }

    private int lcs2(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if (memo[m][n] != -1) {
            return memo[m][n];
        }

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return memo[m][n] = 1 + lcs2(s1, s2, m - 1, n - 1);
        }

        return memo[m][n] = Math.max(
                lcs2(s1, s2, m - 1, n),
                lcs2(s1, s2, m, n - 1)
        );
    }

    private int lcs3(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return 1 + lcs3(s1, s2, m - 1, n - 1);
        } else {
            return Math.max(lcs3(s1, s2, m - 1, n), lcs3(s1, s2, m, n - 1));
        }
    }
}
