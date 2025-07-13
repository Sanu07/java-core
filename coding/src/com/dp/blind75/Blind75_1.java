package com.dp.blind75;

import java.util.Arrays;

public class Blind75_1 {

    public static void main(String[] args) {

        climbingStairs_70();

    }

    // You are climbing a staircase. It takes n steps to reach the top.
    //
    //Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
    // https://leetcode.com/problems/climbing-stairs/description/
    // Input: n = 2
    //Output: 2
    //Explanation: There are two ways to climb to the top.
    //1. 1 step + 1 step
    //2. 2 steps
    private static void climbingStairs_70() {
        int n = 5;
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        int ways = climbingStairs(n, memo);
        System.out.println(ways);
    }

    private static int climbingStairs(int n, int[] memo) {
        if (n <= 2) {
            return n;
        }
        if (memo[n] != -1) {
            return memo[n];
        }
        return memo[n] = climbingStairs(n - 1, memo) + climbingStairs(n - 2, memo);
    }
}
