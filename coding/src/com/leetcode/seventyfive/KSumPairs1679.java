package com.leetcode.seventyfive;

import java.util.ArrayList;
import java.util.List;

public class KSumPairs1679 {

    public static void main(String[] args) {
        int maxedOperations = maxOperations(new int[]{1, 2, 3, 4}, 6);
        System.out.println(maxedOperations);
    }

    public static int maxOperations(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(k - nums[i])) {
                list.remove((Integer) k - nums[i]);
                count++;
            } else {
                list.add(nums[i]);
            }
        }
        return count;
    }
}
