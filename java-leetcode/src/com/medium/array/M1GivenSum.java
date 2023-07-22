package com.medium.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Input:
 *
 * nums = [8, 7, 2, 5, 3, 1]
 * target = 10
 *
 * Output:
 *
 * Pair found (8, 2)
 * or
 * Pair found (7, 3)
 *
 *
 * Input:
 *
 * nums = [5, 2, 6, 8, 1, 9]
 * target = 12
 *
 * Output: Pair not found
 */
public class M1GivenSum {
    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 8, 1, 9};
        int target = 11;
        final int[] pair = findPair(arr, target);
        System.out.println(Arrays.toString(pair));
    }

    private static int[] findPair(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(target - arr[i])) {
                return new int[] {arr[map.get(target - arr[i])], arr[i]};
            } else {
                map.put(arr[i], i);
            }
        }
        return null;
    }
}
