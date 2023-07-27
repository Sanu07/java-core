package com.medium.array;

import java.util.Arrays;

/**
 *
 * Given an array containing only 0’s, 1’s, and 2’s, sort it in linear time and using constant space.
 *
 * Input:  { 0, 1, 2, 2, 1, 0, 0, 2, 0, 1, 1, 0 }
 *
 * Output: { 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2 }
 *
 */
public class M9Sort1N2N3DutchNationalFlag {

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 2, 1, 0, 0, 2, 0, 1, 1, 0};
        sortDutchNationalFlag(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sortDutchNationalFlag(int[] arr) {
        int pivot = 1, start = 0, mid = 0, end = arr.length - 1;
        while (mid <= end) {
            if (arr[mid] < pivot) {
                swap(arr, start, mid);
                mid++;
                start++;
            } else if (arr[mid] > pivot) {
                swap(arr, mid, end);
                end--;
            } else {
                mid++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
