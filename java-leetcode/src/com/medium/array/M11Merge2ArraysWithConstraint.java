package com.medium.array;

import java.util.Arrays;

/**
 *
 *
 * Given two sorted arrays X[] and Y[] of size m and n each where m >= n and X[] has exactly
 * n vacant cells, merge elements of Y[] in their correct position in array X[], i.e.,
 * merge (X, Y) by keeping the sorted order.
 *
 *Input:
 *
 * X[] = { 0, 2, 0, 3, 0, 5, 6, 0, 0 }
 * Y[] = { 1, 8, 9, 10, 15 }
 *
 * The vacant cells in X[] is represented by 0
 *
 * Output:
 *
 * X[] = { 1, 2, 3, 5, 6, 8, 9, 10, 15 }
 *
 */
public class M11Merge2ArraysWithConstraint {

    public static void main(String[] args) {
        int[] x = { 0, 2, 0, 3, 0, 5, 6, 0, 0 };
        int[] y = { 1, 8, 9, 10, 15 };
        mergeYIntoX(x, y);
        System.out.println(Arrays.toString(x));
    }

    private static void mergeYIntoX(int[] x, int[] y) {
        int j = 0;
        int k = 0;

        for (int i = 0; i < x.length;) {

            while (i < x.length && x[i] != 0) {
                i++;
            }
            j = i;

            while (j < x.length && !(x[j] > 0)) {
                j++;
            }

            if (j >= x.length) {
                for (; i < x.length; i++) {
                    x[i] = y[k++];
                }
                break;
            }

            if (x[j] > y[k]) {
                x[i] = y[k];
                k++;
            } else {
                x[i] = x[j];
                x[j] = 0;
            }
        }
    }
}
