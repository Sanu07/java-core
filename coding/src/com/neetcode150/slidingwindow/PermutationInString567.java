package com.neetcode150.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString567 {

    public static void main(String[] args) {
        String s1 = "adc";
        String s2 = "dcda";
        boolean b = checkInclusion(s1, s2);
        System.out.println(b);
    }

    public static boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            s1Map.put(s1.charAt(i), s1Map.getOrDefault(s1.charAt(i), 0) + 1);
            s2Map.put(s2.charAt(i), s2Map.getOrDefault(s2.charAt(i), 0) + 1);
        }

        int l = 0;
        int r = s1.length();

        if (s1Map.equals(s2Map)) {
            return true;
        }

        while (r < s2.length()) {
            int count = s2Map.get(s2.charAt(l));
            if (count == 1) {
                s2Map.remove(s2.charAt(l));
            } else {
                s2Map.put(s2.charAt(l), s2Map.get(s2.charAt(l)) - 1);
            }

            s2Map.put(s2.charAt(r), s2Map.getOrDefault(s2.charAt(r), 0) + 1);
            if (s1Map.equals(s2Map)) {
                return true;
            }
            r++;
            l++;
        }
        return false;
    }
}
