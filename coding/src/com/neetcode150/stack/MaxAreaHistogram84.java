package com.neetcode150.stack;

import java.util.Stack;

public class MaxAreaHistogram84 {

    public static void main(String[] args) {
        int[] heights = {1, 1};
        int area = new MaxAreaHistogram84().largestRectangleArea(heights);
        System.out.println(area);
    }

    public int largestRectangleArea(int[] heights) {
        int[] pse = pse(heights);
        int[] nse = nse(heights);

        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, Math.abs(nse[i] - pse[i] - 1) * heights[i]);
        }
        return maxArea;
    }

    public int[] pse(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return res;
    }

    public int[] nse(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? nums.length : stack.peek();
            stack.push(i);
        }
        return res;
    }
}
