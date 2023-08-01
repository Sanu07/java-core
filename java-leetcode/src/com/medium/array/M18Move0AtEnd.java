package com.medium.array;

import java.util.Arrays;

/**
 *
 * Given an integer array, move all zeros present in it to the end.
 * The solution should maintain the relative order of items in the array and should not use constant space.
 *
 * Input:  { 6, 0, 8, 2, 3, 0, 4, 0, 1 }
 *
 * Output: { 6, 8, 2, 3, 4, 1, 0, 0, 0 }
 *
 */
public class M18Move0AtEnd {

    public static void main(String[] args) {
        int[] arr = {  6, 0, 8, 2, 3, 0, 4, 0, 1 };
        move_zeroes_at_end(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void move_zeroes_at_end(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
            while (arr[i] != 0) {
                i++;
            }
            while (!(arr[j] > 0)) {
                j--;
            }
            if (i >= j) {
                break;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
