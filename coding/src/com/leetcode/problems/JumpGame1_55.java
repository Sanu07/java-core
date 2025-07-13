package com.leetcode.problems;

public class JumpGame1_55 {

    public static void main(String[] args) {
        JumpGame1_55 jumpGame245 = new JumpGame1_55();
        int[] nums = {3,2,1,0,4};
        boolean jump = jumpGame245.jump(nums);
        System.out.println(jump);
    }

    public boolean jump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }
}
