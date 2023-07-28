package com.medium.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given an integer array, find the maximum length subarray having a given sum.
 *
 * nums[] = { 5, 6, -5, 5, 3, 5, 3, -2, 0 }
 * target = 8
 *
 *
 * Subarrays with sum 8 are
 *
 * { -5, 5, 3, 5 }
 * { 3, 5 }
 * { 5, 3 }
 *
 * The longest subarray is { -5, 5, 3, 5 } having length 4
 *
 */
public class M6FindMaxLengthSubArrayWithSum {

    public static void main(String[] args) {
        int[] arr = {5, 6, -5, 5, 3, 5, 3, -2, 0};
        int sum = 8;
        findSubArray(arr, sum);
    }

    private static void findSubArray(int[] arr, int sum) {
        int currSum = 0;
        int start = 0;
        int end = -1;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];

            if (currSum == sum) {
                end = i;
                break;
            }
            if (map.containsKey(currSum - sum)) {
                start = map.get(currSum - sum) + 1;
                end = i;
                break;
            }
            map.put(currSum, i);
        }

        if (end == -1) {
            System.out.println("SubArray not found");
        } else {
            final int[] result = Arrays.copyOfRange(arr, start, end + 1);
            System.out.println(Arrays.toString(result));
        }
    }
}
