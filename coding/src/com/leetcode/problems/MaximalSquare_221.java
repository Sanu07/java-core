package com.leetcode.problems;

public class MaximalSquare_221 {

    public static void main(String[] args) {
        MaximalSquare_221 maximalSquare221 = new MaximalSquare_221();
        char[][] array = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        char[][] array2 = {
                {'1', '1'},
                {'1', '1'}
        };
        int maxArea = maximalSquare221.maximalSquare(array2);
        System.out.println(maxArea);
    }

    public int maximalSquare2(char[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    int currRightCount = 0;
                    int maxRightCount = 1;
                    int down = i;
                    while (down < matrix.length && matrix[down][j] == '1') {
                        int right = j;
                        while (right < matrix[0].length && matrix[down][right] == '1') {
                            currRightCount++;
                            right++;
                        }
                        maxRightCount = Math.min(maxRightCount, currRightCount);
                        currRightCount = 0;
                        down++;
                    }
                    int min = Math.min(down - i, maxRightCount);
                    max = Math.max(max, min * min);
                }
            }
        }
        return max;
    }


    public int maxSquareSize(char[][] matrix, int i, int j) {
        // Base case: Out of bounds or cell is '0'
        if (i < 0 || j < 0 || matrix[i][j] == '0') {
            return 0;
        }

        // Recursively find the size of the square ending at (i-1, j), (i, j-1), (i-1, j-1)
        System.out.printf("Left :: i -> %d j -> %d \n", i, j);
        int left = maxSquareSize(matrix, i, j - 1);
        System.out.printf("LEFT :: %d\n", left);

        System.out.printf("UP :: i -> %d j -> %d \n", i, j);
        int up = maxSquareSize(matrix, i - 1, j);
        System.out.printf("UP :: %d\n", up);

        System.out.printf("DIAG :: i -> %d j -> %d \n", i, j);
        int diagonal = maxSquareSize(matrix, i - 1, j - 1);
        System.out.printf("DIAG :: %d\n", diagonal);

        // The side length of the square ending at (i, j) is the minimum of the three neighbors + 1
        return Math.min(Math.min(left, up), diagonal) + 1;
    }

    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;

        int m = matrix.length;
        int n = matrix[0].length;

        // Traverse each cell and compute the maximal square size ending at that cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If matrix[i][j] is '1', calculate the maximum square size
                if (matrix[i][j] == '1') {
                    int squareSize = maxSquareSize(matrix, i, j);
                    // Update maxSide with the largest square found so far
                    System.out.printf("square size for i -> %d j -> %d :::::: %d\n", i, j, squareSize);
                    maxSide = Math.max(maxSide, squareSize);
                }
            }
        }

        // Return the area of the largest square found
        return maxSide * maxSide;
    }
}
