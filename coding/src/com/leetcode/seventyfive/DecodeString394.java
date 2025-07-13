package com.leetcode.seventyfive;

import com.graph.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DecodeString394 {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
//        list.add("3[a]2[bc]");
//        list.add("3[a2[c]]");
//        list.add("2[abc]3[cd]ef");
        list.add("100[leetcode]");

        for (String s: list) {
            String s2 = decodeString(s);
            System.out.println(s + " --->>> " + s2);
        }
    }

    public static String decodeString(String s) {
        Stack<Integer> numberStack = new Stack<>();
        Stack<StringBuilder> sbStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = 0;

        for (char c: s.toCharArray()) {
            if (Character.isDigit(c)) {
                n = n * 10 + (c - '0');
            } else if (c == '[') {
                numberStack.push(n);
                sbStack.push(sb);
                sb = new StringBuilder();
                n = 0;
            } else if (c == ']') {
                int k = numberStack.pop();
                StringBuilder temp = sb;
                sb = sbStack.pop();
                while (k-- > 0) {
                    sb.append(temp);
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
