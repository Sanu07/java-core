package com.leetcode.problems;

import java.util.Arrays;

public class BagOfTokens_948 {

    public static void main(String[] args) {
        BagOfTokens_948 bagOfTokens948 = new BagOfTokens_948();
        int[] tokens = {200,100};
        int power = 150;
        int res = bagOfTokens948.bagOfTokensScore(tokens, power);
        System.out.println(res);
    }

    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int res = 0;
        int score = 0;
        int l = 0, r = tokens.length - 1;
        while (l <= r) {
            if (power >= tokens[l]) {
                power -= tokens[l];
                score += 1;
                l++;
            } else if (score > 0) {
                power += tokens[r];
                score -= 1;
                r--;
            } else {
                break;
            }
            res = Math.max(res, score);
        }
        return res;
    }
}
