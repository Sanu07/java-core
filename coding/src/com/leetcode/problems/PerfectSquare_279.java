package com.leetcode.problems;

public class PerfectSquare_279 {

    /**
     * https://leetcode.com/problems/perfect-squares/description/
     *
     * Given an integer n, return the least number of perfect square numbers that sum to n.
     *
     * A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
     *
     *
     *
     * Example 1:
     *
     * Input: n = 12
     * Output: 3
     * Explanation: 12 = 4 + 4 + 4.
     * Example 2:
     *
     * Input: n = 13
     * Output: 2
     * Explanation: 13 = 4 + 9.
     *
     *
     * Constraints:
     *
     * 1 <= n <= 104
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        int num = 7;
        int total = new PerfectSquare_279().perfectSquare(num);
        System.out.println(total);
    }

    int memo[] = new int[10001];
    private int perfectSquare(int n) {
        if (n < 0) {
            return Integer.MAX_VALUE;
        }
        if (n <= 3) {
            return n;
        }
//        if (memo[n] != 0) {
//            return memo[n];
//        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            min = Math.min(min, 1 + perfectSquare(n - (i * i)));
            System.out.printf("i -> %s :: (i*i) -> %s :: n -> %s :: min -> %s%n", i, (i * i), n, min);
        }
        return memo[n]=min;
    }
}
