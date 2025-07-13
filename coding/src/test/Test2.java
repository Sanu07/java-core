package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test2 {


    public static void main(String[] args) {
        List<int[]> nums = new ArrayList<>();
        nums.add(new int[] {1,2,5,4,3,6,7,8,9});
        nums.add(new int[] {5,4,3,6,7,8,9});
        nums.add(new int[] {2,5,3,6,7,8,9});
        nums.add(new int[] {2,5,3,6,7,9,8});

        for (int[] num: nums) {
            new Test2().arrange(num);
        }
    }



    private void arrange(int[] nums) {
        List<Pair> needsCorrection = new ArrayList<>();

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                Pair p = new Pair();
                p.start = i - 1;
                while (i + 1 < nums.length && nums[i] > nums[i + 1]) {
                    i++;
                }
                p.end = i;
                needsCorrection.add(p);
            }
        }


        for (Pair pair: needsCorrection) {
            reverse(nums, pair.start, pair.end);
        }

        System.out.println(Arrays.toString(nums));

    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }

    public static class Pair {
        int start;
        int end;
    }
}
