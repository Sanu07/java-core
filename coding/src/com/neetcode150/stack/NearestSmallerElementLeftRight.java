package com.neetcode150.stack;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerElementLeftRight {

    public static void main(String[] args) {
        int[] nums = {4, 10, 5, 8, 20, 15, 3, 12};
        int[] res = pse(nums);
        System.out.println(Arrays.toString(res));

        int[] nse = nse(nums);
        System.out.println(Arrays.toString(nse));
    }

    public static int[] pse(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && stack.peek() > nums[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }

    public static int[] nse(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() > nums[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }
}
