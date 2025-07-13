package com.neetcode150.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParenthesis22 {

    public static void main(String[] args) {
        List<String> res = new GenerateParenthesis22().generateParenthesis(3);
        List<String> res2 = new GenerateParenthesis22().generateParenthesisUsingStack(3);
        System.out.println(res);
        System.out.println("****************************************");
        System.out.println(res2);
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generateParenthesis(n, 0, 0, "", ans);
        return ans;
    }

    private void generateParenthesis(int n, int l, int r, String temp, List<String> ans) {
        if (l == n && r == n) {
            ans.add(temp);
            return;
        }
        if (l != n) {
            generateParenthesis(n, l + 1, r, temp + "(", ans);
        }
        if (l > r) {
            generateParenthesis(n, l, r + 1, temp + ")", ans);
        }
    }

    public List<String> generateParenthesisUsingStack(int n) {
        List<String> ans = new ArrayList<>();
        Stack<State> s = new Stack<>();
        s.push(new State("", 0, 0));
        while (!s.isEmpty()) {
            State curr = s.pop();

            if (curr.open == n && curr.close == n) {
                ans.add(curr.str);
                continue;
            }

            if (curr.open < n) {
                s.push(new State(curr.str + "(", curr.open + 1, curr.close));
            }

            if (curr.close < curr.open) {
                s.push(new State(curr.str + ")", curr.open, curr.close + 1));
            }
        }
        return ans;
    }


    public static class State {
        String str;
        int open;
        int close;

        public State(String str, int open, int close) {
            this.str = str;
            this.open = open;
            this.close = close;
        }
    }
}
