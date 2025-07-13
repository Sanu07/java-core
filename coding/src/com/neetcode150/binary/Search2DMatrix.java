package com.neetcode150.binary;

public class Search2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };
        boolean b = new Search2DMatrix().searchMatrix(matrix, 3);
        System.out.println(b);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0;
        int r = m * n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            // row and cols are determined by mi & number of columns
            int row = mid / n;
            int col = mid % n;
            if (matrix[row][col] == target) {
                return true;
            } else if (target < matrix[row][col]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
}
