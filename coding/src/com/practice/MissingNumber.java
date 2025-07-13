package com.practice;

public class MissingNumber {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while(i < nums.length){
            int curr = nums[i] - 1;
            if(curr >= 0 && curr < nums.length && nums[i] != nums[curr]){
                swap(nums, i, curr);
            }
            else{
                i++;
            }
        }
        for (int j=0; j<nums.length; j++){
            if(nums[j] != j+1){
                return j+1;
            }
        }
        return nums.length+1;
    }
    private static void swap(int[] arr, int i,  int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        MissingNumber missingNumber = new MissingNumber();
        int i = missingNumber.firstMissingPositive(nums);
        System.out.println(i);
    }
}