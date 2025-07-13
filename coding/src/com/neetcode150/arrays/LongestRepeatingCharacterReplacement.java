package com.neetcode150.arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        int res = new LongestRepeatingCharacterReplacement().characterReplacement(s, k);
        System.out.println(res);
    }

    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int res = 0;
        int maxFreq = 0;
        while (r < s.length()) {
            char ch = s.charAt(r);
            int chFreq = map.getOrDefault(ch, 0) + 1;
            // add freq count
            map.put(ch, chFreq);

            // Update maxFreq with the frequency of
            // the most frequent character in the
            // current window
            maxFreq = Math.max(maxFreq, chFreq);

            // Shrink the window if more than k changes
            // required
            if ((r - l + 1) - maxFreq > k) {
                map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0) - 1);
                l++;
            }
            // Update the maximum length of the substring
            res = Math.max(res, (r - l + 1));
            r++;
        }
        return res;
    }
}
