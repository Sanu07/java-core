package com.leetcode.anchal;

import java.util.Arrays;

public class Zigzag {


    public static void main(String[] args) {
        String str = "Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers."; // PAHNAPLSIIGYIR
        String convert = convert(str, 2);
        System.out.println(convert);
    }

    public static String convert(String s, int numRows) {
        int r = numRows;
        if (r == 1) {
            return s;
        }
        int c = numOfColumns(s.length(), r);
        char[][] zigzag = new char[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                zigzag[i][j] = '0';
            }
        }
        zigzagArrangement(zigzag, s);
        System.out.println(Arrays.deepToString(zigzag));
        String res = "";
        for (int i = 0; i < zigzag.length; i++) {
            for (int j = 0; j < zigzag[0].length; j++) {
                if (zigzag[i][j] != '0') {
                    res = res + zigzag[i][j];
                }
            }
        }
        return res;
    }

    private static void zigzagArrangement(char[][] zigzag, String s) {
        int r = 0;
        int c = 0;
        int idx = 0;
        while (idx < s.length()) {
            for (; r < zigzag.length && idx < s.length(); r++) {
                zigzag[r][c] = s.charAt(idx++);
            }
            r = r - 2;
            c = c+ 1;
            while (r > 0 && idx < s.length()) {
                zigzag[r--][c++] = s.charAt(idx++);
            }
        }
    }

    private static int numOfColumns(int n, int r) {
        int c = 0;
        int i = 0;
        while (n >= 0) {
            if (i % 2 == 0) {
                c = c + 1;
                n = n - r;
            } else {
                c = c + r - 2;
                n = n - (r - 2);
            }
            i++;
        }
        return c;
    }
}
