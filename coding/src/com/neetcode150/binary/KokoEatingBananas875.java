package com.neetcode150.binary;

class KokoEatingBananas875 {

    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h = 8;
        int res = new KokoEatingBananas875().minEatingSpeed(piles, h);
        System.out.println(res);
    }


    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }

        int l = 1, r = max;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (isPossible(piles, mid, h)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean isPossible(int[] nums, int speed, int h) {
        int time = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while (num > speed) {
                num -= speed;
                time += 1;
            }
            time += 1;
        }
        return time <= h;
    }
}