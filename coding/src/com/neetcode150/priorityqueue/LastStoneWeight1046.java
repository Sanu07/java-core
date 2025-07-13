package com.neetcode150.priorityqueue;

import java.util.Arrays;
import java.util.Comparator;

public class LastStoneWeight1046 {

    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        int weight = stones[stones.length - 1];
        for (int i = stones.length - 2; i >= 0; i--) {
            weight = Math.abs(weight - stones[i]);
        }
        return weight;
    }

    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        int res = new LastStoneWeight1046().lastStoneWeight(stones);
        System.out.println(res);
    }
}
