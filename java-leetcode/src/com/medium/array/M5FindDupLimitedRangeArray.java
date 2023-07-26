package com.medium.array;

import java.util.Arrays;

/**
 * Given a limited range array of size n containing
 * elements between 1 and n-1 with one element repeating, find the duplicate number in it without using any extra space.
 *
 * Input:  { 1, 2, 3, 4, 4 }
 * Output: The duplicate element is 4
 *
 *
 * Input:  { 1, 2, 3, 4, 2 }
 * Output: The duplicate element is 2
 *
 */
public class M5FindDupLimitedRangeArray {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 4 };
        int duplicateElement = findDuplicate(arr);
        System.out.println(duplicateElement);
    }

    private static int findDuplicate(int[] arr) {
        int xor = 0;
        for (int value: arr) {
            xor ^= value;
        }

        for (int i = 1; i <= arr.length - 1; i++) {
            xor ^= i;
        }
        return xor;
    }
}
