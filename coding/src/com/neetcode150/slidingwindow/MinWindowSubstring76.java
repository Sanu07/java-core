package com.neetcode150.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring76 {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        // BANC - O/P
        String b = minWindow(s, t);
        System.out.println(b);
    }

    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> tMap = new HashMap<>();
        for (char ch: t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }

        int l = 0, r = 0, matched = 0;
        int minLen = Integer.MAX_VALUE;
        int start = l;
        Map<Character, Integer> window = new HashMap<>();
        while (r < s.length()) {
            char right = s.charAt(r);
            window.put(right, window.getOrDefault(right, 0) + 1);

            if (tMap.containsKey(right) && window.get(right).intValue() == tMap.get(right).intValue()) {
                matched++;
            }

            while (matched == tMap.size()) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    start = l;
                }

                char left = s.charAt(l);
                window.put(left, window.get(left) - 1);
                if (tMap.containsKey(left) && window.get(left) < tMap.get(left)) {
                    matched--;
                }
                l++;
            }
            r++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
