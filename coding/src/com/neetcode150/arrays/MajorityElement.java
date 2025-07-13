package com.neetcode150.arrays;

public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        MajorityElement majorityElement = new MajorityElement();
        int val = majorityElement.majorityElement(nums);
        System.out.println(val);
    }

    public int majorityElement(int[] nums) {
        int c = 1;
        int val = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == val) {
                c++;
            } else {
                c--;
            }
            if (c == 0) {
                val = nums[i];
                c = 1;
            }
        }
        return val;
    }
}
