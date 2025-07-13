package com.reursion.lcs;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String S1 = "AGGTAB";
        String S2 = "GS1TS1AS2B";
        int m = S1.length() - 1;
        int n = S2.length() - 1;

        System.out.println("Length of LCS is"
                + " " + lcs(S1, S2, m, n));
    }

    private static int lcs(String s1, String s2, int m, int n) {
        if (m == -1 || n == -1) {
            return 0;
        }
        if (s1.charAt(m) == s2.charAt(n)) {
            return 1 + lcs(s1, s2, m - 1, n - 1);
        }
        return Math.max(lcs(s1, s2, m, n - 1), lcs(s1, s2, m - 1, n));
    }
}
