package com.neetcode150.arrays;

import java.util.*;

public class TopKFreqElements {

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        TopKFreqElements topKFreqElements = new TopKFreqElements();
        int[] res = topKFreqElements.topK(nums, k);
        System.out.println(Arrays.toString(res));
    }

    private int[] topK(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> pq =
                new PriorityQueue<>(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        for (int x: nums) {
            cnt.merge(x, 1, Integer::sum);
        }
        int[] res = cnt.entrySet().stream()
                .peek(pq::add)
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
        return res;
    }
}
