package com.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class RobotPrintLexiSmall_2434 {

    public String robotWithString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        char[] sArr = s.toCharArray();
        List<Character> t = new ArrayList<>();
        char[] p = new char[s.length()];

        t.add(sArr[0]);

        int i = 1;
        int k = 0;
        while (i < sArr.length) {
            if (sArr[i] >= sArr[i - 1]) {
                t.add(sArr[i]);
            } else {
                t.add(sArr[i]);
                while (!t.isEmpty()) {
                    p[k++] = t.remove(t.size() - 1);
                }
            }
            i++;
        }
        while (!t.isEmpty()) {
            p[k++] = t.remove(t.size() - 1);
        }
        return new String(p);
    }

    public static void main(String[] args) {
        String[] ss = {"bac", "zza", "bdda"};
        for (String s: ss) {
            String s1 = new RobotPrintLexiSmall_2434().robotWithString(s);
            System.out.println(s1);
        }
    }
}
