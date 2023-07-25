package com.medium.array;

import java.util.Arrays;

/**
 *
 * Given a binary array, sort it in linear time and constant space. The output should print all zeroes, followed by all ones.
 *
 * Input:  { 1, 0, 1, 0, 1, 0, 0, 1 }
 *
 * Output: { 0, 0, 0, 0, 1, 1, 1, 1 }
 */
public class M4SortBinaryArrLinearTime {
    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 0, 1, 0, 0, 1};
        sortBinaryArray(arr);
        System.out.println(Arrays.toString(arr));
}

    private static void sortBinaryArray(int[] arr) {
        int i = 0;
        int j = 0;
        while (i < arr.length && j < arr.length) {
            while (i < arr.length && arr[i] != 1) {
                i++;
            }
            while (j < arr.length && arr[j] != 0) {
                j++;
            }
            if (i >= arr.length || j >= arr.length) {
                break;
            }
            swap(arr, i, j);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
