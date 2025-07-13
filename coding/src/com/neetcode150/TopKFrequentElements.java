package com.neetcode150;

import java.util.*;

public class TopKFrequentElements {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer> bucket[] = new ArrayList[nums.length + 1];

        for (int num : nums)
            count.merge(num, 1, Integer::sum);

        for (int key : count.keySet()) {
            int freq = count.get(key);
            if (bucket[freq] == null)
                bucket[freq] = new ArrayList<>();
            bucket[freq].add(key);
        }

        int index = 0;
        int[] res = new int[k];
        for (int i = nums.length; i >= 0; i--)
            if (bucket[i] != null)
                for (int val : bucket[i]) {
                    res[index++] = val;
                    if (index == k)
                        return res;
                }
        return res;
    }

    public int[] topKFrequent2(int[] nums, int k) {
         Map<Integer, Integer> cnt = new HashMap<>();
         for (int x : nums) {
             cnt.merge(x, 1, Integer::sum);
         }
        PriorityQueue<Map.Entry<Integer, Integer>> pq =
                new PriorityQueue<>((e1, e2) -> Integer.compare(e1.getValue(), e2.getValue()));
         for (var e : cnt.entrySet()) {
             pq.offer(e);
             if (pq.size() > k) {
                 pq.poll();
             }
         }
         return pq.stream().mapToInt(Map.Entry::getKey).toArray();
    }

    public static void main(String[] args) {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        int[] res = topKFrequentElements.topKFrequent(new int[]{1, 2, 2, 3, 3, 3}, 2);
        int[] res2 = topKFrequentElements.topKFrequent2(new int[]{1, 2, 2, 3, 3, 3}, 2);
        System.out.println(Arrays.toString(res));
        System.out.println("*".repeat(20));
        System.out.println(Arrays.toString(res2));
    }
}