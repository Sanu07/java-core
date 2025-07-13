package com.practice;

public class LongestIdentityMatrix {

    // Function to find the starting position of the longest identity matrix
    public static int[] findLongestIdentityMatrix(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        // DP table to store the size of the largest identity matrix ending at (i, j)
        int[][] dp = new int[rows][cols];
        int maxLength = 0;
        int startX = -1;
        int startY = -1;

        // Fill the DP table
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        // First row or first column, identity matrix can only be of size 1
                        dp[i][j] = 1;
                    } else {
                        // Use the recurrence relation to compute dp[i][j]
                        dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]) + 1;
                    }
                    
                    // If we found a larger identity matrix, update maxLength and starting position
                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        startX = i - maxLength + 1;
                        startY = j - maxLength + 1;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        // Return the starting position of the longest identity matrix
        return new int[]{startX, startY};
    }

    public static void main(String[] args) {
        // Example grid
        int[][] grid = {
            {5, 0, 0, 0, 0},
            {0, 5, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0},
            {0, 0, 0, 8, 1}
        };

        int[] result = findLongestIdentityMatrix(grid);
        System.out.println("Starting position of the longest identity matrix: (" + result[0] + ", " + result[1] + ")");
    }
}
