package com.dp.minmax;

import java.util.Arrays;

public class CoinChange322 {

    public static void main(String[] args) {
        CoinChange322 coinChange322 = new CoinChange322();
        int[] coins = {1,2};
        int amount = 3;
        int res = coinChange322.coinChange(coins, amount);
        System.out.println(res);
    }

    int[][] memo = null;
    public int coinChange(int[] coins, int amount) {
        memo = new int[coins.length][amount + 1];
        for (int[] row: memo) {
            Arrays.fill(row, -1);
        }
        int res = coinChange(coins, amount, 0);
        return res != Integer.MAX_VALUE ? res : -1;
    }

    public int coinChange(int[] coins, int amount, int n) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0 || n == coins.length) {
            return Integer.MAX_VALUE;
        }
        if (memo[n][amount] != -1) {
            return memo[n][amount];
        }
        int take;
        take = coinChange(coins, amount - coins[n], n);
        if (take != Integer.MAX_VALUE) {
            take++;
        }
        int noTake = coinChange(coins, amount, n + 1);
        return memo[n][amount] = Math.min(take, noTake);
    }

}
