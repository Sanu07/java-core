package com.leetcode.problems;

public class JumpGame2_45 {

    public static void main(String[] args) {
        JumpGame2_45 jumpGame245 = new JumpGame2_45();
        int[] nums = {2, 3, 1, 4, 1, 1, 1, 2};
        int jump = jumpGame245.jump(nums);
        System.out.println(jump);
    }

    public int jump(int[] nums) {
        int jumps = 0;
        int l = 0, r = 0;

        while (r < nums.length - 1) {
            int farthest = Integer.MIN_VALUE;
            for (int i = l; i <= r; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            l = r + 1;
            r = farthest;
            jumps += 1;
        }
        return jumps;
    }
}
