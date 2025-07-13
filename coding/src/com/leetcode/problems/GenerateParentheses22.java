package com.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParentheses22 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 1);
        GenerateParentheses22 generateParentheses22 = new GenerateParentheses22();
        list.forEach(e -> {
            List<String> strings = generateParentheses22.backtrack(e);
            System.out.println(e + " ----> " + strings);
        });
    }


    public List<String> backtrack(int n) {
        List<String> list = new ArrayList<>();
        backtrack(n, 0, 0, "", list);
        return list;
    }

    public void backtrack(int n, int l, int r, String str, List<String> list) {
        if (l == n && r == n) {
            list.add(str);
            return;
        }
        if (l != n) {
            backtrack(n, l + 1, r, str + "(", list);
        }
        if (l > r) {
            backtrack(n, l, r + 1, str + ")", list);
        }
        System.out.println(String.format("---END--- --> l %s, r %s", l, r));
    }
}
