package com.leetcode.blind75;

import java.util.ArrayList;
import java.util.List;

public class Blind75 {
    public static void main(String[] args) {
        Blind75 blind75 = new Blind75();
        System.out.println("****** 11. Container With Most Water *******");
        int maxArea = blind75.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(maxArea);
        System.out.println("---------------------------------------------");

        System.out.println("****** 190. Reverse Bits *******");
        int reversedBit = blind75.reverseBits(4293);
        System.out.println(reversedBit);
        System.out.println("---------------------------------------------");


    }

    public int maxArea(int[] height) {
        int right = height.length - 1;
        int left = 0;
        int max = 0;
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public int reverseBits(int n) {
        List<Integer> nums = new ArrayList<>();
        while (n != 0) {
            int rem = n % 2;
            nums.add(rem);
            n = n / 2;
        }
        while (nums.size() != 32) {
            nums.add(0);
        }
        int powerCounter = nums.size() - 1;
        int res = 0;
        for (int i = 0; i < nums.size(); i++) {
            res += (int) (Math.pow(2, powerCounter--) * nums.get(i));
        }
        return res;
    }
}
