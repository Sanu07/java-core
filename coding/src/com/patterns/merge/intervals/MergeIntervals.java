package com.patterns.merge.intervals;

import com.graph.Pair;

import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();


        boolean b = mergeIntervals.carPooling(new int[][]{{3,2,8}, {4,4,6}, {10,8,9}}, 11);
        System.out.println(b);
    }


    // Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
    // and return an array of the non-overlapping intervals that cover all the intervals in the input.
    // Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
    // Output: [[1,6],[8,10],[15,18]]
    // https://leetcode.com/problems/merge-intervals/description/
    public int[][] merge(int[][] intervals) {

        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (current[1] >= interval[0]) {
                current[1] = Math.max(interval[1], current[1]);
            } else {
                res.add(current);
                current = interval;
            }
        }
        res.add(current);
        return res.toArray(new int[res.size()][]);
    }

    // You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
    //
    //Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
    //
    //Return intervals after the insertion.
    //
    //Note that you don't need to modify intervals in-place. You can make a new array and return it.
    // Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
    // Output: [[1,5],[6,9]]
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> intervalList = new ArrayList<>(Arrays.asList(intervals));
        intervalList.add(newInterval);
        List<int[]> res = new ArrayList<>();
        Collections.sort(intervalList, (a, b) -> Integer.compare(a[0], b[0]));

        int[] current = intervalList.get(0);
        for (int i = 1; i < intervalList.size(); i++) {
            int[] interval = intervalList.get(i);
            if (current[1] >= interval[0]) {
                current[1] = Math.max(current[1], interval[1]);
            } else {
                res.add(current);
                current = interval;
            }
        }
        res.add(current);
        return res.toArray(new int[res.size()][]);
    }

    // You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi] and secondList[j] = [startj, endj]. Each list of intervals is pairwise disjoint and in sorted order.
    //
    // Return the intersection of these two interval lists.
    //
    // A closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.
    //
    // The intersection of two closed intervals is a set of real numbers that are either empty or represented as a closed interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].
    // Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
    // Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
    // https://leetcode.com/problems/interval-list-intersections/description/
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        // initialize the pointers
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {

            int s1 = firstList[i][0];
            int e1 = firstList[i][1];
            int s2 = secondList[j][0];
            int e2 = secondList[j][1];
            // case 1: a & b overlaps. A ends after B
            // case 2: a & b overlaps. B ends after A
            // case 3: a & b are mutually exclusive i.e -> no intersection point
            if ((s2 >= s1 && s2 <= e1) || (s1 >= s2 && s1 <= e2)) {
                // [max(s1, s2), min(e1, e2)]
                int s = Math.max(s1, s2);
                int e = Math.min(e1, e2);
                res.add(new int[]{s, e});
            }
            // move the pointer for the intervl which is less
            if (e1 < e2) {
                i++;
            } else {
                j++;
            }
        }
        return res.toArray(new int[res.size()][2]);
    }


    // There is a car with capacity empty seats. The vehicle only drives east (i.e., it cannot turn around and drive west).
    //
    //You are given the integer capacity and an array trips where trips[i] = [numPassengersi, fromi, toi] indicates that the ith trip has numPassengersi passengers and the locations to pick them up and drop them off are fromi and toi respectively. The locations are given as the number of kilometers due east from the car's initial location.
    //
    //Return true if it is possible to pick up and drop off all passengers for all the given trips, or false otherwise.
    // Input: trips = [[2,1,5],[3,3,7]], capacity = 4
    //Output: false
    // https://leetcode.com/problems/car-pooling/description/
    public boolean carPooling(int[][] trips, int capacity) {
        int curPass = 0;
        Arrays.sort(trips, (a, b) -> Integer.compare(a[1], b[1]));
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(a -> a.end));
        for (int i = 0; i < trips.length; i++) {
            Map<Integer, Integer> entry = null;

            while (!pq.isEmpty() && pq.peek().end <= trips[i][1]) {
                curPass -= pq.poll().passenger;
            }

            curPass += trips[i][0];
            if (curPass > capacity) {
                return false;
            }
            pq.add(new Pair(trips[i][2], trips[i][0]));
        }
        return true;
    }

    private static class Pair {
        int end;
        int passenger;

        public Pair(int end, int passenger) {
            this.end = end;
            this.passenger = passenger;
        }
    }
}
