package com.leetcode.february;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalHappyString1415 {
    public static void main(String[] args) {
        int arr[][] = {{1, 3}, {1, 4}, {3, 9}};
        LexicographicalHappyString1415 lexicographicalHappyString1415 = new LexicographicalHappyString1415();
        for (int[] a: arr) {
            String happyString = lexicographicalHappyString1415.getHappyString(a[0], a[1]);
            System.out.println(happyString);
        }
    }

    // List to hold all happy strings
    private List<String> happyStrings = new ArrayList<>();

    // Function to return the kth happy string of length n
    public String getHappyString(int n, int k) {
        // Generate all happy strings of length n
        generateHappyStrings("", n);
        // If the list size is less than k, no such k-th happy string exists. Return an empty string.
        String string = happyStrings.size() < k ? "" : happyStrings.get(k - 1);
        happyStrings.clear();
        return string;
    }

    // Helper function to generate happy strings using Depth First Search (DFS)
    private void generateHappyStrings(String current, int n) {
        // If the current string's length is n, add it to the list of happy strings
        if (current.length() == n) {
            happyStrings.add(current);
            return;
        }

        // Loop through the characters 'a', 'b', and 'c'
        for (char currCharacter : "abc".toCharArray()) {
            // If the last character of the current string is the same as 'c', skip to the next iteration
            // to ensure we do not have consecutive same characters, which makes the string unhappy
            if (current.length() > 0 && current.charAt(current.length() - 1) == currCharacter) {
                continue;
            }
            // Otherwise, add 'c' to current and continue to search for the rest of the string
            generateHappyStrings(current + currCharacter, n);
        }
    }
}
