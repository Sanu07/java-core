package com.practice;

import java.util.*;

public class ShortestSuperstring {

    // Helper function to find the maximum overlap between two strings
    private static int overlap(String a, String b) {
        int maxOverlap = 0;
        // Find the maximum overlap where the suffix of a matches the prefix of b
        for (int i = 1; i <= Math.min(a.length(), b.length()); i++) {
            if (a.substring(a.length() - i).equals(b.substring(0, i))) {
                maxOverlap = i;
            }
        }
        return maxOverlap;
    }

    // Function to find the shortest superstring
    public static String shortestSuperstring(List<String> strings) {
        while (strings.size() > 1) {
            int maxOverlap = -1;
            int l1 = -1, l2 = -1;
            String mergedString = "";

            // Find the pair of strings with the maximum overlap
            for (int i = 0; i < strings.size(); i++) {
                for (int j = 0; j < strings.size(); j++) {
                    if (i != j) {
                        int overlap = overlap(strings.get(i), strings.get(j));
                        if (overlap > maxOverlap) {
                            maxOverlap = overlap;
                            l1 = i;
                            l2 = j;
                            mergedString = strings.get(i) + strings.get(j).substring(overlap);
                        }
                    }
                }
            }

            // Merge the two strings with the maximum overlap
            strings.remove(l1);
            if (l2 > l1) {
                l2--; // Adjust the index after removing l1
            }
            strings.remove(l2);
            strings.add(mergedString); // Add the merged string back to the list
        }

        return strings.get(0); // Only one string will remain, which is the shortest superstring
    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("cat");
        strings.add("dog");
        strings.add("god");

        String result = shortestSuperstring(strings);
        System.out.println("Shortest Superstring: " + result);
    }
}
