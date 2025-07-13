package com.leetcode.problems;

import java.util.Arrays;

public class SubsequencesWithGiveSum_1498 {

    public static void main(String[] args) {
        int[] nums = {3, 5, 6, 7};
        SubsequencesWithGiveSum_1498 subsequencesWithGiveSum1498 = new SubsequencesWithGiveSum_1498();
        int numSubseq = subsequencesWithGiveSum1498.numSubseq(nums, 9);
        System.out.println(numSubseq);
    }

    public int numSubseq(int[] nums, int target) {
        final int kMod = 1_000_000_007;
        final int n = nums.length;
        int ans = 0;
        int[] pows = new int[n];
        pows[0] = 1;

        for (int i = 1; i < n; ++i)
            pows[i] = pows[i - 1] * 2 % kMod;

        Arrays.sort(nums);

        for (int l = 0, r = n - 1; l <= r;)
            if (nums[l] + nums[r] <= target) {
                ans += pows[r - l];
                ans %= kMod;
                ++l;
            } else {
                --r;
            }

        return ans;
    }
}
