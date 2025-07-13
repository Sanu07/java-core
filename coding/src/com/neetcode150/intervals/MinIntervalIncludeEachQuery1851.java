package com.neetcode150.intervals;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinIntervalIncludeEachQuery1851 {

    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = queries.length;
        int[] result = new int[n];

        // Store the original indices of queries for correct answer order
        Integer[] queryIndices = new Integer[n];
        for (int i = 0; i < n; i++) {
            queryIndices[i] = i;
        }

        // Sort intervals by starting point, and by size if starting points are the same
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Sort queries and maintain their original indices
        Arrays.sort(queryIndices, (a, b) -> Integer.compare(queries[a], queries[b]));

        // Min-heap to store intervals based on size
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1] - a[0], b[1] - b[0]));

        int intervalIndex = 0;

        // Process each query in sorted order
        for (int i = 0; i < n; i++) {
            int query = queries[queryIndices[i]];

            // Add all intervals that start before or at the query to the heap
            while (intervalIndex < intervals.length && intervals[intervalIndex][0] <= query) {
                int left = intervals[intervalIndex][0];
                int right = intervals[intervalIndex][1];

                // Add only intervals that can contain the query
                if (right >= query) {
                    minHeap.offer(new int[]{left, right});
                }
                intervalIndex++;
            }

            // Remove intervals that end before the query point
            while (!minHeap.isEmpty() && minHeap.peek()[1] < query) {
                minHeap.poll();
            }

            // Store the result for this query
            if (minHeap.isEmpty()) {
                result[queryIndices[i]] = -1;
            } else {
                int[] smallestInterval = minHeap.peek();
                result[queryIndices[i]] = smallestInterval[1] - smallestInterval[0] + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = {
                {1, 4},
                {2, 4},
                {3, 6},
                {4, 4}
        };
        int[] queries = {2, 6, 4, 5};
        int[] res = new MinIntervalIncludeEachQuery1851().minInterval(intervals, queries);
        System.out.println(Arrays.toString(res));
    }
}
