package com.neetcode150.priorityqueue;

import java.util.*;

public class TaskScheduler621 {

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char task: tasks) {
            if (freqMap.containsKey(task)) {
                freqMap.put(task, freqMap.get(task) + 1);
            } else {
                freqMap.put(task, 1);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.addAll(freqMap.values());

        int time = 0;
        while (!pq.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            // cycle (n + 1)
            for (int i = 0; i < (n + 1); i++) {
                if (!pq.isEmpty()) {
                    temp.add(pq.poll());
                }
            }

            for (int t: temp) {
                t--;
                if (t > 0) {
                    pq.add(t);
                }
            }

            time += pq.isEmpty() ? temp.size() : (n + 1);
        }
        return time;
    }

    public static void main(String[] args) {
        char[] tasks = {'A','A', 'A', 'B', 'B', 'B'};
        int k = 2;

        int res = new TaskScheduler621().leastInterval(tasks, k);
        System.out.println(res);
    }
}
