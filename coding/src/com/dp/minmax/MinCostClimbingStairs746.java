package com.dp.minmax;

public class MinCostClimbingStairs746 {
    public static void main(String[] args) {
        MinCostClimbingStairs746 minCostClimbingStairs746 = new MinCostClimbingStairs746();
        int[] cost = {10, 15, 20};
        int result = minCostClimbingStairs746.minCostClimbingStairs(cost);
        System.out.println(result);
    }

    public int minCostClimbingStairs(int[] cost) {
        this.memo = new int[cost.length + 1];
        int zeroIndex = minCostClimbingStairs(cost, 0);
        System.out.println(zeroIndex);
        int oneIndex = minCostClimbingStairs(cost, 1);
        System.out.println(oneIndex);
        return Math.min(zeroIndex, oneIndex);
    }

    int[] memo = null;

    public int minCostClimbingStairs(int[] cost, int n) {
        if (n >= cost.length) {
            return 0;
        }
        int n_1 = minCostClimbingStairs(cost, n + 1);
        int n_2 = minCostClimbingStairs(cost, n + 2);
        int result = cost[n] + Math.min(n_1, n_2);
        return result;
    }
}
