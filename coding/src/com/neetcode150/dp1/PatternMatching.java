package com.neetcode150.dp1;

public class PatternMatching {
    
    public boolean isMatch(String str, String pattern) {
        return matchHelper(str, pattern, 0, 0);
    }

    private boolean matchHelper(String str, String pattern, int i, int j) {
        // If both string and pattern are fully matched
        if (i == str.length() && j == pattern.length()) {
            return true;
        }

        // If pattern ends but string doesn't
        if (j == pattern.length()) {
            return false;
        }

        // If string ends but pattern may still match if remaining pattern is '*'
        if (i == str.length()) {
            return pattern.charAt(j) == '*' && matchHelper(str, pattern, i, j + 1);
        }

        char sChar = str.charAt(i);
        char pChar = pattern.charAt(j);

        if (pChar == '*') {
            // * can match 0 or more characters
            return matchHelper(str, pattern, i + 1, j) || matchHelper(str, pattern, i, j + 1);
        } else if (pChar == '?' || sChar == pChar) {
            return matchHelper(str, pattern, i + 1, j + 1);
        } else {
            return false;
        }
    }

    // Example usage
    public static void main(String[] args) {
        PatternMatching pm = new PatternMatching();
        System.out.println(pm.isMatch("abcde", "a*de"));  // true
        System.out.println(pm.isMatch("abc", "a?c"));     // true
        System.out.println(pm.isMatch("abc", "a*d")); // false
        System.out.println(pm.isMatch("aab", "c*a*b")); // true
    }
}
