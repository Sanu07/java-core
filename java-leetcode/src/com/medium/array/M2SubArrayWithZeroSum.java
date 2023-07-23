package com.medium.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Input:  { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 }
 *
 * Output: Subarray with zero-sum exists (return True/False)
 *
 * The subarrays with a sum of 0 are:
 *
 * { 3, 4, -7 }
 * { 4, -7, 3 }
 * { -7, 3, 1, 3 }
 * { 3, 1, -4 }
 * { 3, 1, 3, 1, -4, -2, -2 }
 * { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 }
 */
public class M2SubArrayWithZeroSum {
    public static void main(String[] args) {
        int[] arr = {4, -6, 3, -1, 4, 2, 7};
        boolean hasZeroSum = hasZeroSum(arr);
        System.out.println(hasZeroSum);
    }

    private static boolean hasZeroSum(int[] arr) {
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        set.add(0);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (!set.add(sum)) {
                return true;
            }
        }
        return false;
    }
}
