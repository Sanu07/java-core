package com.contest.fourthirty;

import java.util.ArrayList;
import java.util.List;

public class LexicographicallyLargest {

    public static void main(String[] args) {
        LexicographicallyLargest lexicographicallyLargest = new LexicographicallyLargest();
        String word = "dbca";
        int numFriends = 2;
        splitWord(word, numFriends);
    }

    public static List<String> splitWord(String word, int numFriends) {
        List<String> result = new ArrayList<>();

        // If the number of friends is greater than the length of the word, it's impossible to split
        if (numFriends > word.length()) {
            throw new IllegalArgumentException("numFriends cannot be greater than the length of the word.");
        }

        int partLength = word.length() / numFriends;
        int remainder = word.length() % numFriends;

        int start = 0;

        for (int i = 0; i < numFriends; i++) {
            // Distribute the remainder to the first few parts
            int end = start + partLength + (i < remainder ? 1 : 0);
            result.add(word.substring(start, end));
            start = end;
        }
        System.out.println(result);
        return result;
    }

}
