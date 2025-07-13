package com.neetcode150.arrays;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubArraySumEqualsK {

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;
        SubArraySumEqualsK subArraySumEqualsK = new SubArraySumEqualsK();
        int res = subArraySumEqualsK.subarraySum(nums, k);
        System.out.println(res);
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
