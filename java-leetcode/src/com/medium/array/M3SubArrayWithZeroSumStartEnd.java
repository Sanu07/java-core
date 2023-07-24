package com.medium.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Input:  { 4, 2, -3, -1, 0, 4 }
 *
 * Subarrays with zero-sum are
 *
 * { -3, -1, 0, 4 }
 * { 0 }
 *
 *
 * Input:  { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 }
 *
 * Subarrays with zero-sum are
 *
 * { 3, 4, -7 }
 * { 4, -7, 3 }
 * { -7, 3, 1, 3 }
 * { 3, 1, -4 }
 * { 3, 1, 3, 1, -4, -2, -2 }
 * { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 }
 */
public class M3SubArrayWithZeroSumStartEnd {
    public static void main(String[] args) {
        int[] arr = { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 };
        printAllSubArrays(arr);
    }

    private static void printAllSubArrays(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;
        final ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(-1);
        map.put(0, list1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                final List<Integer> list = map.get(sum);
                for (Integer num: list) {
                    System.out.println("[" + (num + 1) + "..." + i + "]");
                }
            }
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }
    }
}
