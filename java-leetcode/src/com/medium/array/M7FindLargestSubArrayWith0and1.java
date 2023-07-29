package com.medium.array;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given a binary array containing 0’s and 1’s, find the largest subArray with equal numbers of 0’s and 1’s.
 *
 *
 * Input:  { 0, 0, 1, 0, 1, 0, 0 }
 *
 * Output: Largest subArray is { 0, 1, 0, 1 } or { 1, 0, 1, 0 }
 *
 */
public class M7FindLargestSubArrayWith0and1 {

    public static void main(String[] args) {
        int[] arr = { 0, 0, 1, 0, 1, 1, 0 };
        indLargestSubArrayWith0And1(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void indLargestSubArrayWith0And1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = -1;
            }
        }

        int currSum = 0;
        int end = -1;
        int max = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];

            if (currSum == 0) {
                if (max < i - map.get(currSum)) {
                    max = i - map.get(currSum);
                    end = i;
                }
            }

            if (map.containsKey(currSum)) {
                if (max < i - map.get(currSum)) {
                    max = i - map.get(currSum);
                    end = i;
                }
            } else {
                map.put(currSum, i);
            }
        }
        System.out.println("[" + (end - max + 1) + "..." + end + "]");
    }
}
