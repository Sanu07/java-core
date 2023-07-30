package com.medium.array;

import java.util.Arrays;

/**
 *
 * Given two sorted arrays, X[] and Y[] of size m and n each, merge elements of X[] with elements of array Y[]
 * by maintaining the sorted order, i.e., fill X[] with the first m smallest elements and fill Y[]
 * with remaining elements.
 *
 * Do the conversion in-place and without using any other data structure.
 *
 * Input:
 *
 * X[] = { 1, 4, 7, 8, 10 }
 * Y[] = { 2, 3, 9 }
 *
 * Output:
 *
 * X[] = { 1, 2, 3, 4, 7 }
 * Y[] = { 8, 9, 10 }
 *
 */
public class M10InPlaceMerge2SortedArrays {

    public static void main(String[] args) {
        int[] X = { 1, 4, 7, 8, 10 };
        int[] Y = { 2, 3, 9 };

        inPlaceMerge(X, Y);

        System.out.println(Arrays.toString(X));
        System.out.println(Arrays.toString(Y));
    }

    private static void inPlaceMerge(int[] x, int[] y) {
        for (int i = 0; i < x.length; i++) {
            if (x[i] > y[0]) {
                swap(x, y, i, 0);
            }
            for (int j = 0; j < y.length - 1; j++) {
                if (y[j] > y[j + 1]) {
                    int temp = y[j];
                    y[j] = y[j + 1];
                    y[j + 1] = temp;
                }
            }
        }
    }

    private static void swap(int[] X, int[] Y, int x_i, int y_i) {
        int temp = X[x_i];
        X[x_i] = Y[y_i];
        Y[y_i] = temp;
    }
}
