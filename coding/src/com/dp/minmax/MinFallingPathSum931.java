package com.dp.minmax;

import java.util.Arrays;

public class MinFallingPathSum931 {

    public static void main(String[] args) {
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        // int[][] matrix = {{-19, 57},{-40, -5}};
        MinFallingPathSum931 minFallingPathSum931 = new MinFallingPathSum931();
        int res = minFallingPathSum931.minFallingPathSum(matrix);
        System.out.println(res);
    }


    int[][] memo = null;
    public int minFallingPathSum(int[][] matrix) {
        this.memo = new int[matrix.length][matrix[0].length];
        for (int[] row: memo) {
            Arrays.fill(row, -1);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            ans = Math.min(ans, minFallingPathSum(matrix, 0, i));
        }
        return ans;
    }

    public int minFallingPathSum(int[][] matrix, int row, int col) {
        if (row >= matrix.length) {
            return 0;
        }
        if (col < 0 || col >= matrix[0].length) {
            return Integer.MAX_VALUE;
        }
        if (memo[row][col] != -1) {
            return memo[row][col];
        }
        return memo[row][col] = matrix[row][col] + Math.min(minFallingPathSum(matrix, row + 1, col - 1),
                Math.min(minFallingPathSum(matrix, row + 1, col),
                        minFallingPathSum(matrix, row + 1, col + 1)));
    }
}
