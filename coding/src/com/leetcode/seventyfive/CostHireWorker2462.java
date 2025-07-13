package com.leetcode.seventyfive;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class CostHireWorker2462 {

    public static void main(String[] args) {
        int[] costs1 = {17,12,10,2,7,2,11,20,8};
        long totalCost = totalCost2(costs1, 3, 4);
        System.out.println(totalCost);
    }

    public static long totalCost(int[] costs, int k, int candidates) {
        long sum = 0;
        List<Integer> list = Arrays.stream(costs).boxed().collect(Collectors.toList());
        while (k > 0) {
            if (list.size() < candidates) {
                sum += list.stream().mapToInt(Integer::intValue).min().getAsInt();
                k--;
                continue;
            }

            int l = 0, r = list.size() - 1;
            int lIndex = -1;
            int lMin = Integer.MAX_VALUE;
            while (l < candidates) {
                if (list.get(l) < lMin) {
                    lMin = list.get(l);
                    lIndex = l;
                }
                l++;
            }
            int rIndex = -1;
            int rMin = Integer.MAX_VALUE;
            while ((list.size() - 1 - r) < candidates) {
                if (list.get(r) < rMin) {
                    rMin = list.get(r);
                    rIndex = r;
                }
                r--;
            }
            if (lMin < rMin) {
                sum += lMin;
                list.remove(lIndex);
            } else if (lMin == rMin) {
                if (lIndex <= rIndex) {
                    sum += lMin;
                    list.remove(lIndex);
                } else {
                    sum += rMin;
                    list.remove(rIndex);
                }
            } else {
                sum += rMin;
                list.remove(rIndex);
            }
            k--;
        }
        return sum;
    }

    public static long totalCost2(int[] costs, int k, int candidates) {
        int i = 0;
        int j = costs.length - 1;
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        long ans = 0;
        while (k-- > 0) {
            while (pq1.size() < candidates && i <= j) {
                pq1.offer(costs[i++]);
            }
            while (pq2.size() < candidates && i <= j) {
                pq2.offer(costs[j--]);
            }

            int t1 = pq1.size() > 0 ? pq1.peek() : Integer.MAX_VALUE;
            int t2 = pq2.size() > 0 ? pq2.peek() : Integer.MAX_VALUE;

            if (t1 <= t2) {
                ans += t1;
                pq1.poll();
            } else {
                ans += t2;
                pq2.poll();
            }
        }
        return ans;
    }
}
