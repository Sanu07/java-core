package com.leetcode.february;

import java.util.*;

public class LetterTilePossibilities1079 {

    public static void main(String[] args) {
        LetterTilePossibilities1079 letterTilePossibilities1079 = new LetterTilePossibilities1079();
        //, "AAABBC", "V"
        List<String> list = Arrays.asList("AB");
//        list.forEach(input -> {
//            int possibilities = letterTilePossibilities1079.numTilePossibilities(input);
//            //solve("", input);
//            System.out.println(possibilities);
//
//        });

        String subsets = "123";
        letterTilePossibilities1079.subsets(subsets);
    }

    Set<String> all = new HashSet<>();

    public int numTilePossibilities(String tiles) {
        boolean[] visited = new boolean[tiles.length()];
        backtrack(tiles, "", visited);
        int size = all.size();
        all.clear();
        return size;
    }

    private void backtrack(String tiles, String word, boolean[] visited) {
        for (int i = 0; i < tiles.length(); i++) {
            if (visited[i]) continue;
            visited[i] = true;
            String charSequence = word + tiles.charAt(i);
            all.add(charSequence);
            System.out.println(String.format("i -> %d\ncharseq -> %s\nvisited -> %s\nword -> %s\nset -> %s\n\n\n", i, charSequence, Arrays.toString(visited), word, all));
            backtrack(tiles, charSequence, visited);
            visited[i] = false;
        }
    }

    // Permutations of ABC --> [ABC, ACB, BAC, BCA, CAB, CBA]
    public void solve(String curr, String rem) {
        if (rem.length() == 0) { //Base condition for recursion
            System.out.print(curr + " ");
            return;
        }
        for (int i = 0; i < rem.length(); i++) {
            //Rest of the string excluding the current index character
            String ros = rem.substring(0, i) + rem.substring(i + 1);
            //substring(f,s) function returns the string from index f to s-1 inclusive
            solve(curr + rem.charAt(i), ros);
            //recursive call by appending current index character in the curr string
            //and passing remaining of the string for further new arrangements
        }
    }

    public void subsets(String str) {
        List<List<String>> res = new ArrayList<>();
        List<String> subset = new ArrayList<>();
        subsets(str.split(""), 0, subset, res);
        System.out.println(res);
    }

    public void subsets(String[] str, int i, List<String> subset, List<List<String>> res) {
        if (i == str.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        // include the current value and recursively find all subsets
        subset.add(str[i]);
        subsets(str, i + 1, subset, res);

        // exclude the current value and recursively find all subsets
        subset.remove(subset.size() - 1);
        subsets(str, i + 1, subset, res);
    }
}
