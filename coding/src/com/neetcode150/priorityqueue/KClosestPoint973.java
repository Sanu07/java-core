package com.neetcode150.priorityqueue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPoint973 {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> square(b.pointX, b.pointY) - square(a.pointX, a.pointY));

        for (int i = 0; i < k; i++) {
            pq.add(new Pair(points[i][0], points[i][1]));
        }

        for (int i = k; i < points.length; i++) {
            Pair pair = new Pair(points[i][0], points[i][1]);
            int pairDist = square(pair.pointX, pair.pointY);
            Pair pqTopElem = pq.peek();
            int pqDist = square(pqTopElem.pointX, pqTopElem.pointY);
            if (pairDist < pqDist) {
                pq.poll();
                pq.add(pair);
            }
        }

        int[][] ans = new int[k][2];
        int index = 0;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            ans[index][0] = p.pointX;
            ans[index][1] = p.pointY;
            index++;
        }
        return ans;
    }

    private int square(int x, int y) {
        return (x * x) + (y * y);
    }

    public static void main(String[] args) {
        int[][] points = {
                {3,3},
                {5,-1},
                {-2,4}
        };
        int k = 2;
        int[][] res = new KClosestPoint973().kClosest(points, k);
        System.out.println(Arrays.deepToString(res));
    }

    class Pair {
        int pointX;
        int pointY;

        public Pair(int pointX, int pointY) {
            this.pointX = pointX;
            this.pointY = pointY;
        }
    }
}
